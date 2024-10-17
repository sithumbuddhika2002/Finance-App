package com.example.financialapp.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.financialapp.databinding.ActivityMain2Binding
import com.example.financialapp.databinding.SignUpBinding

class SignupScreen : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up click listener for the ImageView
        binding.profilebtn.setOnClickListener {
            // Create an Intent to navigate to SignupScreen
            val intent = Intent(this, SignUpBinding::class.java)
            startActivity(intent)
        }

    }
}
