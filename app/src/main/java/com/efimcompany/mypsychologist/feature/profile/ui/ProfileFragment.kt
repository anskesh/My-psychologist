package com.efimcompany.mypsychologist.feature.profile.ui

import androidx.fragment.app.Fragment
import com.efimcompany.mypsychologist.MainActivity
import com.efimcompany.mypsychologist.R
import com.efimcompany.mypsychologist.feature.registration.RegisterActivity
import com.efimcompany.mypsychologist.utilits.AUTH
import com.efimcompany.mypsychologist.utilits.replaceActivity
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    override fun onStart() {
        super.onStart()

        btn_exit_profile.setOnClickListener {
            AUTH.signOut()
            (activity as MainActivity).replaceActivity(RegisterActivity())
        }
    }
}