package pe.edu.upc.diligencetech.iam.data.remote

data class SignUpDto(
    val email: String,
    val id: Int,
    val roles: List<String>
)