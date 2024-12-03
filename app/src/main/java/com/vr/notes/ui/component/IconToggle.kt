package com.vr.notes.ui.component

import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun IconToggle(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    checked: Boolean = false,
    onToggle: (Boolean) -> Unit = {},
    description: String?
) {
    IconToggleButton(
        modifier = modifier,
        checked = checked,
        onCheckedChange = onToggle
    ) {
        Icon(
            imageVector = icon,
            contentDescription = description
        )
    }
}