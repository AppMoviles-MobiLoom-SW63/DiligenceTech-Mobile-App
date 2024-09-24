package pe.edu.upc.diligencetech.duediligencemanagement.data.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.diligencetech.common.Resource
import pe.edu.upc.diligencetech.duediligencemanagement.data.remote.DueDiligenceProjectsService
import pe.edu.upc.diligencetech.duediligencemanagement.data.remote.dtos.toProject
import pe.edu.upc.diligencetech.duediligencemanagement.data.remote.resources.DueDiligenceProjectResource
import pe.edu.upc.diligencetech.duediligencemanagement.domain.DueDiligenceProject

class DueDiligenceProjectsRepository(
    private val dueDiligenceProjectsService: DueDiligenceProjectsService,
) {
    suspend fun getDueDiligenceProjects(): Resource<List<DueDiligenceProject>>
    = withContext(Dispatchers.IO) {
        try {
            val response = dueDiligenceProjectsService.getDueDiligenceProjects().execute()
            if (response.isSuccessful) {
                val projectDtos = response.body()
                val projects = projectDtos?.map {
                    it.toProject()
                }
                projects?.let {
                    return@withContext Resource.Success(projects)
                }
            }
            return@withContext Resource.Error("Something went wrong")
        } catch (e: Exception) {
            return@withContext Resource.Error("Something went wrong: ${e.message}")
        }
    }

    suspend fun createDueDiligenceProject(dueDiligenceProjectResource: DueDiligenceProjectResource): Resource<List<DueDiligenceProject>>
    = withContext(Dispatchers.IO) {
        try {
            val response = dueDiligenceProjectsService.createDueDiligenceProject(dueDiligenceProjectResource).execute()
            if (response.isSuccessful) {
                val resource = getDueDiligenceProjects()
                return@withContext resource
            }
            return@withContext Resource.Error("Something went wrong")
        } catch (e: Exception) {
            return@withContext Resource.Error("Something went wrong: ${e.message}")
        }
    }
}