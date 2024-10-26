package pe.edu.upc.diligencetech.profiles.data.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.diligencetech.profiles.data.api.ApiService
import pe.edu.upc.diligencetech.profiles.domain.User

class UserRepository(private val apiService: ApiService) {
    suspend fun getUserData(): User {
        return withContext(Dispatchers.IO) {
            apiService.getUserData()
        }
    }
}