package com.vr.notes.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ContentCopy
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Help
import androidx.compose.material.icons.outlined.Label
import androidx.compose.material.icons.outlined.PersonAdd
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.vr.notes.AppNavHost
import com.vr.notes.ui.component.CustomBottomAppBar
import com.vr.notes.ui.component.CustomFAB
import com.vr.notes.ui.component.CustomTopAppBar
import com.vr.notes.ui.screens.DrawerItem
import com.vr.notes.ui.theme.NotesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
//    val scaffoldState = rememberBottomSheetScaffoldState()
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CustomTopAppBar(
                modifier = Modifier.fillMaxWidth(),
                navController = navController,
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            CustomFAB(
                modifier = Modifier, navController = navController
            )
        },
        bottomBar = {
            CustomBottomAppBar(
                modifier = Modifier,
                navController = navController,
//                scaffoldState = scaffoldState
            )
        },
        floatingActionButtonPosition = FabPosition.End,
//        contentWindowInsets = WindowInsets(left = 0, right = 0)
    ) { innerPadding ->
        AppNavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
//            scaffoldState = scaffoldState
        )
//        BottomSheetScaffold(
//            scaffoldState = scaffoldState,
//            sheetSwipeEnabled = false,
//            sheetContent = { },
//        ) {
//            val outlinedIcons = Icons.Outlined
//            DrawerItem(
//                icon = outlinedIcons.Delete, text = "Delete"
//            )
//            DrawerItem(
//                icon = outlinedIcons.ContentCopy, text = "Make a copy"
//            )
//            DrawerItem(
//                icon = outlinedIcons.Share, text = "Share"
//            )
//            DrawerItem(
//                icon = outlinedIcons.PersonAdd, text = "Collaborator"
//            )
//            DrawerItem(
//                icon = outlinedIcons.Label, text = "Labels"
//            )
//            DrawerItem(
//                icon = outlinedIcons.Help, text = "Help & feedback"
//            )
//        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_7)
@Composable
fun AppPreview() {
    NotesTheme {
        Scaffold {
            App(Modifier.padding(it))
        }
    }
}