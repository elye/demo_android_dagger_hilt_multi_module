package com.example.base_library

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VanillaBaseClass @Inject constructor(){
    val text = "My Vanilla Base Class"
}
