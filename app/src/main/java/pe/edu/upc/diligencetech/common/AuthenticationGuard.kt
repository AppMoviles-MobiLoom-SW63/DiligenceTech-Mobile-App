package pe.edu.upc.diligencetech.common

class AuthenticationGuard(private var token: String? = "lmao") {
    private fun isAuthenticated(): Boolean {
        return token != null
    }

    fun guard(onNotAuthenticatedTask: () -> Unit) {
        if (!isAuthenticated()) {
            onNotAuthenticatedTask()
        }
    }
}