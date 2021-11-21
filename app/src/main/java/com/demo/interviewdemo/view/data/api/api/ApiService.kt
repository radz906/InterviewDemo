package com.demo.interviewdemo.view.data.dta.api

import com.demo.interviewdemo.view.data.dta.models.Repo

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("repos")
    fun getRepos(): Call<MutableList<Repo>>

}