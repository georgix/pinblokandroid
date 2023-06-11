package nz.jing.pinblok.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import nz.jing.pinblok.domain.usecases.Iso3BlockUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideIso3BlockUseCase(): Iso3BlockUseCase {
        return Iso3BlockUseCase()
    }
}