package pe.edu.upc.diligencetech.common

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import pe.edu.upc.diligencetech.duediligencemanagement.data.remote.AreasService
import pe.edu.upc.diligencetech.duediligencemanagement.data.remote.DueDiligenceProjectsService
import pe.edu.upc.diligencetech.duediligencemanagement.data.remote.FoldersService
import pe.edu.upc.diligencetech.duediligencemanagement.data.repositories.AreasRepository
import pe.edu.upc.diligencetech.duediligencemanagement.data.repositories.DueDiligenceProjectsRepository
import pe.edu.upc.diligencetech.duediligencemanagement.data.repositories.FoldersRepository
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
    fun provideAuthInterceptor(): AuthInterceptor {
        return AuthInterceptor { Constants.token }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
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
    fun provideAreaService(
        retrofit: Retrofit
    ): AreasService {
        return retrofit.create(AreasService::class.java)
    }

    @Provides
    @Singleton
    fun provideFoldersService(
        retrofit: Retrofit
    ): FoldersService {
        return retrofit.create(FoldersService::class.java)
    }

    @Provides
    @Singleton
    fun providesDueDiligenceProjectsService(
        retrofit: Retrofit
    ): DueDiligenceProjectsService {
        return retrofit.create(DueDiligenceProjectsService::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthenticationRepository(authenticationService: AuthenticationService): AuthenticationRepository {
        return AuthenticationRepository(authenticationService)
    }

    @Provides
    @Singleton
    fun provideDueDiligenceProjectsRepository(dueDiligenceProjectsService: DueDiligenceProjectsService): DueDiligenceProjectsRepository {
        return DueDiligenceProjectsRepository(dueDiligenceProjectsService)
    }

    @Provides
    @Singleton
    fun provideFoldersRepository(foldersService: FoldersService): FoldersRepository {
        return FoldersRepository(foldersService)
    }

    @Provides
    @Singleton
    fun provideAreasRepository(areasService: AreasService): AreasRepository {
        return AreasRepository(areasService)
    }
}