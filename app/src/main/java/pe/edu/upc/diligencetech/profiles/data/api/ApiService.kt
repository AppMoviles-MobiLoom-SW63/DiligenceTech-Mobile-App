package pe.edu.upc.diligencetech.profiles.data.api

import pe.edu.upc.diligencetech.profiles.domain.User
import retrofit2.http.GET

interface ApiService {
    @GET("user")
    suspend fun getUserData(): User
}