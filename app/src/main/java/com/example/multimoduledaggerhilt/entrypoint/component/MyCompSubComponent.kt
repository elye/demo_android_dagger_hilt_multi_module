package com.example.multimoduledaggerhilt.entrypoint.component

import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Inject
import javax.inject.Scope

@Subcomponent(modules = [MyModule::class])
interface MyCompSubComponent {
    fun inject(presenter: MyPresenter)
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
    override val msg: String = "MyCompSubCompModuleImpl"
}

interface MySubCompModuleInterface {
    val msg: String
}
