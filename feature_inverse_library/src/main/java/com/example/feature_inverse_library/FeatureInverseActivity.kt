package com.example.feature_inverse_library

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.base_interface_library.BaseInterface
import com.example.multimoduledaggerhilt.MainComponent
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject
import javax.inject.Singleton

class FeatureInverseActivity : AppCompatActivity() {

    @Inject
    lateinit var baseInterfaceObject: BaseInterface

    @Inject
    lateinit var featureInverseClass: FeatureInverseClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_inverse)

        DaggerFeatureInverseComponent.factory().create(
            EntryPointAccessors.fromApplication(this, MainComponent::class.java)
        ).inject(this)

        findViewById<TextView>(R.id.my_text).text = "Feature Inverse Library\n\n" +
                baseInterfaceObject.text + "\n" + baseInterfaceObject + "\n\n" +
                featureInverseClass.text + "\n" + featureInverseClass
    }
}

@Singleton
class FeatureInverseClass @Inject constructor(){
    val text = "My Feature Inverse Class"
}
