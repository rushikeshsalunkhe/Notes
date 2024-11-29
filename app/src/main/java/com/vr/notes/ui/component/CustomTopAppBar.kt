package com.vr.notes.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vr.notes.ui.theme.NotesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        modifier = modifier.fillMaxWidth(),
        title = {
            TextField(
                modifier = modifier.padding(end = 20.dp),
                value = "",
                onValueChange = {},
                shape = RoundedCornerShape(50),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "search"
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "search"
                    )
                }
            )
        },
//        colors = TopAppBarDefaults.topAppBarColors(
//            containerColor = MaterialTheme.colorScheme.primary
//        )
    )
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CustomTopAppBarPreview() {
    NotesTheme {
        CustomTopAppBar(modifier = Modifier.fillMaxWidth())
    }
}