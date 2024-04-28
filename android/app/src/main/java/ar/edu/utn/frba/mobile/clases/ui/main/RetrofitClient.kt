package ar.edu.utn.frba.mobile.clases.ui.main

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    // Base URL de la API
    private const val BASE_URL = "https://us-central1-clases-854bb.cloudfunctions.net/"

    // Configuración de Retrofit
    private val retrofit: Retrofit by lazy {

        // Crea una instancia de Retrofit
        Retrofit.Builder()
            .baseUrl(BASE_URL) // Establece la URL base de la API
            .addConverterFactory(GsonConverterFactory.create()) // Conversor de JSON (Gson)
            .build()

    }

    // Interfaz de servicio para la API
    val service: TweetsService by lazy {
        // Crea una instancia de la interfaz `TweetsService`
        retrofit.create(TweetsService::class.java)
    }
}
