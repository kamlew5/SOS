package com.example.sos.serializers

import com.google.gson.annotations.SerializedName

data class HosList (
    @SerializedName("id") val id : Int,
    @SerializedName("oddzial_id") val oddzial_id : Int,
    @SerializedName("hospitalizacja_opis") val hospitalizacja_opis : String,
    @SerializedName("data_i_godz_roz") val data_i_godz_roz : String,
    @SerializedName("data_i_godz_zak") val data_i_godz_zak : String,
    @SerializedName("oddzial_nazwa") val oddzial_nazwa : String
)