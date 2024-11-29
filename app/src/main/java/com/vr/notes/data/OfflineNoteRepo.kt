package com.vr.notes.data

import kotlinx.coroutines.flow.Flow

class OfflineNoteRepo(private val noteDao: NoteDao) : NoteRepo {

    override suspend fun insertNote(note: Note) = noteDao.insertNote(note)

    override fun getAllNotes(): Flow<List<Note>> = noteDao.getAllNotes()

    override fun getNoteById(id: Long): Flow<Note> = noteDao.getNoteById(id = id)

    override suspend fun updateNote(note: Note) = noteDao.updateNote(note)

    override suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)

}