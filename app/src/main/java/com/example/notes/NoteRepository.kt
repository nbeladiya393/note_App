package com.example.notes

import androidx.lifecycle.LiveData

class NoteRepository(private val notesDao: NotesDao) {

    val allNotes: LiveData<List<Note>> = notesDao.getAllNotes()



    //created function for inserting data
    suspend fun insert(note: Note){
        notesDao.insert(note)
    }

    //created function for deleting notes
    suspend fun delete(note: Note){
        notesDao.delete(note)
    }

    //created function for deleting notes
    suspend fun update(note: Note) {
        notesDao.update(note)
    }
}