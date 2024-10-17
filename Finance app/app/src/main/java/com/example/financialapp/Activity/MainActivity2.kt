package com.example.financialapp.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.financialapp.Adapter.ExpenseListAdapter
import com.example.financialapp.ViewModel.MainViewModel
import com.example.financialapp.databinding.ActivityMain2Binding
import com.example.financialapp.databinding.SignUpBinding
import eightbitlab.com.blurview.RenderScriptBlur

class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the click listener for the profile button
        binding.profilebtn.setOnClickListener {
            val intent = Intent(this, SignupScreen::class.java)
            startActivity(intent)
        }

        // Set window flags for layout
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        // Initialize RecyclerView, Blur Effect, and other variables
        initRecyclerView()
        setBlurEffect()
        setVariable()
    }

    private fun setVariable() {
        // Set up the click listener for the card button
        binding.cardBtn.setOnClickListener {
            val intent = Intent(this, ReportActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setBlurEffect() {
        val radius = 10f
        val decorView = window.decorView
        val rootView = decorView.findViewById<View>(android.R.id.content) as ViewGroup
        val windowBackground = decorView.background

        binding.blurView.setupWith(rootView, RenderScriptBlur(this))
            .setFrameClearDrawable(windowBackground)
            .setBlurRadius(radius)

        binding.blurView.outlineProvider = ViewOutlineProvider.BACKGROUND
        binding.blurView.clipToOutline = true
    }

    private fun initRecyclerView() {
        binding.view1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.view1.adapter = ExpenseListAdapter(mainViewModel.loadData())
        binding.view1.isNestedScrollingEnabled = false
    }
}
