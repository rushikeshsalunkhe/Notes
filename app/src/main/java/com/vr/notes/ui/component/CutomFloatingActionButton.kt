package com.vr.notes.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vr.notes.ui.theme.NotesTheme

@Composable
fun CustomFAB(
    modifier: Modifier = Modifier
) {
    FloatingActionButton(
        modifier = modifier,
//        containerColor = MaterialTheme.colorScheme.primary,
//        elevation = FloatingActionButtonDefaults.elevation(
//            defaultElevation = 90.dp,
//        ),
        onClick = { }
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = null
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CustomFABPreview() {
    NotesTheme {
        CustomFAB()
    }
}