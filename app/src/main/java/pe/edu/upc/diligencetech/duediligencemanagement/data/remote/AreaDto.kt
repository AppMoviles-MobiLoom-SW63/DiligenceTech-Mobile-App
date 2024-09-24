package pe.edu.upc.diligencetech.duediligencemanagement.data.remote

import com.google.gson.annotations.SerializedName

data class AreaDto(
    @SerializedName("id")
    val id: Long,
    @SerializedName("fileName")
    val fileName: String,
)

