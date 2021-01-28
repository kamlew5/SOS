package com.example.sos.serializers

import com.google.gson.annotations.SerializedName

data class PatientInformation (
    @SerializedName("pacjent_id") val pacjent_id : Int,
    @SerializedName("pacjent_imie") val pacjent_imie : String,
    @SerializedName("pacjent_nazwisko") val pacjent_nazwisko : String,
    @SerializedName("pacjent_pesel") val pacjent_pesel :String,
    @SerializedName("pacjent_data_ur") val pacjent_data_ur : String,
    @SerializedName("miasto_nazwa") val miasto_nazwa : String,
    @SerializedName("ulica_nazwa") val ulica_nazwa : String,
    @SerializedName("nr_budynku") val nr_budynku : Int,
    @SerializedName("nr_mieszkania") val nr_mieszkania : Int,
    @SerializedName("grupa_krwi_nazwa") val grupa_krwi_nazwa : String,
    @SerializedName("pracuje") val pracuje : Boolean,
    @SerializedName("ubezpieczony") val ubezpieczony : Int,
    @SerializedName("nr_dowodu") val nr_dowodu : String,
    @SerializedName("up_osoba_imie") val up_osoba_imie : String,
    @SerializedName("up_osoba_nazwisko") val up_osoba_nazwisko : String
)