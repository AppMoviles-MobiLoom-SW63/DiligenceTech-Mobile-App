package pe.edu.upc.diligencetech.iam.data.remote

data class SignUpResource(
    val email: String,
    val firstName: String,
    val lastName: String,
    val password: String,
    val roles: List<String>,
    val username: String
)