package com.vr.notes.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    LazyVerticalStaggeredGrid(
        modifier = modifier,
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 10.dp,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(10.dp)
    ) {
        items(100) {
            NoteCard(it)
        }
    }
}

@Composable
fun NoteCard(i: Int) {
    Card(
        modifier = Modifier.aspectRatio(
            when (i % 3) {
                0 -> 1f
                else -> 0.5f
            }
        )
    ) {
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}