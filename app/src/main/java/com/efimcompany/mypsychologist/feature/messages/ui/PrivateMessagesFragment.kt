package com.efimcompany.mypsychologist.feature.messages.ui

import androidx.fragment.app.Fragment
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.efimcompany.mypsychologist.R
import com.efimcompany.mypsychologist.feature.messages.presentation.PrivateMessageAdapter
import com.efimcompany.mypsychologist.feature.psihologist.ui.getCommonModel
import com.efimcompany.mypsychologist.models.CommonModel
import com.efimcompany.mypsychologist.utilits.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ServerValue
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_private_messages.*

class PrivateMessagesFragment(private val contact:CommonModel) : Fragment(R.layout.fragment_private_messages) {

    private lateinit var mRefMessages:DatabaseReference
    private lateinit var mAdapter: PrivateMessageAdapter
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mMessageListener: AppValueEventListener
    private var mListMessages = emptyList<CommonModel>()

    override fun onStart() {
        super.onStart()
        activity?.linearLayout?.isVisible = false

        tv_headerNameUser.text = contact.name

        btn_enter_SMS.setOnClickListener {
            if (et_SMS.text.isEmpty()) {
                showToast("Введите сообщение!")
            } else {
                enterSMS(et_SMS.text.toString(), contact.id, TYPE_TEXT) {
                    et_SMS.setText("")
                }
            }
        }

        initRecycleView()
    }

    private fun initRecycleView(){
        mRecyclerView = rv_private_message
        mAdapter = PrivateMessageAdapter()
        mRefMessages = REF_DATABASE_ROOT
            .child(NODE_MESSAGES)
            .child(USER.id)
            .child(contact.id)

        with(mRecyclerView) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = mAdapter
        }
        mMessageListener = AppValueEventListener { dataSnapshot ->
            mListMessages = dataSnapshot.children.map { it.getCommonModel() }
            mAdapter.setList(mListMessages)
            mRecyclerView.smoothScrollToPosition(mAdapter.itemCount)
        }
        mRefMessages.addValueEventListener(mMessageListener)
    }

    private fun enterSMS(
        message: String,
        receivingUserID: String,
        typeMessage: String,
        function: () -> Unit
    ) {

        val refDialogUser = "$NODE_MESSAGES/${USER.id}/$receivingUserID"
        val refDialogReceivingUser = "$NODE_MESSAGES/$receivingUserID/${USER.id}"

        val messageKey = REF_DATABASE_ROOT.child(refDialogUser).push().key

        val mapMessage = hashMapOf<String, Any>()
        mapMessage[CHILD_FROM] = USER.id
        mapMessage[CHILD_TYPE] = typeMessage
        mapMessage[CHILD_TEXT] = message
        mapMessage[CHILD_TIME] = ServerValue.TIMESTAMP

        val mapDialog = hashMapOf<String, Any>()
        mapDialog["$refDialogUser/$messageKey"] = mapMessage
        mapDialog["$refDialogReceivingUser/$messageKey"] = mapMessage

        REF_DATABASE_ROOT
            .updateChildren(mapDialog)
            .addOnSuccessListener { function() }
            .addOnFailureListener { showToast(it.message.toString()) }

    }

    override fun onPause() {
        super.onPause()
        activity?.linearLayout?.isVisible = true
        mRefMessages.removeEventListener(mMessageListener)
    }

}