package pe.edu.upc.diligencetech.profiles.data.remote

import pe.edu.upc.diligencetech.duediligencemanagement.data.remote.dtos.UserDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UsersService {

    @GET("users/{userId}")
    suspend fun getUserById(@Path("userId")userId: Long): Response<UserDto>
}