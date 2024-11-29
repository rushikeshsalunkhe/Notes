package com.vr.notes

import android.app.Application

class NoteApplication : Application() {

    lateinit var container: AppContainer


    override fun onCreate() {
        super.onCreate()
        container = AppContainerImpl(this)
    }
}