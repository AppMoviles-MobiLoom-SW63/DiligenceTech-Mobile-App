package pe.edu.upc.diligencetech.duediligencemanagement.data.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.diligencetech.common.Resource
import pe.edu.upc.diligencetech.duediligencemanagement.data.remote.FoldersService
import pe.edu.upc.diligencetech.duediligencemanagement.data.remote.dtos.toFolder
import pe.edu.upc.diligencetech.duediligencemanagement.data.remote.resources.FolderResource
import pe.edu.upc.diligencetech.duediligencemanagement.domain.Folder

class FoldersRepository(
    private val foldersService: FoldersService
) {
    suspend fun getFoldersByAreaId(areaId: Long): Resource<List<Folder>>
    = withContext(Dispatchers.IO) {
        try {
            val response = foldersService.getFoldersByAreaId(areaId)
            if (response.isSuccessful) {
                val folderDtos = response.body()
                val folders = folderDtos?.map {
                    it.toFolder()
                }
                folders?.let {
                    return@withContext Resource.Success(it)
                }
            }
            return@withContext Resource.Error("Something went wrong")
        } catch (e: Exception) {
            return@withContext Resource.Error("Something went wrong: ${e.message}")
        }
    }

    suspend fun createFolder(folderResource: FolderResource): Resource<List<Folder>>
    = withContext(Dispatchers.IO) {
        try {
            val response = foldersService.createFolder(folderResource)
            if (response.isSuccessful) {
                val resource = getFoldersByAreaId(folderResource.areaId)
                return@withContext resource
            }
            return@withContext Resource.Error("Something went wrong")
        } catch (e: Exception) {
            return@withContext Resource.Error("Something went wrong: ${e.message}")
        }
    }
}