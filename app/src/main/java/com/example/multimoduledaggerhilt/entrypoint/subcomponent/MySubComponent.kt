package com.example.multimoduledaggerhilt.entrypoint.subcomponent

import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Inject

@Subcomponent(modules = [MyModule::class])
interface MySubComponent {
    fun inject(presenter: MyPresenter)

    @Subcomponent.Builder
    interface Builder {
        // The below module injection API is option if the
        // ChildModule doesn't take parameter.
        // But it is required if the Child module need to have
        // parameter
        fun childModule(module: MyModule): Builder
        fun build(): MySubComponent
    }
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
