package com.example.multimoduledaggerhilt.entrypoint.component

import android.app.Activity
import android.util.Log
import com.example.base_interface_library.BaseInterface
import com.example.multimoduledaggerhilt.entrypoint.ContextDependency
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Inject

@Component(dependencies = [MyData::class, AnotherComponent::class, CustomComponentDependencies::class])
interface MyComponentEntryPoint {
    fun mySubComponent(): MyCompSubComponent
    fun myData(): MyData
}

class MyData

@Component(modules = [AnotherModule::class])
interface AnotherComponent {
    val anotherInterface: AnotherInterface
}

@DisableInstallInCheck
@Module
class AnotherModule {
    @Provides
    fun provideAnotherInterface(): AnotherInterface = object: AnotherInterface {}
}

@InstallIn(ActivityComponent::class)
@EntryPoint
interface CustomComponentDependencies {
    val baseInterface: BaseInterface
    val contextDependency: ContextDependency
}

interface AnotherInterface

class MyPresenter(activity: Activity) {
    @Inject
    lateinit var mySubCompModuleInterface: MySubCompModuleInterface

    @Inject
    lateinit var anotherInterface: AnotherInterface

    @Inject
    lateinit var myData: MyData

    @Inject
    lateinit var baseInterface: BaseInterface

    @Inject
    lateinit var contextDependency: ContextDependency

    init {
        DaggerMyComponentEntryPoint.builder()
            .customComponentDependencies(
                EntryPointAccessors.fromActivity(
                    activity,
                    CustomComponentDependencies::class.java)
            )
            .anotherComponent(DaggerAnotherComponent.create())
            .myData(MyData()).build().mySubComponent().inject(this)

        Log.d("Tracking", mySubCompModuleInterface.msg)
        Log.d("Tracking", anotherInterface.toString())
        Log.d("Tracking", myData.toString())
        Log.d("Tracking", baseInterface.text)
        Log.d("Tracking", "Activity\n${contextDependency.appContext}\n${contextDependency.actContext}")
    }
}
