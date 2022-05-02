package com.example.multimoduledaggerhilt.entrypoint.component

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.multimoduledaggerhilt.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ComponentEntrypointActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subcomponent_entrypoint)

        MyPresenter(this)
    }
}