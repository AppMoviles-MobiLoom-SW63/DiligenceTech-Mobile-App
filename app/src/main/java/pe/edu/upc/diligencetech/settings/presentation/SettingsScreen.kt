package pe.edu.upc.diligencetech.settings.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import pe.edu.upc.diligencetech.R
import pe.edu.upc.diligencetech.common.WorkbenchScreen

@Composable
fun SettingsScreen(
    onHomeClick: () -> Unit,
    onProjectsClick: () -> Unit,
    onMessagesClick: () -> Unit,
    onProfileClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onLogoutSuccess: () -> Unit, // Acción cuando el cierre de sesión es exitoso
    viewModel: SettingsViewModel = hiltViewModel() // Obtenemos el ViewModel
) = WorkbenchScreen(
    onHomeClick = onHomeClick,
    onProjectsClick = onProjectsClick,
    onMessagesClick = onMessagesClick,
    onProfileClick = onProfileClick,
    onSettingsClick = onSettingsClick,
    myOption = "Ajustes"
) {
    val twoFactorAuthEnabled = viewModel.twoFactorAuthEnabled.value

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color(0xFF1A1A1A)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título de la Membresía
            Text(
                text = "Membresía DiligenceTech +",
                style = MaterialTheme.typography.titleLarge.copy(color = Color.White),
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 16.dp, bottom = 30.dp, top = 30.dp)
            )

            // Sección de Seguridad
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Autenticación de dos factores",
                    color = Color.White,
                    modifier = Modifier.weight(1f) // Ocupa el espacio restante
                )
                Switch(
                    checked = twoFactorAuthEnabled,
                    onCheckedChange = { enabled ->
                        viewModel.toggleTwoFactorAuth(enabled) // Cambiar el estado de 2FA
                    }
                )
            }

            // Botón de Cerrar sesión
            Button(
                onClick = {
                    viewModel.cerrarSesion(onLogoutSuccess) // Llamar a la función de cerrar sesión
                },
                modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(5.dp)), // Bordes redondeados
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF9B4A18) // Color del fondo
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.log_out_icon),
                    contentDescription = "Logout Icon",
                    tint = Color.White,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Cerrar sesión",
                    color = Color.White,
                    style = MaterialTheme.typography.labelLarge.copy(color = Color.White) // Usamos labelLarge
                )
            }
        }
    }
}
