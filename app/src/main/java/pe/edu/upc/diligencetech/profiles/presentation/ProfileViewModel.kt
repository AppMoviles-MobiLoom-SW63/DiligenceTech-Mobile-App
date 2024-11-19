package pe.edu.upc.diligencetech.profiles.presentation

import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upc.diligencetech.common.Constants
import pe.edu.upc.diligencetech.profiles.data.repositories.UserRepository
import pe.edu.upc.diligencetech.profiles.domain.User
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {
    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> get() = _user

    private val _userColor = MutableStateFlow<Color?>(null)
    val userColor: StateFlow<Color?> = _userColor

    init {
        fetchUserData()
    }

    private fun fetchUserData() {
        viewModelScope.launch {
            try {
                _user.value = repository.getUserById(Constants.id!!).data
                Log.d("ProfileViewModel", "User data fetched successfully: ${_user.value}")
                if (_userColor.value == null) {
                    _userColor.value = getRandomColor()
                }
            } catch (e: Exception) {
                Log.e("ProfileViewModel", "Error fetching user data", e)
            }
        }
    }

    fun getRandomColor(): Color {
        val random = Random.Default
        return Color(
            red = random.nextInt(256),
            green = random.nextInt(256),
            blue = random.nextInt(256)
        )
    }

    fun setUserColor(color: Color) {
        _userColor.value = color
    }
}
