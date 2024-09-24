package pe.edu.upc.diligencetech.common

class AuthenticationGuard(var token: String? = null) {
    private fun isAuthenticated(): Boolean {
        return token != null
    }

    fun signIn(token: String) {
        this.token = token
    }

    fun guard(onNotAuthenticatedTask: () -> Unit) {
        if (!isAuthenticated()) {
            onNotAuthenticatedTask()
        }
    }
}