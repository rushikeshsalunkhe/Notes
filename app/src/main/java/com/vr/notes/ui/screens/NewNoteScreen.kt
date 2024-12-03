package com.vr.notes.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ContentCopy
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Help
import androidx.compose.material.icons.outlined.Label
import androidx.compose.material.icons.outlined.PersonAdd
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vr.notes.ui.theme.NotesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewNoteScreen(
    modifier: Modifier = Modifier,
//    scaffoldState: BottomSheetScaffoldState
) {
    var noteTitle by remember { mutableStateOf("") }
    var noteContent by remember { mutableStateOf("") }
    val sheetState = rememberModalBottomSheetState()
    LazyColumn(
        modifier = modifier
    ) {

        item {
            BasicTextField(
                value = noteTitle,
                onValueChange = {
                    noteTitle = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                textStyle = MaterialTheme.typography.titleLarge.copy(
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 25.sp
                )
            ) { innerTextField ->
                Box(modifier = Modifier) {
                    if (noteTitle.isEmpty())
                        Text(
                            text = "Title",
                            fontSize = MaterialTheme.typography.titleLarge.fontSize,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    innerTextField()
                }
            }
        }
        item {
            BasicTextField(
                value = noteContent,
                onValueChange = {
                    noteContent = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                textStyle = MaterialTheme.typography.titleLarge.copy(
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 16.sp
                )
            ) { innerTextField ->
                Box(modifier = Modifier) {
                    if (noteContent.isEmpty())
                        Text(
                            text = "Note",
                            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    innerTextField()
                }
            }
        }
//        item {
//            MoreOptionsDrawer(sheetState = sheetState)
//        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreOptionsDrawer(
    sheetState: SheetState
) {
    val outlinedIcons = Icons.Outlined
    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = {},
        dragHandle = {}
    ) {
        DrawerItem(
            icon = outlinedIcons.Delete,
            text = "Delete"
        )
        DrawerItem(
            icon = outlinedIcons.ContentCopy,
            text = "Make a copy"
        )
        DrawerItem(
            icon = outlinedIcons.Share,
            text = "Share"
        )
        DrawerItem(
            icon = outlinedIcons.PersonAdd,
            text = "Collaborator"
        )
        DrawerItem(
            icon = outlinedIcons.Label,
            text = "Labels"
        )
        DrawerItem(
            icon = outlinedIcons.Help,
            text = "Help & feedback"
        )
    }
}

@Composable
fun DrawerItem(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit = {}
) {
    ListItem(
        leadingContent = {
            Icon(
                imageVector = icon,
                contentDescription = text
            )
        },
        headlineContent = {
            Text(text = text)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun NewNoteScreenPreview() {
    NotesTheme {
        Scaffold {
            NewNoteScreen(modifier = Modifier.padding(it),
//                scaffoldState = rememberBottomSheetScaffoldState()
            )
        }
    }
}