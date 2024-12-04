package com.vr.notes

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vr.notes.ui.screens.HomeScreen
import com.vr.notes.ui.screens.NewNoteScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        modifier = modifier, navController = navController, startDestination = Home.route
    ) {
        composable(Home.route) {
            HomeScreen(modifier = Modifier, navController = navController)
        }
        composable(NewNote.route) {
            NewNoteScreen(
                modifier = Modifier.fillMaxSize(),
            )
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