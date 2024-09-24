package pe.edu.upc.diligencetech.duediligencemanagement.data.remote

import pe.edu.upc.diligencetech.iam.data.remote.SignUpDto
import pe.edu.upc.diligencetech.iam.data.remote.SignUpResource
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


interface AreasService {
    @Headers(
        value = [
            "accept: application/json"
        ]
    )
    @POST("authentication/sign-up")
    fun signUp(@Body signUpResource: SignUpResource): Call<SignUpDto?>
}