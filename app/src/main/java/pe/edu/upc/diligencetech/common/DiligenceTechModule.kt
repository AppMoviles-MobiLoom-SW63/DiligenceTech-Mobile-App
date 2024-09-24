package pe.edu.upc.diligencetech.common

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pe.edu.upc.diligencetech.iam.data.remote.AuthenticationService
import pe.edu.upc.diligencetech.iam.data.repositories.AuthenticationRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DiligenceTechModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideAuthenticationGuard(): AuthenticationGuard {
        return AuthenticationGuard()
    }

    @Provides
    @Singleton
    fun provideAuthenticationService(retrofit: Retrofit): AuthenticationService {
        Log.d("RetrofitInstance", retrofit.toString())
        return retrofit.create(AuthenticationService::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthenticationRepository(authenticationService: AuthenticationService): AuthenticationRepository {
        return AuthenticationRepository(authenticationService)
    }
}