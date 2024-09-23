package pe.edu.upc.diligencetech.common

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.diligencetech.dashboard.presentation.DashboardScreen
import pe.edu.upc.diligencetech.iam.presentation.sing_in.SignInScreen
import pe.edu.upc.diligencetech.iam.presentation.sing_up.SignUpScreen

@Composable
fun Home() {
    val authenticationGuard = AuthenticationGuard()
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "dashboard") {
        composable("sign-up") {
            SignUpScreen(
                onSignUpTask = {
                    navController.navigate("dashboard")
                },
                onSignInTask = {
                    navController.popBackStack()
                })
        }
        composable("sign-in") {
            SignInScreen(
                onSignUpTask = {
                    navController.navigate("sign-up")
                },
                onSignInTask = {
                    navController.navigate("dashboard")
                })
        }
        composable("dashboard") {
            authenticationGuard.guard { navController.navigate("sign-in") }
            DashboardScreen()
        }
    }
}