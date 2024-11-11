package pe.edu.upc.diligencetech.dashboard.presentation

import pe.edu.upc.diligencetech.duediligencemanagement.data.remote.DueDiligenceProjectsService
import pe.edu.upc.diligencetech.common.Constants
import javax.inject.Inject

class DashboardRepository @Inject constructor(
    private val dueDiligenceProjectsService: DueDiligenceProjectsService
) {
    suspend fun getUserProjectCount(): Int {
        val response = dueDiligenceProjectsService.getDueDiligenceProjectsByUsername(Constants.username.toString())
        return if (response.isSuccessful) {
            response.body()?.size ?: 0
        } else {
            0
        }
    }

    fun calculateTotalMembers(projectCount: Int): Int {
        return projectCount * 2
    }
}
