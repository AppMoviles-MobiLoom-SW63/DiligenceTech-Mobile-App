package pe.edu.upc.diligencetech.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.diligencetech.communications.presentation.ProjectsListForCommunicationsScreen
import pe.edu.upc.diligencetech.dashboard.presentation.DashboardScreen
import pe.edu.upc.diligencetech.duediligencemanagement.presentation.ProjectsListScreen
import pe.edu.upc.diligencetech.iam.presentation.sing_in.SignInScreen
import pe.edu.upc.diligencetech.iam.presentation.sing_up.SignUpScreen
import pe.edu.upc.diligencetech.profiles.presentation.ProfileScreen
import pe.edu.upc.diligencetech.settings.presentation.SettingsScreen

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
                })
        }
        composable("sign-in") {
            SignInScreen(
                onSignUpTask = {
                    clearBackStackAndNavigateTo("sign-up")
                },
                onSignInTask = { id, username, token ->
                    authenticationGuard.signIn(id, username, token)
                    clearBackStackAndNavigateTo("dashboard")
                })
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
            ProjectsListScreen (
                onHomeClick = { clearBackStackAndNavigateTo("dashboard") },
                onProjectsClick = { clearBackStackAndNavigateTo("projects") },
                onMessagesClick = { clearBackStackAndNavigateTo("messages") },
                onProfileClick = { clearBackStackAndNavigateTo("profile") },
                onSettingsClick = { clearBackStackAndNavigateTo("settings") }
            )
        }
        composable("messages") {
            guard()
            ProjectsListForCommunicationsScreen(
                onHomeClick = { clearBackStackAndNavigateTo("dashboard") },
                onProjectsClick = { clearBackStackAndNavigateTo("projects") },
                onMessagesClick = { clearBackStackAndNavigateTo("messages") },
                onProfileClick = { clearBackStackAndNavigateTo("profile") },
                onSettingsClick = { clearBackStackAndNavigateTo("settings") }
            )
        }
        composable("profile") {
            guard()
            ProfileScreen (
                onHomeClick = { clearBackStackAndNavigateTo("dashboard") },
                onProjectsClick = { clearBackStackAndNavigateTo("projects") },
                onMessagesClick = { clearBackStackAndNavigateTo("messages") },
                onProfileClick = { clearBackStackAndNavigateTo("profile") },
                onSettingsClick = { clearBackStackAndNavigateTo("settings") }
            )
        }
        composable("settings") {
            guard()
            SettingsScreen (
                onHomeClick = { clearBackStackAndNavigateTo("dashboard") },
                onProjectsClick = { clearBackStackAndNavigateTo("projects") },
                onMessagesClick = { clearBackStackAndNavigateTo("messages") },
                onProfileClick = { clearBackStackAndNavigateTo("profile") },
                onSettingsClick = { clearBackStackAndNavigateTo("settings") }
            )
        }
    }
}