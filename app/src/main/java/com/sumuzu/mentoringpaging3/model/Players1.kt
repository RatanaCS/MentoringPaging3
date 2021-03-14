package com.sumuzu.mentoringpaging3.model


import com.google.gson.annotations.SerializedName

data class Players1(
    @SerializedName("data")
    val data: List<Data>,
    @SerializedName("meta")
    val meta: Meta
)