package com.example.notesappcleanarchitecture.feature_note.data.datasource

import androidx.room.*
import com.example.notesappcleanarchitecture.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query(value ="Select * from note")
    fun getNotes(): Flow<List<Note>>

    @Query("select * from note where id = :id")
    suspend fun getNoteById(id: Int): Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}