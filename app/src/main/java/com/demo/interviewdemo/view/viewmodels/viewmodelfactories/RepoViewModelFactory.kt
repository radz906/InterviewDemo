package com.demo.interviewdemo.view.viewmodels.viewmodelfactories

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.demo.interviewdemo.view.viewmodels.RepoViewModel


class RepoViewModelFactory(private val context: Context) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RepoViewModel(context) as T
    }

}