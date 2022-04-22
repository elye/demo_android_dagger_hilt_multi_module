package com.example.feature_two_library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.base_android_library.AndroidBaseClass
import com.example.base_android_library.InterfaceFeatureObject
import com.example.base_android_library.InterfaceObject
import com.example.base_interface_library.BaseInterface
import com.example.base_library.VanillaBaseClass
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class FeatureTwoActivity : AppCompatActivity() {
    @Inject
    lateinit var vanillaBaseClass: VanillaBaseClass

    @Inject
    lateinit var featureTwoClass: FeatureTwoClass

    @Inject
    lateinit var androidBaseClass: AndroidBaseClass

    @Inject
    lateinit var interfaceObj: InterfaceObject

    @Inject
    lateinit var baseInterfaceObject: BaseInterface

    @Inject
    @Named("FeatureTwo")
    lateinit var interfaceFeatureObject: InterfaceFeatureObject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_two)

        findViewById<TextView>(R.id.my_text).text = "Feature Two Library\n\n" +
                vanillaBaseClass.text + "\n" + vanillaBaseClass + "\n\n" +
                featureTwoClass.text + "\n" + featureTwoClass + "\n\n" +
                androidBaseClass.text + "\n" + androidBaseClass + "\n\n" +
                interfaceObj.text + "\n" + interfaceObj + "\n\n" +
                baseInterfaceObject.text + "\n" + baseInterfaceObject + "\n\n" +
                interfaceFeatureObject.text + "\n" + interfaceFeatureObject
    }
}
