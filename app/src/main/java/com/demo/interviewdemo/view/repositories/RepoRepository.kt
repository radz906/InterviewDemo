package com.demo.interviewdemo.view.repositories

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.demo.interviewdemo.view.data.dta.api.ApiClient
import com.demo.interviewdemo.view.data.dta.models.Repo
import com.demo.interviewdemo.view.utils.Utility.hideProgressBar
import com.demo.interviewdemo.view.utils.Utility.showProgressBar

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RepoRepository {

    fun getMutableLiveData(context: Context) : MutableLiveData<ArrayList<Repo>>{

        val mutableLiveData = MutableLiveData<ArrayList<Repo>>()

        context.showProgressBar()

        ApiClient.apiService.getRepos().enqueue(object : Callback<MutableList<Repo>> {
            override fun onFailure(call: Call<MutableList<Repo>>, t: Throwable) {
                hideProgressBar()
                Log.e("error", t.localizedMessage)
            }

            override fun onResponse(
                call: Call<MutableList<Repo>>,
                response: Response<MutableList<Repo>>
            ) {
                hideProgressBar()
                val usersResponse = response.body()
                usersResponse?.let { mutableLiveData.value = it as ArrayList<Repo> }
            }

        })

        return mutableLiveData
    }

}