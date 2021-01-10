package com.efimcompany.mypsychologist.feature.profile.ui

import androidx.fragment.app.Fragment
import com.efimcompany.mypsychologist.MainActivity
import com.efimcompany.mypsychologist.R
import com.efimcompany.mypsychologist.feature.registration.RegisterActivity
import com.efimcompany.mypsychologist.utilits.*
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    override fun onStart() {
        super.onStart()

        btn_exit_profile.setOnClickListener {
            AUTH.signOut()
            (activity as MainActivity).replaceActivity(RegisterActivity())
        }

        et_phone_profile.setText(USER.name)
        textView2.text = USER.phone

        btn_save_profile.setOnClickListener { changeUser() }
    }

    private fun changeUser() {
        val name = et_phone_profile.text.toString()
        if (name.isEmpty()) {
            showToast("Поле имя пустое")
        } else {
            REF_DATABASE_ROOT.child(NODE_USERS).child(UID).child(CHILD_USER_NAME)
                    .setValue(name).addOnCompleteListener {
                        if (it.isSuccessful) {
                            showToast("Данные обновлены")
                            USER.name = name
                        }
                    }
        }
    }
}