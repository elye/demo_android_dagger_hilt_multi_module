package com.example.multimoduledaggerhilt

import com.example.base_interface_library.BaseInterface
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface MainComponent {
    fun basedInterface(): BaseInterface
}