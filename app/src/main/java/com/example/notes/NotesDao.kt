package com.example.notes

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface NotesDao {

    // first insert operation will be performed
    @Insert(onConflict = OnConflictStrategy.IGNORE)

    // creating INSERT function and model class will be linked with it
    suspend fun insert(note: Note)

    // second update operation will be performed
    @Update
    // creating UPDATE function and model call will be linked with it
    suspend fun update(note: Note)

    //third delete operation will be performed
    @Delete
    //creating DELETE function and model call will be linked iwth it
    suspend fun delete(note: Note)

    //fourth reading operation will be performed (QUERY will be used) ORDER in the form of ascending or descending will be given
    @Query("select * from NotesTable order by id ASC")
    //fun is created for live update and to read
    fun getAllNotes() : LiveData<List<Note>>


}