package com.vr.notes.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ContentCopy
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Help
import androidx.compose.material.icons.outlined.Label
import androidx.compose.material.icons.outlined.PersonAdd
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vr.notes.ui.screens.DrawerItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreOptionsDrawer(
    onDismiss: () -> Unit = {},
    sheetState: SheetState
) {
    val outlinedIcons = Icons.Outlined
    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = onDismiss,
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