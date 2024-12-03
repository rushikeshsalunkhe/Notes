package com.vr.notes.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController? = null,
//    viewModel: HomeVM = viewModel(factory = AppViewModelProvider .Factory)
) {

//    val homeUiState by viewModel.homeUiState.collectAsState()
    LazyVerticalStaggeredGrid(
        modifier = modifier,
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 10.dp,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(
            top = PaddingValues().calculateTopPadding() + 10.dp,
            start = 10.dp, end = 10.dp
        )
    ) {
//        items(homeUiState.noteList) {
//            NoteCard(it)
//        }
        items(20) {
            NoteCard(it)
        }
    }
}

//@Composable
//fun NoteCard(note: Note) {
//    Card(
//        modifier = Modifier.aspectRatio(1f)
//    ) {
//        Text(
//            modifier = Modifier.padding(5.dp),
//            text = note.title,
//            maxLines = 2
//        )
//    }
//}

@Composable
fun NoteCard(note: Int) {
    OutlinedCard(
        modifier = Modifier.aspectRatio(
            when (note % 3) {
                0 -> 1f
                else -> 0.5f
            }
        )
    ) {
//        Text(
//            modifier = Modifier.padding(5.dp),
//            text = note.title,
//            maxLines = 2
//        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    Scaffold {
        HomeScreen(modifier = Modifier.padding(it))
    }
}