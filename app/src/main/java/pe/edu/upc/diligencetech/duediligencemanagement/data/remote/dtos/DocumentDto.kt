package pe.edu.upc.diligencetech.duediligencemanagement.data.remote.dtos

import com.google.gson.annotations.SerializedName

data class DocumentDto(
    @SerializedName("fileUrl")
    val fileUrl: String,
    @SerializedName("filename")
    val filename: String,
    @SerializedName("folderId")
    val folderId: Long,
    @SerializedName("id")
    val id: Long
)