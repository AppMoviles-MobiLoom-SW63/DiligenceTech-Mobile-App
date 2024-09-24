package pe.edu.upc.diligencetech.communications.data.remote

import pe.edu.upc.diligencetech.communications.data.remote.dtos.MessageDto
import pe.edu.upc.diligencetech.communications.data.remote.resources.MessageResource
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface MessagesService {
    @Headers(
        value = [
            "accept: application/json"
        ]
    )
    @GET("messages")
    suspend fun getAllMessages(): Call<List<MessageDto>>

    @Headers(
        value = [
            "accept: application/json"
        ]
    )
    @POST("messages")
    suspend fun createMessage(@Body messageResource: MessageResource): Call<MessageDto?>

    @Headers(
        value = [
            "accept: application/json"
        ]
    )
    @GET("messages/{emailId}")
    suspend fun getMessageById(@Path("emailId") emailId: Long): Call<MessageDto?>

    @Headers(
        value = [
            "accept: application/json"
        ]
    )
    @GET("messages/project/{projectId}")
    suspend fun getMessagesByProjectId(@Path("projectId") projectId: Long): Call<List<MessageDto>>

}