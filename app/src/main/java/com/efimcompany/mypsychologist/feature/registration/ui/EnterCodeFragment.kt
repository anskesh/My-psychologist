package com.efimcompany.mypsychologist.feature.registration.ui

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.efimcompany.mypsychologist.MainActivity
import com.efimcompany.mypsychologist.R
import com.efimcompany.mypsychologist.feature.registration.RegisterActivity
import com.efimcompany.mypsychologist.utilits.*
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_enter_code.*

class EnterCodeFragment(val phoneNumber: String, val id: String) : Fragment(R.layout.fragment_enter_code) {


    override fun onStart() {
        super.onStart()

        (activity as RegisterActivity).title = phoneNumber

        et_Code.addTextChangedListener(AppTextWatcher{
            if(et_Code.text.toString().length == 6){
                enterCode(et_Code.text.toString())
            }
        })
    }

    private fun enterCode(code: String){

        val credential = PhoneAuthProvider.getCredential(id, code)
        AUTH.signInWithCredential(credential).addOnCompleteListener{
            if(it.isSuccessful){

                val uid = AUTH.currentUser?.uid.toString()

                var dateMap = mutableMapOf<String, Any>()
                dateMap[CHILD_ID] = uid
                dateMap[CHILD_PHONE] = phoneNumber
                dateMap[CHILD_USER_NAME] = "user_${phoneNumber.substring(1)}"
                dateMap[CHILD_USER_NAME_START] = "user_${phoneNumber.substring(1)}"

                REF_DATABASE_ROOT.child(NODE_USERS).child(uid).updateChildren(dateMap)
                    .addOnCompleteListener { task->
                        if(task.isSuccessful){
                            showToast("Привет!")
                            (activity as RegisterActivity).replaceActivity(MainActivity())
                        } else showToast(task.exception?.message.toString())
                    }

            } else showToast(it.exception?.message.toString())
        }
    }
}