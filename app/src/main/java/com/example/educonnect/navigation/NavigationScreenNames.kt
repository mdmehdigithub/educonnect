package com.example.educonnect.navigation

sealed class NavigationScreenNames(val route: String) {
    data object Main: NavigationScreenNames("main")
    data object MainScreens: NavigationScreenNames("main_screen")
    //---------------------- Auth Nav -----------------------------
    data object AuthenticationRoute: NavigationScreenNames("authentication")
    data object Login: NavigationScreenNames("login")
    data object SignIn: NavigationScreenNames("sign_in")
    data object ForgotPassword: NavigationScreenNames("forgot_password")

    //---------------------- Main screen Nav -----------------------------
    data object Chat: NavigationScreenNames("chat")
    data object Notes: NavigationScreenNames("notes")
    data object Profile: NavigationScreenNames("profile")

}