package com.example.feature_two_library

import com.example.base_android_library.InterfaceFeatureObject
import com.example.base_android_library.InterfaceObject
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object InterfaceFeatureObjectModule {

    @ActivityScoped
    @Provides
    @Named("FeatureTwo")
    fun provideInterfaceFeatureObject(): InterfaceFeatureObject {
        return object: InterfaceFeatureObject {
            override val text: String = "Interface Feature 2 Object Impl"
        }
    }
}
