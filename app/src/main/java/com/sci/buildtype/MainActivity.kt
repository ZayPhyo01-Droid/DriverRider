package com.sci.buildtype

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isGone
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.CircularProgressIndicator


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

        val viewModel = ViewModelProvider(this).get(
            ColorViewModel::class.java
        )
        val colorAdapter = ColorAdapter(
            onClickItem = {
                viewModel.selectItem(it)
            }
        )
        val rvColorList = findViewById<RecyclerView>(R.id.rvColorList)
            .apply {
                adapter = colorAdapter
            }

        val pgLoading = findViewById<CircularProgressIndicator>(R.id.pgLoading)

        // state , loading , success , list update --> viewModel
        // user event -> state update


        viewModel.uiState.observe(this) {
            when (it) {
                ColorUiState.Loading -> {
                    pgLoading.visibility = View.VISIBLE
                }

                is ColorUiState.Success -> {
                    pgLoading.visibility = View.GONE
                    colorAdapter.updateList(it.colors)
                }

                is ColorUiState.UpdateColorList -> {
                    pgLoading.visibility = View.GONE
                    colorAdapter.updateList(it.colors)
                }
            }
        }
    }

    // Remove


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




