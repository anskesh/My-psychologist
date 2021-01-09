package com.efimcompany.mypsychologist.feature.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.efimcompany.mypsychologist.R
import com.efimcompany.mypsychologist.feature.registration.ui.EnterPhoneNumberFragment
import com.efimcompany.mypsychologist.utilits.replaceFragment

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    override fun onStart() {
        super.onStart()
        title = "Авторизация"
        replaceFragment(EnterPhoneNumberFragment(), false)
    }
}