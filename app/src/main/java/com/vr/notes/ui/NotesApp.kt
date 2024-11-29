package com.vr.notes.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.vr.notes.ui.component.CustomFAB
import com.vr.notes.ui.component.CustomTopAppBar
import com.vr.notes.ui.theme.NotesTheme

@Composable
fun App(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CustomTopAppBar(modifier = Modifier.fillMaxWidth())
        },
        floatingActionButton = {
            CustomFAB(
                modifier = Modifier
            )
        },
        floatingActionButtonPosition = FabPosition.End
    ) { innerPadding ->
        HomeScreen(modifier = Modifier.padding(innerPadding))
//        AppNavHost(
//            modifier = Modifier.padding(innerPadding),
//            navController = navController
//        )
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_7)
@Composable
fun AppPreview() {
    NotesTheme {
        App()
    }
}