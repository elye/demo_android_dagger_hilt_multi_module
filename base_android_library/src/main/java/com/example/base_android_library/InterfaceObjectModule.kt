package com.example.base_android_library

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

interface InterfaceObject {
    val text: String
}

@Module
@InstallIn(SingletonComponent::class)
object InterfaceObjectModule {

    @Singleton
    @Provides
    fun provideInterfaceObject(): InterfaceObject {
        return object: InterfaceObject {
            override val text: String = "Interface Object Impl"
        }
    }
}
