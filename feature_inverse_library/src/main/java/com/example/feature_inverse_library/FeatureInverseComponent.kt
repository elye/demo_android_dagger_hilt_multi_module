package com.example.feature_inverse_library

import com.example.multimoduledaggerhilt.MainComponent
import dagger.Component

@Component(dependencies = [MainComponent::class])
interface FeatureInverseComponent {

    fun inject(activity: FeatureInverseActivity)

    @Component.Factory
    interface Factory {
        fun create(dependencies: MainComponent): FeatureInverseComponent
    }
}
