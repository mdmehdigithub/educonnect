package com.example.educonnect.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.educonnect.MainAppScreen

@Composable
fun EduConnectNavigation(navHostController: NavHostController){
    NavHost(
        navController = navHostController,
        route = NavigationScreenNames.Main.route,
        startDestination = NavigationScreenNames.AuthenticationRoute.route
    ){
        authNavGraph(navHostController = navHostController)
        composable(route = NavigationScreenNames.MainScreens.route){
            MainAppScreen()
        }
    }
}