package com.example.financialapp.Activity

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.financialapp.Adapter.ReportListAdapter
import com.example.financialapp.ViewModel.MainViewModel
import com.example.financialapp.databinding.ActivityReportBinding

class ReportActivity : AppCompatActivity() {
    lateinit var binding: ActivityReportBinding
    private val mainViewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        initRecyclerview()

    }

    private fun initRecyclerview() {
        binding.view2.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.view2.adapter = ReportListAdapter(mainViewModel.loanBudget())
        binding.view2.isNestedScrollingEnabled = false
    }
}