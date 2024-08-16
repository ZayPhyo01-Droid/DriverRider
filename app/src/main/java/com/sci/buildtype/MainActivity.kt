package com.sci.buildtype

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isGone


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Glide.with -->> remove
        // Fb.init --> > remove
        // GoogleAuth.generateToken ---> remove

        calculate(10, 20)

        if (!BuildConfig.showDriverProfile) {
            findViewById<CardView>(R.id.cvDriverInfo).isGone = true
        }

    }

    // Remove
    fun calculate(a: Int, b: Int) = a + b

    //Glide
    //Fb sdk
    //Goolgle auth
}

// Build Type --> configuration

//Build Type - Debug build type
// Release build type

// Debug -> debugging , run quick , development time

// Release -> R8 , Treeshake , inline , code obfuscation

// device run -> signature key -> signing process -> google playstore <---> develop  trust

// Flavor(production flavor) and Dimension


//debug
//release

// same source -> multi app -> app , user features , version

// driver , rider
// free , premium
// staging , production


