package com.example.multimoduledaggerhilt

import android.content.ComponentName
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.feature_library.FeatureActivity
import com.example.feature_two_library.FeatureTwoActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.my_button).setOnClickListener {
            startActivity(Intent(this, FeatureActivity::class.java))
        }

        findViewById<Button>(R.id.my_button_two).setOnClickListener {
            startActivity(Intent(this, FeatureTwoActivity::class.java))
        }

        findViewById<Button>(R.id.my_inverse_button).setOnClickListener {
            val intent = Intent().also {
                it.component = ComponentName(packageName, "com.example.feature_inverse_library.FeatureInverseActivity")
            }
            startActivity(intent)
        }
    }
}
