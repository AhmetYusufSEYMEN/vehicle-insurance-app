package com.ersinberkealemdaroglu.arackaskodegerlistesi.di

import com.ersinberkealemdaroglu.arackaskodegerlistesi.data.remote.datasource.InsureDataSource
import com.ersinberkealemdaroglu.arackaskodegerlistesi.data.remote.repository.InsureRepository
import com.ersinberkealemdaroglu.arackaskodegerlistesi.data.remote.repository.repositoryImp.InsureRepositoryImp
import com.ersinberkealemdaroglu.arackaskodegerlistesi.domain.InsureUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DiModule {

    @Singleton
    @Provides
    fun providerInsureRepository(insureDataSource: InsureDataSource): InsureRepository {
        return InsureRepositoryImp(insureDataSource)
    }

    @Singleton
    @Provides
    fun providerInsureUseCase(insureRepository: InsureRepository): InsureUseCase {
        return InsureUseCase(insureRepository)
    }

    @Qualifier
    annotation class DispatcherIO

    @Qualifier
    annotation class DispatcherMain

    @Singleton
    @Provides
    @DispatcherIO
    fun providerDispatcherIO(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    @Singleton
    @Provides
    @DispatcherMain
    fun providerDispatcherMain(): CoroutineDispatcher {
        return Dispatchers.Main
    }


}