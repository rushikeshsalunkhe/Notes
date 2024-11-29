package com.vr.notes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vr.notes.ui.HomeScreen
import com.vr.notes.ui.NoteScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Home.route
    ) {
        composable(Home.route) {
            HomeScreen(modifier = Modifier)
        }
//        composable(
//            Note.routeWithArgs, Note.arguments, Note.deepLink
//        ) {
//            NoteScreen(modifier = Modifier)
//        }
    }
}