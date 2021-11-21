package com.demo.interviewdemo.view.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demo.interviewdemo.view.data.dta.models.Repo
import com.demo.interviewdemo.view.repositories.RepoRepository
import com.demo.interviewdemo.view.utils.Utility.isInternetAvailable


class RepoViewModel(private val context: Context) : ViewModel() {

    private var listData = MutableLiveData<ArrayList<Repo>>()

    init{
        val userRepository : RepoRepository by lazy {
            RepoRepository
        }
        if(context.isInternetAvailable()) {
            listData = userRepository.getMutableLiveData(context)
        }
    }

    fun getData() : MutableLiveData<ArrayList<Repo>>{
        return listData
    }

}