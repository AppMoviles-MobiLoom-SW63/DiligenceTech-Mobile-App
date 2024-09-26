package pe.edu.upc.diligencetech.duediligencemanagement.data.remote

import pe.edu.upc.diligencetech.duediligencemanagement.data.remote.dtos.DueDiligenceProjectDto
import pe.edu.upc.diligencetech.duediligencemanagement.data.remote.resources.DueDiligenceProjectResource
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface DueDiligenceProjectsService {
    @Headers(
        value = [
            "accept: application/json"
        ]
    )
    @GET("due-diligence-projects")
    suspend fun getDueDiligenceProjects(): Call<List<DueDiligenceProjectDto>>

    @Headers(
        value = [
            "accept: application/json"
        ]
    )
    @POST("due-diligence-projects")
    suspend fun createDueDiligenceProject(@Body dueDiligenceProjectResource: DueDiligenceProjectResource): Call<DueDiligenceProjectDto?>

    @Headers(
        value = [
            "accept: application/json"
        ]
    )
    @GET("due-diligence-projects/{projectId}")
    suspend fun getDueDiligenceProjectById(@Path("projectId") projectId: Long): Call<DueDiligenceProjectDto?>

    @Headers(
        value = [
            "accept: application/json"
        ]
    )
    @GET("due-diligence-projects/user/{username}")
    suspend fun getDueDiligenceProjectByUserAndUsername(@Path("username") username: String): Call<List<DueDiligenceProjectDto>>

}