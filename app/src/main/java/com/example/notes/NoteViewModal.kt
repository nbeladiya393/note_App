package com.example.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModal(application: Application): AndroidViewModel(application) {

    // variable for all notes
    val allNote: LiveData<List<Note>>

    // variable for  repository
    val repository: NoteRepository

    // now init this

    init {

        val dao = NoteDatabase.getDatabase(application).getNotesDao()
        // initializing repository
        repository = NoteRepository(dao)
        // initializing allNote here
        allNote = repository.allNotes
    }

    // creating methods for deleting , updating and adding notes

    // 1st delete note

    fun deleteNote(note: Note) = viewModelScope.launch(Dispatchers.IO){

        repository.delete(note)

 }
}


