package com.vr.notes.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NotesDB : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile
        private var Instance: NotesDB? = null

        fun getDatabase(context: Context): NotesDB {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, NotesDB::class.java, "notes_db")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}