package com.example.feature_library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.android_base_library.AndroidBaseClass
import com.example.base_library.VanilaBaseClass
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class FeatureClass @Inject constructor(){
    val text = "My Feature Class"
}

@AndroidEntryPoint
class FeatureActivity : AppCompatActivity() {
    @Inject
    lateinit var vanilaBaseClass: VanilaBaseClass

    @Inject
    lateinit var featureClass: FeatureClass

    @Inject
    lateinit var androidBaseClass: AndroidBaseClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature)

        findViewById<TextView>(R.id.my_text).text =
            vanilaBaseClass.text + " " + featureClass.text + " " + androidBaseClass.text
    }
}
