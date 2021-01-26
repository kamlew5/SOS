package com.example.sos

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val recycler: RecyclerView = findViewById(R.id.recycler)
////        val array1 = arrayOf("Kit","Kat","arr","aaa","bbb")
//        recycler.layoutManager = LinearLayoutManager(this)


        fetchJSON()
//        fetchJSON(recycler)
    }

    fun fetchJSON(){
//    fun fetchJSON(recycler: RecyclerView){
        println("Próba")
//       val url = "https://api.letsbuildthatapp.com/youtube/home_feed"
        val url = "https://sos.kml.net.pl/api/patient?id=1"

        val topic: Parse_Patient
       val request = Request.Builder().url(url).build()

       val client =OkHttpClient()
       client.newCall(request).enqueue(object: Callback{
           override fun onResponse(call: Call, response: Response) {
               val body = response.body?.string()
               println(body)
//               val gson = GsonBuilder().create()
               val gson = GsonBuilder().create()
//               val homeFeed = gson.fromJson(body, HomeFeed::class.java)
               val topic = gson.fromJson(body, Parse_Patient::class.java)
                println(topic)

           }
           override fun onFailure(call: Call, e: IOException) {
               println("Failed to execute request")
           }
       })
    }
    fun changePatient(parsePatient: Parse_Patient){
        val patient_id: TextView = findViewById(R.id.patient_ID)
            patient_id.text = parsePatient.data[0].pacjent_id.toString()
        val patient_name: TextView = findViewById(R.id.patient_NAME)
            patient_name.text = parsePatient.data[0].pacjent_imie
        val patient_surname: TextView = findViewById(R.id.patient_SURNAME)
            patient_surname.text = parsePatient.data[0].pacjent_nazwisko
        val patient_pesel: TextView = findViewById(R.id.patient_PESEL)
            patient_pesel.text = parsePatient.data[0].pacjent_pesel
        val patient_DATE: TextView = findViewById(R.id.patient_DATE)
            patient_DATE.text = parsePatient.data[0].pacjent_data_ur
        val patient_address: TextView = findViewById(R.id.patient_ADDRESS)
            patient_address.text = parsePatient.data[0].ulica_nazwa + " " +
                    parsePatient.data[0].nr_budynku.toString() + "/" +
                    parsePatient.data[0].nr_mieszkania.toString() + ", " +
                    parsePatient.data[0].miasto_nazwa
        val patient_gk: TextView = findViewById(R.id.patient_GK)
            patient_gk.text = parsePatient.data[0].grupa_krwi_nazwa
        val patient_employed: TextView = findViewById(R.id.patient_Employed)
            patient_employed.text = if (parsePatient.data[0].pracuje) "tak" else "nie"
        val patient_NR_D: TextView = findViewById(R.id.patient_NR_D)
            patient_NR_D.text = parsePatient.data[0].nr_dowodu
        val patient_UP_Person: TextView = findViewById(R.id.patient_UP_Person)
            patient_UP_Person.text = parsePatient.data[0].up_osoba_imie + " " + parsePatient.data[0].up_osoba_nazwisko
    }
}

data class Parse_Patient (

        @SerializedName("data") val data : List<patient_information>
)
data class patient_information (
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