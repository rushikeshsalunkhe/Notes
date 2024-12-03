package com.vr.notes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vr.notes.ui.screens.HomeScreen
import com.vr.notes.ui.screens.NewNoteScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        modifier = modifier, navController = navController, startDestination = Home.route
    ) {
        composable(Home.route) {
            HomeScreen(modifier = Modifier, navController = navController)
        }
        composable(NewNote.route) {
            NewNoteScreen(modifier = Modifier)
        }
//        composable(
//            Note.routeWithArgs, Note.arguments, Note.deepLink
//        ) {
//            NoteScreen(modifier = Modifier)
//        }
    }
}

//fun NavGraphBuilder.notesGraph(navController: NavController) {
//    navigation<Home>(startDestination = Home) {
//        composable<Home> {}
//    }
//}