package com.example.notes



import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "NotesTable")
class Note
    (

    // setting column names
    @ColumnInfo(name = "Title") val notesTitle:String,
    @ColumnInfo(name = "Description") val notesDescription:String,
    @ColumnInfo(name = "TimeStamp") val TimeStamp:String
){

        @PrimaryKey(autoGenerate = true) var id = 0
}