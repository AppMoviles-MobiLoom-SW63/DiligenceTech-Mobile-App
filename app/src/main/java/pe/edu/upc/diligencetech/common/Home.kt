package pe.edu.upc.diligencetech.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pe.edu.upc.diligencetech.communications.presentation.MessagesListFromProjectScreen
import pe.edu.upc.diligencetech.communications.presentation.ProjectsListForCommunicationsScreen
import pe.edu.upc.diligencetech.dashboard.presentation.DashboardScreen
import pe.edu.upc.diligencetech.duediligencemanagement.presentation.AreasListScreen
import pe.edu.upc.diligencetech.duediligencemanagement.presentation.DocumentsListScreen
import pe.edu.upc.diligencetech.duediligencemanagement.presentation.FoldersListScreen
import pe.edu.upc.diligencetech.duediligencemanagement.presentation.ProjectsListScreen
import pe.edu.upc.diligencetech.iam.presentation.sing_in.SignInScreen
import pe.edu.upc.diligencetech.iam.presentation.sing_up.SignUpScreen
import pe.edu.upc.diligencetech.profiles.presentation.ProfileScreen
import pe.edu.upc.diligencetech.settings.presentation.SettingsScreen
import pe.edu.upc.diligencetech.settings.presentation.TermsAndConditionsScreen

@Composable
fun Home() {
    val authenticationGuard = remember { AuthenticationGuard() }
    val navController = rememberNavController()

    fun guard() {
        authenticationGuard.guard {
            navController.navigate("sign-in") {
                popUpTo(0) { inclusive = true }
            }
        }
    }

    fun clearBackStackAndNavigateTo(destination: String) {
        navController.navigate(destination) {
            popUpTo(0) { inclusive = true }
        }
    }

    NavHost(navController = navController, startDestination = "dashboard") {
        composable("sign-up") {
            SignUpScreen(
                onSignUpTask = {
                    clearBackStackAndNavigateTo("sign-in")
                },
                onSignInTask = {
                    clearBackStackAndNavigateTo("sign-in")
                }
            )
        }
        composable("sign-in") {
            SignInScreen(
                onSignUpTask = {
                    clearBackStackAndNavigateTo("sign-up")
                },
                onSignInTask = { id, username, token ->
                    authenticationGuard.signIn(id, username, token)
                    clearBackStackAndNavigateTo("projects")
                }
            )
        }
        composable("dashboard") {
            guard()
            DashboardScreen(
                onHomeClick = { clearBackStackAndNavigateTo("dashboard") },
                onProjectsClick = { clearBackStackAndNavigateTo("projects") },
                onMessagesClick = { clearBackStackAndNavigateTo("messages") },
                onProfileClick = { clearBackStackAndNavigateTo("profile") },
                onSettingsClick = { clearBackStackAndNavigateTo("settings") }
            )
        }
        composable("projects") {
            guard()
            ProjectsListScreen(
                onHomeClick = { clearBackStackAndNavigateTo("dashboard") },
                onProjectsClick = { clearBackStackAndNavigateTo("projects") },
                onMessagesClick = { clearBackStackAndNavigateTo("messages") },
                onProfileClick = { clearBackStackAndNavigateTo("profile") },
                onSettingsClick = { clearBackStackAndNavigateTo("settings") },
                onEnteringProjectClick = { projectId ->
                    navController.navigate("areas/$projectId")
                }
            )
        }
        composable("messages") {
            guard()
            ProjectsListForCommunicationsScreen(
                onHomeClick = { clearBackStackAndNavigateTo("dashboard") },
                onProjectsClick = { clearBackStackAndNavigateTo("projects") },
                onMessagesClick = { clearBackStackAndNavigateTo("messages") },
                onProfileClick = { clearBackStackAndNavigateTo("profile") },
                onSettingsClick = { clearBackStackAndNavigateTo("settings") },
                onEnteringProjectClick = { projectId ->
                    navController.navigate("messagesList/$projectId")
                }
            )
        }

        composable("profile") {
            guard()
            ProfileScreen(
                onHomeClick = { clearBackStackAndNavigateTo("dashboard") },
                onProjectsClick = { clearBackStackAndNavigateTo("projects") },
                onMessagesClick = { clearBackStackAndNavigateTo("messages") },
                onProfileClick = { clearBackStackAndNavigateTo("profile") },
                onSettingsClick = { clearBackStackAndNavigateTo("settings") },

            )
        }

        // Settings screen with privacy policy navigation
        composable("settings") {
            guard()
            SettingsScreen(
                onHomeClick = { clearBackStackAndNavigateTo("dashboard") },
                onProjectsClick = { clearBackStackAndNavigateTo("projects") },
                onMessagesClick = { clearBackStackAndNavigateTo("messages") },
                onProfileClick = { clearBackStackAndNavigateTo("profile") },
                onSettingsClick = { clearBackStackAndNavigateTo("settings") },
                onLogoutSuccess = {
                    clearBackStackAndNavigateTo("sign-in")
                },
                onPrivacyPolicyClick = { navController.navigate("terms-and-conditions") }
            )
        }

        // Route to Terms and Conditions screen
        composable("terms-and-conditions") {
            TermsAndConditionsScreen(
                onHomeClick = { clearBackStackAndNavigateTo("dashboard") },
                onProjectsClick = { clearBackStackAndNavigateTo("projects") },
                onMessagesClick = { clearBackStackAndNavigateTo("messages") },
                onProfileClick = { clearBackStackAndNavigateTo("profile") },
                onSettingsClick = { clearBackStackAndNavigateTo("settings") },
                onBackClick = { navController.navigate("settings") } // Navega de regreso a SettingsScreen

            )
        }

        // Adjusted AreasListScreen
        composable(
            route = "areas/{projectId}",
            arguments = listOf(navArgument("projectId") {
                type = NavType.LongType
            })
        ) { backStackEntry ->
            val projectId = backStackEntry.arguments?.getLong("projectId") ?: return@composable

            guard()
            AreasListScreen(
                projectId = projectId,
                onHomeClick = { clearBackStackAndNavigateTo("dashboard") },
                onProjectsClick = { clearBackStackAndNavigateTo("projects") },
                onMessagesClick = { clearBackStackAndNavigateTo("messages") },
                onProfileClick = { clearBackStackAndNavigateTo("profile") },
                onSettingsClick = { clearBackStackAndNavigateTo("settings") },
                onEnteringAreaClick = { areaId ->
                    navController.navigate("folders/$projectId/$areaId")
                },
                onBackClick = { navController.navigate("projects") }
            )
        }

        // Adjusted FoldersListScreen to receive projectId and areaId
        composable(
            route = "folders/{projectId}/{areaId}",
            arguments = listOf(
                navArgument("projectId") { type = NavType.LongType },
                navArgument("areaId") { type = NavType.LongType }
            )
        ) { backStackEntry ->
            val projectId = backStackEntry.arguments?.getLong("projectId") ?: return@composable
            val areaId = backStackEntry.arguments?.getLong("areaId") ?: return@composable

            guard()
            FoldersListScreen(
                areaId = areaId,
                onHomeClick = { clearBackStackAndNavigateTo("dashboard") },
                onProjectsClick = { clearBackStackAndNavigateTo("projects") },
                onMessagesClick = { clearBackStackAndNavigateTo("messages") },
                onProfileClick = { clearBackStackAndNavigateTo("profile") },
                onSettingsClick = { clearBackStackAndNavigateTo("settings") },
                onBackClick = { navController.navigate("areas/$projectId") }
            )
        }

        composable(
            route = "messagesList/{projectId}",
            arguments = listOf(navArgument("projectId") {
                type = NavType.LongType
            })
        ) { backStackEntry ->
            val projectId = backStackEntry.arguments?.getLong("projectId") ?: return@composable
            val userId = backStackEntry.arguments?.getLong("userId") ?: return@composable
            val destinationUserId = backStackEntry.arguments?.getLong("destinationUserId") ?: return@composable

            guard()
            MessagesListFromProjectScreen(
                projectId = projectId,
                userId = userId,
                destinationUserId = destinationUserId,
                onHomeClick = { clearBackStackAndNavigateTo("dashboard") },
                onProjectsClick = { clearBackStackAndNavigateTo("projects") },
                onMessagesClick = { clearBackStackAndNavigateTo("messages") },
                onProfileClick = { clearBackStackAndNavigateTo("profile") },
                onSettingsClick = { clearBackStackAndNavigateTo("settings") },
                navController = navController
            )
        }
    }
}
