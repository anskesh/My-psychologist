package com.efimcompany.mypsychologist

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.efimcompany.mypsychologist.feature.messages.ui.MessangerFragment
import com.efimcompany.mypsychologist.feature.profile.ui.ProfileFragment
import com.efimcompany.mypsychologist.feature.psihologist.ui.ListPsychologistFragment
import com.efimcompany.mypsychologist.feature.registration.RegisterActivity
import com.efimcompany.mypsychologist.models.User
import com.efimcompany.mypsychologist.utilits.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var ACTIVITY: Activity
    private var isActivate = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ACTIVITY = MainActivity()

        tv_headerText.text = getString(R.string.title_messenger)
    }

    override fun onStart() {
        super.onStart()

        linearLayout.isVisible = true
        tv_headerText.text = getString(R.string.title_messenger)

        AUTH = FirebaseAuth.getInstance()
        REF_DATABASE_ROOT = FirebaseDatabase.getInstance().reference
        USER = User()
        UID = AUTH.currentUser?.uid.toString()

        initFunc()
        buttonsClick()

        initUser()
    }

    private fun initUser() {
        containerBarMain.isVisible = true
        isActivate = false
        REF_DATABASE_ROOT.child(NODE_USERS).child(UID)
            .addListenerForSingleValueEvent(AppValueEventListener {
                USER = it.getValue(User::class.java) ?: User()
                containerBarMain.isVisible = false
                isActivate = true
            })
    }

    private fun initFunc() {
        if (AUTH.currentUser != null) {
            replaceFragment(MessangerFragment(), false)
        } else {
            replaceActivity(RegisterActivity())
        }
    }

    private fun buttonsClick() {
        btn_Messanger.setOnClickListener {
            if (tv_headerText.text != getString(R.string.title_messenger) && isActivate) {
                tv_headerText.text = getString(R.string.title_messenger)
                replaceFragment(MessangerFragment())
                linearLayout.isVisible = true
            }
        }
        btn_Psihologists.setOnClickListener {
            if (tv_headerText.text != getString(R.string.title_psihologist) && isActivate) {
                tv_headerText.text = getString(R.string.title_psihologist)
                replaceFragment(ListPsychologistFragment())
                linearLayout.isVisible = true
            }
        }
        btn_Profile.setOnClickListener {
            if (tv_headerText.text != getString(R.string.title_profile) && isActivate) {
                tv_headerText.text = getString(R.string.title_profile)
                replaceFragment(ProfileFragment())
                linearLayout.isVisible = true
            }
        }
    }

}