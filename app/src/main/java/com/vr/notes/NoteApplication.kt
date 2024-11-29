package com.vr.notes

import android.app.Application
import com.vr.notes.data.AppContainer
import com.vr.notes.data.AppDataContainer

class NoteApplication: Application() {
    lateinit var container : AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}