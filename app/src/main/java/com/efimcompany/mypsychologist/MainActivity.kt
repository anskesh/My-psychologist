package com.efimcompany.mypsychologist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.efimcompany.mypsychologist.feature.messages.ui.MessangerFragment
import com.efimcompany.mypsychologist.feature.profile.ui.ProfileFragment
import com.efimcompany.mypsychologist.feature.psihologist.ui.ListPsihologistFragment
import com.efimcompany.mypsychologist.feature.registration.RegisterActivity
import com.efimcompany.mypsychologist.utilits.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = getString(R.string.title_messenger)
    }

    override fun onStart() {
        super.onStart()

        AUTH = FirebaseAuth.getInstance()
        REF_DATABASE_ROOT = FirebaseDatabase.getInstance().reference
        //initFirebase()

        initFunc()
        buttonsClick()
    }

    private fun initFunc() {
        if (AUTH.currentUser == null){
            replaceFragment(MessangerFragment(), false)
        }
        else{
            replaceActivity(RegisterActivity())
        }
    }

    private fun buttonsClick(){
        btn_Messanger.setOnClickListener {
            if(title!= getString(R.string.title_messenger)){
                title = getString(R.string.title_messenger)
                replaceFragment(MessangerFragment())
            }
        }
        btn_Psihologists.setOnClickListener {
            if(title!= getString(R.string.title_psihologist)){
                title = getString(R.string.title_psihologist)
                replaceFragment(ListPsihologistFragment())
            }
        }
        btn_Profile.setOnClickListener {
            if(title!= getString(R.string.title_profile)){
                title = getString(R.string.title_profile)
                replaceFragment(ProfileFragment())
            }
        }
    }

}