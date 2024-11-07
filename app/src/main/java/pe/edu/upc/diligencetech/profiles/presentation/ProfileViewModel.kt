package pe.edu.upc.diligencetech.profiles.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upc.diligencetech.common.Constants
import pe.edu.upc.diligencetech.dashboard.presentation.DashboardRepository
import pe.edu.upc.diligencetech.profiles.data.repositories.UserRepository
import pe.edu.upc.diligencetech.profiles.domain.User
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: DashboardRepository,
    private val userRepository: UserRepository
) : ViewModel() {
    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> get() = _user

    private val _projectCount = MutableStateFlow(0)
    val projectCount: StateFlow<Int> get() = _projectCount

    init {
        fetchUserData()
        fetchProjectCount()
    }

    private fun fetchUserData() {
        viewModelScope.launch {
            try {
                _user.value = userRepository.getUserById(Constants.id!!.toInt()).data
                Log.d("ProfileViewModel", "User data fetched successfully: ${_user.value}")
            } catch (e: Exception) {
                Log.e("ProfileViewModel", "Error fetching user data", e)
            }
        }
    }

    private fun fetchProjectCount() {
        viewModelScope.launch {
            try {
                _projectCount.value = repository.getUserProjectCount()
                Log.d("ProfileViewModel", "Project count fetched successfully: ${_projectCount.value}")
            } catch (e: Exception) {
                Log.e("ProfileViewModel", "Error fetching project count", e)
            }
        }
    }
}