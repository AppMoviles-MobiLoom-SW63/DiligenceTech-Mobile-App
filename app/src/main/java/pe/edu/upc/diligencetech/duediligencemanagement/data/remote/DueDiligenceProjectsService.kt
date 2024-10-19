package pe.edu.upc.diligencetech.duediligencemanagement.data.remote

import pe.edu.upc.diligencetech.duediligencemanagement.data.remote.dtos.DueDiligenceProjectDto
import pe.edu.upc.diligencetech.duediligencemanagement.data.remote.resources.DueDiligenceProjectResource
import retrofit2.Call
import retrofit2.Response
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
    suspend fun getDueDiligenceProjects(): Response<List<DueDiligenceProjectDto>>

    @Headers(
        value = [
            "accept: application/json"
        ]
    )
    @POST("due-diligence-projects")
    suspend fun createDueDiligenceProject(@Body dueDiligenceProjectResource: DueDiligenceProjectResource): Response<DueDiligenceProjectDto?>

    @Headers(
        value = [
            "accept: application/json"
        ]
    )
    @GET("due-diligence-projects/{projectId}")
    suspend fun getDueDiligenceProjectById(@Path("projectId") projectId: Long): Response<DueDiligenceProjectDto?>

    @Headers(
        value = [
            "accept: application/json"
        ]
    )
    @GET("due-diligence-projects/user/{username}")
    suspend fun getDueDiligenceProjectsByUsername(@Path("username") username: String): Response<List<DueDiligenceProjectDto>>


}