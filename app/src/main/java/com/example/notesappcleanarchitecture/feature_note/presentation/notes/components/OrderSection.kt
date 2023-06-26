package com.example.notesappcleanarchitecture.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.notesappcleanarchitecture.feature_note.domain.util.NoteOrder
import com.example.notesappcleanarchitecture.feature_note.domain.util.OrderType
import com.example.notesappcleanarchitecture.feature_note.presentation.notes.components.DefaultRadioButton

@Composable
fun OrderSection(
    modifier: Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit
){
    Column(modifier= modifier,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            DefaultRadioButton(text = "Title",
                checked = noteOrder is NoteOrder.Title,
                onSelect = {onOrderChange(NoteOrder.Title(noteOrder.orderType))},
            )
            DefaultRadioButton(text = "Date",
                checked = noteOrder is NoteOrder.Date,
                onSelect = {onOrderChange(NoteOrder.Date(noteOrder.orderType))},
            )
            DefaultRadioButton(text = "Color",
                checked = noteOrder is NoteOrder.Color,
                onSelect = {onOrderChange(NoteOrder.Color(noteOrder.orderType))},
            )
        }
        Spacer(modifier=Modifier.height(16.dp))
        Row(modifier=Modifier.fillMaxWidth()) {
            DefaultRadioButton(text = "Ascending",
                checked = noteOrder.orderType is OrderType.Ascending,
                onSelect = {onOrderChange(noteOrder.copy(OrderType.Ascending))},
            )
            DefaultRadioButton(text = "Descending",
                checked = noteOrder.orderType is OrderType.Descending,
                onSelect = {onOrderChange(noteOrder.copy(OrderType.Descending))},
            )
        }
    }
}