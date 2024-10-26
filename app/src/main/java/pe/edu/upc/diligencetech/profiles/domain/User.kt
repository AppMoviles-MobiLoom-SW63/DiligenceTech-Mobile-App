package pe.edu.upc.diligencetech.profiles.domain

data class User(
    val id: String,
    val name: String,
    val email: String,
    val totalProjects: Int,
    val timeInCompany: String
)