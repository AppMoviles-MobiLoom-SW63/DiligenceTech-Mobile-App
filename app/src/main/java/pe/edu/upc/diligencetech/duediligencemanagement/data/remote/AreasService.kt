package pe.edu.upc.diligencetech.duediligencemanagement.data.remote

import pe.edu.upc.diligencetech.common.Constants
import pe.edu.upc.diligencetech.duediligencemanagement.data.remote.dtos.AreaDto
import pe.edu.upc.diligencetech.duediligencemanagement.data.remote.resources.AreaResource
import pe.edu.upc.diligencetech.iam.data.remote.SignUpDto
import pe.edu.upc.diligencetech.iam.data.remote.SignUpResource
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path


interface AreasService {
    @Headers(
        value = [
            "accept: application/json",
            "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1MjAyMjE4MjI3QHVwYy5lZHUucGUiLCJpYXQiOjE3MjczNjM2NzksImV4cCI6MTcyNzk2ODQ3OX0.UI1nO9IVSGay-SLkWqco1daoG4a3rXTYFxuImNZIw4o"
        ]
    )
    @PUT("areas/{areaId}")
    suspend fun editArea(@Path("areaId") areaId: String, @Body editAreaResource: AreaResource): Response<AreaDto?>

    @Headers(
        value = [
            "accept: application/json",
        ]
    )
    @GET("areas")
    suspend fun getAllAreas(): Response<List<AreaDto>>

    @Headers(
        value = [
            "accept: application/json",
        ]
    )
    @POST("areas")
    suspend fun createArea(@Body areaResource: AreaResource): Response<AreaDto?>

    @Headers(
        value = [
            "accept: application/json",
        ]
    )
    @GET("areas/{projectId}")
    suspend fun getAreasByProjectId(@Path("projectId") projectId: Long): Response<List<AreaDto>>
}