package com.example.multimoduledaggerhilt

import com.example.base_interface_library.BaseInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Singleton
    @Provides
    fun provideBaseInterfaceObject(): BaseInterface {
        return object: BaseInterface {
            override val text: String = "Based Interface Object Impl"
        }
    }
}
