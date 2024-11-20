package pe.edu.upc.diligencetech.iam.presentation.sing_in

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.edu.upc.diligencetech.common.Resource
import pe.edu.upc.diligencetech.iam.data.remote.SignInResource
import pe.edu.upc.diligencetech.iam.data.repositories.AuthenticationRepository
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val repository: AuthenticationRepository
) : ViewModel() {

    private val _username = mutableStateOf("")
    val username: State<String> get() = _username

    private val _password = mutableStateOf("")
    val password: State<String> get() = _password

    private val _passwordVisible = mutableStateOf(false)
    val passwordVisible: State<Boolean> get() = _passwordVisible

    fun signIn(onSuccessfulSignIn: (id: Long, username: String, token: String) -> Unit) {
        val signInResource = SignInResource(
            username = username.value,
            password = password.value
        )
        if (signInResource.username.isEmpty() || signInResource.password.isEmpty()) {
            return
        }
        viewModelScope.launch {
            val result = repository.signIn(signInResource)
            if (result is Resource.Success) {
                onSuccessfulSignIn(result.data!!.id.toLong(), result.data.username, result.data.token)
            }
        }
    }

    fun onUsernameChange(username: String) {
        _username.value = username
    }

    fun onPasswordChange(password: String) {
        _password.value = password
    }

    fun onPasswordVisibilityChange(boolean: Boolean) {
        _passwordVisible.value = boolean
    }
}