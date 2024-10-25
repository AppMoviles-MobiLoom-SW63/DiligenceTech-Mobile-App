package pe.edu.upc.diligencetech.settings.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.edu.upc.diligencetech.common.SessionManager
import javax.inject.Inject
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State


@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val sessionManager: SessionManager // Aquí se maneja la sesión
) : ViewModel() {

    // Función para cerrar la sesión
    fun cerrarSesion(onLogoutSuccess: () -> Unit) {
        viewModelScope.launch {
            sessionManager.logout() // Lógica de cierre de sesión
            onLogoutSuccess() // Redirigir a la pantalla de login después de cerrar sesión
        }
    }

    // Simulación de la activación/desactivación de autenticación de dos factores
    private val _twoFactorAuthEnabled = mutableStateOf(false)
    val twoFactorAuthEnabled: State<Boolean> get() = _twoFactorAuthEnabled

    fun toggleTwoFactorAuth(isEnabled: Boolean) {
        _twoFactorAuthEnabled.value = isEnabled
        // Aquí podrías llamar a una función para habilitar/deshabilitar 2FA en el backend
    }
}
