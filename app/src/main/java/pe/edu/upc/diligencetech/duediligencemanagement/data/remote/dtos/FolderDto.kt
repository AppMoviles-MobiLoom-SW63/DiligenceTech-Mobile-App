package pe.edu.upc.diligencetech.duediligencemanagement.data.remote.dtos

import com.google.gson.annotations.SerializedName

data class FolderDto(
    @SerializedName("areaId")
    val areaId: Long,
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String
)