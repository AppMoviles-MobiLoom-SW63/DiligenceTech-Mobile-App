package pe.edu.upc.diligencetech.duediligencemanagement.data.repositories

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.diligencetech.common.Resource
import pe.edu.upc.diligencetech.duediligencemanagement.data.remote.AreasService
import pe.edu.upc.diligencetech.duediligencemanagement.data.remote.dtos.toArea
import pe.edu.upc.diligencetech.duediligencemanagement.data.remote.resources.AreaResource
import pe.edu.upc.diligencetech.duediligencemanagement.domain.Area

class AreasRepository(
    private val areasService: AreasService
) {
    suspend fun createArea(areaResource: AreaResource): Resource<List<Area>> =
        withContext(Dispatchers.IO) {
            try {
                Log.d("Paso Area", "$areaResource")
                val response = areasService.createArea(areaResource)
                if (response.isSuccessful) {
                    Log.d("Area Success", "Yes")
                    val resource = getAreasByProjectId(areaResource.projectId)
                    return@withContext resource
                }
                Log.d("Area Failure", "No")
                return@withContext Resource.Error("Something went wrong.")
            } catch (e: Exception) {
                Log.d("Fallo totalmente en Area", "NO")
                return@withContext Resource.Error("Something went wrong: ${e.message}")
            }
        }

    suspend fun getAreasByProjectId(projectId: Long): Resource<List<Area>>
    = withContext(Dispatchers.IO) {
        try {
            val response = areasService.getAreasByProjectId(projectId)
            if (response.isSuccessful) {
                Log.d("Area Success", "Yes")
                val areasDto = response.body()
                val areas = areasDto?.map {
                    it.toArea()
                }
                areas?.let {
                    return@withContext Resource.Success(areas)
                }
                return@withContext Resource.Error("Something went wrong.")
            }
            Log.d("Area Failure", "No")
            return@withContext Resource.Error("Something went wrong.")
        } catch (e: Exception) {
            return@withContext Resource.Error("Something went wrong: ${e.message}")
        }
    }
    suspend fun editArea(areaId: String, areaResource: AreaResource): Resource<Unit> = withContext(Dispatchers.IO) {
        try {
            val response = areasService.editArea(areaId, areaResource)
            if (response.isSuccessful) {
                return@withContext Resource.Success(Unit) // Edición exitosa
            }
            return@withContext Resource.Error("Error al editar el área.")
        } catch (e: Exception) {
            return@withContext Resource.Error("Error: ${e.message}")
        }
    }

}