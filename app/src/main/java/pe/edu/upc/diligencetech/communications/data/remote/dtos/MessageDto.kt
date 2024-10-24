package pe.edu.upc.diligencetech.communications.data.remote.dtos

import com.google.gson.annotations.SerializedName
import pe.edu.upc.diligencetech.communications.domain.Messages

data class MessageDto(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("id")
    val id: Long,
    @SerializedName("message")
    val message: String,
    @SerializedName("projectId")
    val projectId: Long,
    @SerializedName("userId")
    val userId: Long
)

fun MessageDto.toMessage() = Messages(createdAt, id, message, projectId, userId)