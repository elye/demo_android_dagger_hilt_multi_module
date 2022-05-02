package com.example.multimoduledaggerhilt.entrypoint.subcomponent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.multimoduledaggerhilt.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SubComponentEntrypointActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_component_entrypoint)

        MyPresenter(this)
    }
}