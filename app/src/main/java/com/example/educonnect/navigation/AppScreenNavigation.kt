package com.example.educonnect.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.educonnect.presentation.view.notes.NoteList

@Composable
fun AppScreenNavigation(
    navHostController: NavHostController
){
    NavHost(
        navController = navHostController,
        route = NavigationScreenNames.MainScreens.route,
        startDestination = NavigationScreenNames.Notes.route )
    {
        composable(route = NavigationScreenNames.Notes.route) {
            NoteList()
        }
    }
}
