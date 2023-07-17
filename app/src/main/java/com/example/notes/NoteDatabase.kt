package com.example.notes

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Note::class), version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    // calling notesdao class

    abstract fun getNotesDao() :  NotesDao

    //creating companion object in which we will create instance for our database
    companion object{

        @Volatile
        private var INSTANCE:NoteDatabase? = null

        fun getDatabase(context: Context): NoteDatabase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    // specify name of database
                    "note_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}