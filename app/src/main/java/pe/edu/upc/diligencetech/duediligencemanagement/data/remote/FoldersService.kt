package pe.edu.upc.diligencetech.duediligencemanagement.data.remote

import pe.edu.upc.diligencetech.duediligencemanagement.data.remote.dtos.FolderDto
import pe.edu.upc.diligencetech.duediligencemanagement.data.remote.resources.EditFolderResource
import pe.edu.upc.diligencetech.duediligencemanagement.data.remote.resources.FolderResource
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface FoldersService {
    @Headers(
        value = [
            "accept: application/json",
            "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1MjAyMjE4MjI3QHVwYy5lZHUucGUiLCJpYXQiOjE3MjczNjM2NzksImV4cCI6MTcyNzk2ODQ3OX0.UI1nO9IVSGay-SLkWqco1daoG4a3rXTYFxuImNZIw4o"
        ]
    )
    @PUT("folders/{folderId}")
    suspend fun editFolder(@Path("folderId") folderId: Long, @Body editFolderResource: EditFolderResource): Call<FolderDto?>

    @Headers(
        value = [
            "accept: application/json",
            "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1MjAyMjE4MjI3QHVwYy5lZHUucGUiLCJpYXQiOjE3MjczNjM2NzksImV4cCI6MTcyNzk2ODQ3OX0.UI1nO9IVSGay-SLkWqco1daoG4a3rXTYFxuImNZIw4o"
        ]
    )
    @GET("folders")
    suspend fun getAllFolders(): Response<List<FolderDto>>

    @Headers(
        value = [
            "accept: application/json",
            "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1MjAyMjE4MjI3QHVwYy5lZHUucGUiLCJpYXQiOjE3MjczNjM2NzksImV4cCI6MTcyNzk2ODQ3OX0.UI1nO9IVSGay-SLkWqco1daoG4a3rXTYFxuImNZIw4o"
        ]
    )
    @POST("folders")
    suspend fun createFolder(@Body folderResource: FolderResource): Response<FolderDto?>

    @Headers(
        value = [
            "accept: application/json",
            "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1MjAyMjE4MjI3QHVwYy5lZHUucGUiLCJpYXQiOjE3MjczNjM2NzksImV4cCI6MTcyNzk2ODQ3OX0.UI1nO9IVSGay-SLkWqco1daoG4a3rXTYFxuImNZIw4o"
        ]
    )
    @GET("folders/{areaId}")
    suspend fun getFoldersByAreaId(@Path("areaId") areaId: Long): Response<List<FolderDto>>

}