package com.efimcompany.mypsychologist.feature.registration.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.efimcompany.mypsychologist.R
import com.efimcompany.mypsychologist.feature.registration.presentation.RegistrationPresenter
import com.efimcompany.mypsychologist.feature.registration.presentation.RegistrationView
import kotlinx.android.synthetic.main.fragment_registration.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class RegistrationFragment : MvpAppCompatFragment(R.layout.fragment_registration), RegistrationView {

    private val presenter: RegistrationPresenter by moxyPresenter{
        RegistrationPresenter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
        btn_registration.setOnClickListener{ sendCode() }
    }

    private fun sendCode(){

    }
}