package com.example.sos.serializers

import com.google.gson.annotations.SerializedName

data class ParsePatient (
    @SerializedName("data") val data : List<PatientInformation>,
    @SerializedName("hos_list") val hos_list : List<HosList>,
//    @SerializedName("recipe") val recipe : List<Recipe>,
    @SerializedName("exam_list") val exam_list : List<ExamList>
)