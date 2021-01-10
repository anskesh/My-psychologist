package com.efimcompany.mypsychologist.feature.messages.ui

import androidx.fragment.app.Fragment
import androidx.core.view.isVisible
import com.efimcompany.mypsychologist.R
import com.efimcompany.mypsychologist.utilits.*
import kotlinx.android.synthetic.main.activity_main.*

class privateMessagesFragment(val id_user: String) : Fragment(R.layout.fragment_private_messages) {

    override fun onStart() {
        super.onStart()
        activity?.linearLayout?.isVisible = false

        /*if (et_SMS.isEmpty()) {
            showToast("Введите сообщение!")
        } else {
            enterSMS(et_SMS.text.toString(), id_user, TYPE_TEXT) {
                et_SMS.setText("")
            }
        }*/
    }

    private fun enterSMS(messange: String, userID: String, typeText: String, function: () -> Unit) {

       // var refDialogUser =

    }

    override fun onDestroy() {
        super.onDestroy()
        activity?.linearLayout?.isVisible = true
    }

}