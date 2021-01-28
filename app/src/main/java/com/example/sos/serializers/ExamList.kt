package com.example.sos.serializers

import com.google.gson.annotations.SerializedName

data class ExamList (
    @SerializedName("id") val id : Int,
    @SerializedName("pacjent_id") val pacjent_id : Int,
    @SerializedName("spis_zabiegi_id") val spis_zabiegi_id : Int,
    @SerializedName("pracownicy_id") val pracownicy_id : Int,
    @SerializedName("data_i_godz") val data_i_godz : String,
    @SerializedName("pracownicy_imie") val pracownicy_imie : String,
    @SerializedName("pracownicy_nazwisko") val pracownicy_nazwisko : String,
    @SerializedName("spis_zabiegi_nazwa") val spis_zabiegi_nazwa : String
)