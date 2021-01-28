package com.example.sos

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.sos.serializers.ParsePatient
import com.example.sos.serializers.PatientInformation
import com.example.sos.serializers.Recipe
import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName
import okhttp3.*
import org.json.JSONException
import java.io.IOException

class MainActivity : AppCompatActivity(), FetchCompleteListener  {
    private lateinit var gsonJSON: ParsePatient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://sos.kml.net.pl/api/patient?id=2"
        getDetails(url)
    }
        private fun getDetails(url:String) {
            val client = OkHttpClient()
            val request= OkHttpRequest(client)

            request.GET(url, object: Callback {
                override fun onFailure(call: Call, e: IOException) {
                    println("Activity Failure.")
                }

                override fun onResponse(call: Call, response: Response) {
                    val responseData = response.body?.string()
                    runOnUiThread{
                        try {
                            gsonJSON = GsonBuilder().create().fromJson(responseData, ParsePatient::class.java)
                            this@MainActivity.fetchComplete()

                        } catch (e: JSONException) {
                            e.printStackTrace()

                        }
                    }
                }

            })
        }
    override fun fetchComplete() {
        findViewById<TextView>(R.id.patient_ID).text = gsonJSON.data[0].pacjent_id.toString()
        findViewById<TextView>(R.id.patient_NAME).text = gsonJSON.data[0].pacjent_imie
        findViewById<TextView>(R.id.patient_SURNAME).text = gsonJSON.data[0].pacjent_nazwisko
        findViewById<TextView>(R.id.patient_PESEL).text = gsonJSON.data[0].pacjent_pesel
        findViewById<TextView>(R.id.patient_DATE).text = gsonJSON.data[0].pacjent_data_ur
        val patientAddress: String = gsonJSON.data[0].ulica_nazwa + " " +
                gsonJSON.data[0].nr_budynku.toString() + "/" +
                gsonJSON.data[0].nr_mieszkania.toString() + ", " +
                gsonJSON.data[0].miasto_nazwa
        findViewById<TextView>(R.id.patient_ADDRESS).text = patientAddress
        findViewById<TextView>(R.id.patient_GK).text = gsonJSON.data[0].grupa_krwi_nazwa
        findViewById<TextView>(R.id.patient_Employed).text = if (gsonJSON.data[0].pracuje) "tak" else "nie"
        findViewById<TextView>(R.id.patient_NR_D).text = gsonJSON.data[0].nr_dowodu
        val upPerson = gsonJSON.data[0].up_osoba_imie + " " + gsonJSON.data[0].up_osoba_nazwisko
        findViewById<TextView>(R.id.patient_UP_Person).text = upPerson
        }

}