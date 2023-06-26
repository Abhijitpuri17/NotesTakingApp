package com.example.notesappcleanarchitecture.feature_note.domain.use_case

import com.example.notesappcleanarchitecture.feature_note.domain.model.InvalidNoteException
import com.example.notesappcleanarchitecture.feature_note.domain.model.Note
import com.example.notesappcleanarchitecture.feature_note.domain.repository.NoteRepository
import javax.inject.Inject

class AddNote(
    private val repository: NoteRepository) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note){
        if(note.title.isBlank() || note.title.isEmpty()){
            throw InvalidNoteException("Title of the note can't be empty!")
        }
        if(note.content.isBlank() || note.content.isEmpty()){
            throw InvalidNoteException("Content of the note can't be empty!")
        }
        repository.insertNote(note = note)
    }
}