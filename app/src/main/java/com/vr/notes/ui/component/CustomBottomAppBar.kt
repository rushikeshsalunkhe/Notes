package com.vr.notes.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddBox
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.material.icons.outlined.TextFormat
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomBottomAppBar(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
//    scaffoldState: BottomSheetScaffoldState
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry?.destination
    val currentRoute = currentDestination?.route

    when (currentRoute) {
        "home" -> {}
        "new_note" -> {
            NoteBottomAppBar(
//                scaffoldState = scaffoldState
            )
        }

        else -> {}
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteBottomAppBar(
    modifier: Modifier = Modifier,
//    scaffoldState: BottomSheetScaffoldState
) {
//    val scope = rememberCoroutineScope()
    BottomAppBar(
        modifier = modifier.height(70.dp),
        containerColor = MaterialTheme.colorScheme.background,
        contentPadding = PaddingValues(0.dp),
    ) {
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Outlined.AddBox, contentDescription = null
            )
        }
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Outlined.Palette, contentDescription = null
            )
        }
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Outlined.TextFormat, contentDescription = null
            )
        }
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 10.dp),
            text = "Edited just now",
            color = Color.Gray,
            fontSize = MaterialTheme.typography.bodySmall.fontSize
        )
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Outlined.MoreVert, contentDescription = null
            )
        }
    }
}