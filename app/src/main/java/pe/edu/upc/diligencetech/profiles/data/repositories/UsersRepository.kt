package pe.edu.upc.diligencetech.profiles.data.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.diligencetech.common.Resource
import pe.edu.upc.diligencetech.duediligencemanagement.data.remote.dtos.toUser
import pe.edu.upc.diligencetech.profiles.data.remote.UsersService
import pe.edu.upc.diligencetech.profiles.domain.User
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val usersService: UsersService
) {
    suspend fun getUserById(id: Int): Resource<User> = withContext(Dispatchers.IO) {
        try{
            val response = usersService.getUserById(id)
            if(response.isSuccessful){
                response.body()?.let { userDto ->
                    return@withContext Resource.Success(data = userDto.toUser())
                }
                return@withContext Resource.Error("No se encontró el usuario")
            }
            return@withContext Resource.Error(response.message())
        }catch (e: Exception){
            return@withContext Resource.Error(e.message ?: "Ocurrió un error")
        }
    }
}
