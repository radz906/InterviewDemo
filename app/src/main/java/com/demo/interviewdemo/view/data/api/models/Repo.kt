package com.demo.interviewdemo.view.data.dta.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Repo(


    @SerializedName("name")
    val name: String? = null,



    @SerializedName("description")
    val description: String? = null


    ) : Serializable



