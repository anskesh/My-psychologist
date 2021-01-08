package com.efimcompany.mypsychologist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.efimcompany.mypsychologist.feature.messages.ui.MessangerFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager

        fragmentManager.beginTransaction()
            .add(R.id.container, MessangerFragment())
            .commit()
    }
}