package pe.edu.upc.diligencetech.communications.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import pe.edu.upc.diligencetech.common.WorkbenchScreen

@Composable
fun ProjectsListForCommunicationsScreen(
    onHomeClick: () -> Unit,
    onProjectsClick: () -> Unit,
    onMessagesClick: () -> Unit,
    onProfileClick: () -> Unit,
    onSettingsClick: () -> Unit,
) = WorkbenchScreen(
    onHomeClick = onHomeClick,
    onProjectsClick = onProjectsClick,
    onMessagesClick = onMessagesClick,
    onProfileClick = onProfileClick,
    onSettingsClick = onSettingsClick
) {
    Text("Communications")
}