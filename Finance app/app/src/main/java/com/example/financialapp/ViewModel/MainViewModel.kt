package com.example.financialapp.ViewModel

import androidx.lifecycle.ViewModel
import com.example.financialapp.Repository.MainRepository

class MainViewModel(val repository: MainRepository): ViewModel() {
    constructor() : this(MainRepository())

    fun loadData()= repository.items
    fun loanBudget()=repository.budget
}