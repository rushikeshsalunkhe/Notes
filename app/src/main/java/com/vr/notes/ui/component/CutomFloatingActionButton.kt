package com.vr.notes.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Brush
import androidx.compose.material.icons.rounded.CheckBox
import androidx.compose.material.icons.rounded.Image
import androidx.compose.material.icons.rounded.TextFields
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.vr.notes.model.Fab
import com.vr.notes.ui.theme.NotesTheme

@Composable
fun CustomFAB(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry?.destination
    val currentRoute = currentDestination?.route
    when (currentRoute) {
        "home" -> {
            NotesFAB(modifier = modifier, navController = navController)
        }

        else -> {}
    }
}

@Composable
fun NotesFAB(modifier: Modifier = Modifier, navController: NavController) {
    val fabs = listOf<Fab>(
        Fab("Image", Icons.Rounded.Image, "new_note"),
        Fab("Drawing", Icons.Rounded.Brush, "new_note"),
        Fab("List", Icons.Rounded.CheckBox, "new_note"),
        Fab("Text", Icons.Rounded.TextFields, "new_note"),
    )
    var expanded by remember { mutableStateOf(false) }
    Column(
        horizontalAlignment = Alignment.End
    ) {
        AnimatedVisibility(
            visible = expanded,
            enter = expandVertically(),
            exit = shrinkVertically()
        ) {
            LazyColumn(
                horizontalAlignment = Alignment.End
            ) {
                items(fabs) { fab ->
                    OptionFAB(
                        modifier = Modifier.padding(bottom = 10.dp),
                        icon = fab.icon,
                        text = fab.text,
                        onClick = { navController.navigate(fab.route) }
                    )
                }
            }
        }
        FloatingActionButton(
            modifier = modifier,
            onClick = { expanded = !expanded },
            elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(
                defaultElevation = 3.dp
            )
        ) {
            Icon(
                imageVector = Icons.Default.Add, contentDescription = null
            )
        }
    }
}

@Composable
fun OptionFAB(
    modifier: Modifier = Modifier, icon: ImageVector, text: String, onClick: () -> Unit = {}
) {
    ExtendedFloatingActionButton(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(50),
        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(
            defaultElevation = 3.dp
        ),
    ) {
        Text(text = text)
        Spacer(modifier = Modifier.width(10.dp))
        Icon(
            imageVector = icon, contentDescription = null
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CustomFABPreview() {
    NotesTheme {
        Scaffold(floatingActionButton = { CustomFAB(navController = rememberNavController()) }) {
            Box(modifier = Modifier.padding(it)) {}
        }
    }
}