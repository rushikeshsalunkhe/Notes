package com.vr.notes

import kotlinx.serialization.Serializable

@Serializable
sealed interface Routes {
    val route: String
}

@Serializable
data object Home : Routes {
    override val route = "home"
}

@Serializable
data object NewNote : Routes {
    override val route: String = "new_note"
}


//@Serializable
//data object Note : Routes {
//    override val route: String = "note"
//    const val NOTE_ID_ARG = "noteId"
//    val routeWithArgs = "$route/{$NOTE_ID_ARG}"
//    val arguments = listOf(
//        navArgument(NOTE_ID_ARG) { type = NavType.LongType }
//    )
//    val deepLink = listOf(
//        navDeepLink { uriPattern = "notes://$route/${NOTE_ID_ARG}" }
//    )
//}
