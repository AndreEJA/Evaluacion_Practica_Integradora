package ni.edu.uam.pasteleria_app.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    // ==============================
    // SI USAS EMULADOR ANDROID
    // ==============================
    const val BASE_URL = "http://10.0.2.2:8080/"

    // ==============================
    // SI USAS CELULAR FISICO
    // CAMBIA LA IP POR LA DE TU PC
    // ==============================
    //const val BASE_URL = "http://192.168.1.10:8080/"

    val apiService: ApiService by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}