package pe.edu.upc.diligencetech.duediligencemanagement.data.remote.resources

import com.google.gson.annotations.SerializedName

data class DocumentResource(
    @SerializedName("fileUrl")
    val fileUrl: String,
    @SerializedName("filename")
    val filename: String,
    @SerializedName("folderId")
    val folderId: Long
)