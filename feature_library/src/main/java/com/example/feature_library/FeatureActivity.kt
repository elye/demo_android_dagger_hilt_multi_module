package com.example.feature_library

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.base_android_library.AndroidBaseClass
import com.example.base_android_library.InterfaceObject
import com.example.base_interface_library.BaseInterface
import com.example.base_library.VanillaBaseClass
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FeatureActivity : AppCompatActivity() {
    @Inject
    lateinit var vanillaBaseClass: VanillaBaseClass

    @Inject
    lateinit var featureClass: FeatureClass

    @Inject
    lateinit var androidBaseClass: AndroidBaseClass

    @Inject
    lateinit var interfaceObj: InterfaceObject

    @Inject
    lateinit var baseInterfaceObject: BaseInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature)

        findViewById<TextView>(R.id.my_text).text = "Feature Library\n\n" +
                vanillaBaseClass.text + "\n" + vanillaBaseClass + "\n\n" +
                featureClass.text + "\n" + featureClass + "\n\n" +
                androidBaseClass.text + "\n" + androidBaseClass + "\n\n" +
                interfaceObj.text + "\n" + interfaceObj + "\n\n" +
                baseInterfaceObject.text + "\n" + baseInterfaceObject
    }
}
