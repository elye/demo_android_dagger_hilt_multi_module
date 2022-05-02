package com.example.multimoduledaggerhilt.entrypoint

import android.content.Context
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class ContextDependency @Inject constructor(
    @ApplicationContext val appContext: Context,
    @ActivityContext val actContext: Context
)
