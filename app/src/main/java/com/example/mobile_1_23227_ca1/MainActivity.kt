package com.example.mobile_1_23227_ca1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var logginTag = "MainActivity";
        //getString()
        //R.string.???
        Log.i(logginTag, getString(R.string.MainActivityLaunchMessage))

        btnDarjelling.setOnClickListener {
            val intent = Intent(this, DarjellingActivity::class.java)
            startActivity(intent)
        }

        btnCart.setOnClickListener{
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

    }
}