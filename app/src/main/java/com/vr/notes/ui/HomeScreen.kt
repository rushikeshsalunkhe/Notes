package com.vr.notes.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.twotone.Home
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vr.notes.AppViewModelProvider
import com.vr.notes.data.Note
import com.vr.notes.model.Fab
import com.vr.notes.viewModel.HomeVM

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeVM = viewModel(factory = AppViewModelProvider .Factory)
) {
    listOf<Fab>(
        Fab(
            text = "Add",
            icon = Icons.TwoTone.Home
        )
    )
    val homeUiState by viewModel.homeUiState.collectAsState()
    LazyVerticalStaggeredGrid(
        modifier = modifier,
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 10.dp,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(10.dp)
    ) {
        items(homeUiState.noteList) {
            NoteCard(it)
        }
    }
}

@Composable
fun NoteCard(note: Note) {
    Card(
        modifier = Modifier.aspectRatio(1f)
    ) {
        Text(
            modifier = Modifier.padding(5.dp),
            text = note.title,
            maxLines = 2
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}