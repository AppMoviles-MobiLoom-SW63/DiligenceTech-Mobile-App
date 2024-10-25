package pe.edu.upc.diligencetech.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pe.edu.upc.diligencetech.common.SessionManager
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // Indica que el módulo estará disponible en toda la app
object AppModule {

    @Provides
    @Singleton
    fun provideSessionManager(): SessionManager {
        return SessionManager()
    }
}
