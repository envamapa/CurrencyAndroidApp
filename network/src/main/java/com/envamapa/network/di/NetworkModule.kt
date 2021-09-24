package com.envamapa.network.di

import com.envamapa.network.Network
import com.envamapa.network.NetworkImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providesNetwork(): Network = NetworkImpl()
}
