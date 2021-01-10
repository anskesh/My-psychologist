package com.efimcompany.mypsychologist.feature.messages.ui

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.efimcompany.mypsychologist.R


class MessangerFragment : Fragment(R.layout.fragment_messanger) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initListener()
    }

    override fun onResume() {
        super.onResume()
    }

    private fun initListener() {

    }

}