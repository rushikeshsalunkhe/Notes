package com.vr.notes.ui.component

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddAlert
import androidx.compose.material.icons.outlined.Archive
import androidx.compose.material.icons.outlined.PushPin
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.vr.notes.ui.theme.NotesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry?.destination
    val currentRoute = currentDestination?.route
    LaunchedEffect(currentRoute) {
        Log.i("Current Route", currentRoute.toString())
    }
    when (currentRoute) {
        "home" -> {
            CenteredSearchBar(modifier = modifier, scrollBehavior = scrollBehavior)
        }

        "new_note" -> {
            TopBar()
        }

        else -> {}
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        navigationIcon = {
            Icon(
                imageVector = Icons.Rounded.ArrowBackIosNew,
                contentDescription = null,
                modifier = Modifier.padding(start = 10.dp)
            )
        },
        title = {
            Text(text = "")
        },
        actions = {
            IconToggle(
                icon = Icons.Outlined.PushPin,
                checked = false,
                onToggle = { },
                description = null
            )
            IconToggle(
                icon = Icons.Outlined.AddAlert,
                checked = false,
                onToggle = { },
                description = null
            )
            IconToggle(
                icon = Icons.Outlined.Archive,
                checked = false,
                onToggle = { },
                description = null
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenteredSearchBar(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        navigationIcon = {

        },
        title = {
            SearchBar(
                modifier = Modifier,
                inputField = {
                    SearchBarDefaults.InputField(
                        query = "",
                        onQueryChange = {},
                        onSearch = {},
                        expanded = false,
                        onExpandedChange = {},
                        placeholder = {
                            Text(
                                text = "Search Your Notes",
                                textAlign = TextAlign.Center,
//                                fontSize = 17.sp,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Rounded.Menu,
                                contentDescription = null
                            )
                        },
                        trailingIcon = {
                            Row(
                                modifier = Modifier.padding(end = 16.dp),
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.Notifications,
                                    contentDescription = null
                                )
                                Icon(
                                    imageVector = Icons.Rounded.AccountCircle,
                                    contentDescription = null
                                )
                            }
                        }

                    )
                },
                expanded = false,
                onExpandedChange = {},
            ) { }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background.copy(alpha = 0.5f),
            titleContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
            scrolledContainerColor = MaterialTheme.colorScheme.background.copy(alpha = 0.5f)
        ),
        scrollBehavior = scrollBehavior
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_7)
@Composable
fun CustomTopAppBarPreview() {
    NotesTheme {
        CustomTopAppBar(modifier = Modifier.fillMaxWidth())
    }
}