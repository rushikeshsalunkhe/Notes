package com.vr.notes

import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink

sealed interface Routes {
    val route: String
}

data object Home : Routes {
    override val route: String = "home"
}

data object NewNote : Routes{
    override val route: String = "newNote"
}

data object Note : Routes {
    override val route: String = "note"
    const val NOTE_ID_ARG = "noteId"
    val routeWithArgs = "$route/{$NOTE_ID_ARG}"
    val arguments = listOf(
        navArgument(NOTE_ID_ARG) { type = NavType.LongType }
    )
    val deepLink = listOf(
        navDeepLink { uriPattern = "notes://$route/${NOTE_ID_ARG}" }
    )
}