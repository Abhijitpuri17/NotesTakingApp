package com.example.notesappcleanarchitecture.feature_note.presentation.add_edit_notes

data class NoteTextFieldText(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true
)