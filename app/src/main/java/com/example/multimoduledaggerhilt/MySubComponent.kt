package com.example.multimoduledaggerhilt

import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Inject

@Subcomponent(modules = [MyModule::class])
interface MySubComponent {

    // Factory to create instances of UserComponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): MySubComponent
    }

    // Classes that can be injected by this Component
    fun inject(activity: MainActivity)
}

@DisableInstallInCheck
@Module
class MyModule  {
    @Provides
    fun provideTestInterface(): MySubCompModuleInterface {
        return MySubCompModuleImpl()
    }
}

class MySubCompModuleImpl @Inject constructor() : MySubCompModuleInterface {
    override val msg: String = "MySubCompModuleImpl"
}

interface MySubCompModuleInterface {
    val msg: String
}
