package pe.edu.upc.diligencetech.duediligencemanagement.data.remote.dtos

import com.google.gson.annotations.SerializedName

data class DueDiligenceProjectDto(
    @SerializedName("id")
    val id: Long,
    @SerializedName("projectName")
    val projectName: String
)