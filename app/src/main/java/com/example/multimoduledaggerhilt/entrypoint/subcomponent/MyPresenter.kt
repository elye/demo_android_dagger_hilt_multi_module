package com.example.multimoduledaggerhilt.entrypoint.subcomponent

import android.app.Activity
import android.util.Log
import com.example.base_interface_library.BaseInterface
import com.example.multimoduledaggerhilt.entrypoint.ContextDependency
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Inject

class MyPresenter(activity: Activity) {
    @InstallIn(ActivityComponent::class)
    @EntryPoint
    interface MySubComponentEntryPoint {
        fun mySubComponent(): MySubComponent
    }

    @Inject
    lateinit var mySubCompModuleInterface: MySubCompModuleInterface

    @Inject
    lateinit var baseInterface: BaseInterface

    @Inject
    lateinit var contextDependency: ContextDependency

    init {
        val entryPoint = EntryPointAccessors.fromActivity(activity, MyPresenter.MySubComponentEntryPoint::class.java)
        entryPoint.mySubComponent().inject(this)

        Log.d("Tracking", mySubCompModuleInterface.msg)
        Log.d("Tracking", baseInterface.text)
        Log.d("Tracking", "Activity\n${contextDependency.appContext}\n${contextDependency.actContext}")
    }
}
