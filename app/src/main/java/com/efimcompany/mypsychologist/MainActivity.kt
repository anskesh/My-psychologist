package com.efimcompany.mypsychologist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.efimcompany.mypsychologist.feature.messages.ui.MessangerFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFunc()

        fragmentManager.beginTransaction()
            .add(R.id.container, MessangerFragment())
            .commit()
    }

    private fun initFunc() {
        btn_Messanger.setOnClickListener{
            fragmentManager.beginTransaction()
                .add(R.id.container, MessangerFragment())
                .commit()
        }
    }
}