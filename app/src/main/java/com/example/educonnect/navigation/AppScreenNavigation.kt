package com.example.educonnect.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.educonnect.presentation.view.chat.ChatListScreen
import com.example.educonnect.presentation.view.chat.ChatScreen
import com.example.educonnect.presentation.view.notes.NoteList
import com.example.educonnect.presentation.view.notes.NoteScreen
import com.example.educonnect.presentation.view.notes.SubjectList
import com.example.educonnect.presentation.viewmodel.notes.ChatViewModel
import com.example.educonnect.presentation.viewmodel.notes.NoteViewModel

@Composable
fun AppScreenNavigation(
    navHostController: NavHostController
){
    NavHost(
        navController = navHostController,
        route = NavigationScreenNames.MainScreens.route,
        startDestination = NavigationScreenNames.Subject.route )
    {
        composable(route = NavigationScreenNames.Subject.route){
            val subjectViewModel = it.sharedAppViewModel<NoteViewModel>(navController = navHostController)
            SubjectList(noteViewModel= subjectViewModel, navHostController = navHostController)
        }
        composable(route = NavigationScreenNames.NotesList.route) {
            val subjectViewModel = it.sharedAppViewModel<NoteViewModel>(navController = navHostController)
            val noteUIState by subjectViewModel.noteUIState.collectAsState()
            NoteList(noteUIState = noteUIState)
        }
        composable(route = NavigationScreenNames.ChatList.route){
            val chatViewModel = it.sharedAppViewModel<ChatViewModel>(navController = navHostController)
            ChatListScreen(chatViewModel, navHostController)
        }
        composable(route = NavigationScreenNames.Chat.route){
            val chatViewModel = it.sharedAppViewModel<ChatViewModel>(navController = navHostController)
            val chatUi by chatViewModel.chatUIState.collectAsState()
            ChatScreen(chatUi)
        }
    }
}


@Composable
private inline fun < reified T : ViewModel> NavBackStackEntry.sharedAppViewModel(navController: NavController): T
{
    val navGraph = destination.parent?.route ?: return hiltViewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraph)
    }
    return hiltViewModel(parentEntry)
}