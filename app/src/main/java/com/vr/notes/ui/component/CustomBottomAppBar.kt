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
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomBottomAppBar(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry?.destination
    val currentRoute = currentDestination?.route

    when (currentRoute) {
        "home" -> {}
        "new_note" -> {
            NoteBottomAppBar(
                modifier = modifier,
            )
        }

        else -> {}
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteBottomAppBar(
    modifier: Modifier = Modifier,
) {
    val scope = rememberCoroutineScope()
    val sheetState: SheetState =
        rememberModalBottomSheetState(
            skipPartiallyExpanded = true,
            confirmValueChange = {
                it == SheetValue.Hidden || it == SheetValue.Expanded
            }
        )
    var isSheetOpen by remember { mutableStateOf(false) }
    BottomAppBar(
        modifier = modifier.height(60.dp),
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
        IconButton(onClick = {
            isSheetOpen = true
            scope.launch {
                sheetState.expand()
            }
        }) {
            Icon(
                imageVector = Icons.Outlined.MoreVert, contentDescription = null
            )
        }
    }
    if (isSheetOpen) MoreOptionsDrawer(
        onDismiss = {
            scope.launch {
                sheetState.hide()
            }.invokeOnCompletion {
                isSheetOpen = false
            }
        }, sheetState = sheetState
    )
}