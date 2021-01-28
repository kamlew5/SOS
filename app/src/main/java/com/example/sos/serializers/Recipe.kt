package com.example.sos.serializers

import com.google.gson.annotations.SerializedName

data class Recipe (

    @SerializedName("id") val id : Int,
    @SerializedName("pracownicy_id") val pracownicy_id : Int,
    @SerializedName("pracownicy_imie") val pracownicy_imie : String,
    @SerializedName("pracownicy_nazwisko") val pracownicy_nazwisko : String,
    @SerializedName("data_i_godz") val data_i_godz : String
)