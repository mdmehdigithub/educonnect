package com.example.educonnect

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.educonnect.navigation.AppScreenNavigation
import com.example.educonnect.presentation.view.util.BottomBar

@Composable
fun MainAppScreen(navHostController: NavHostController = rememberNavController()){
    Scaffold (
        bottomBar = {
            BottomBar(navHostController)
        }
    )
    { innerPadding ->
        Column(
            modifier = Modifier
                .padding(PaddingValues(bottom = innerPadding.calculateBottomPadding()))
                .fillMaxWidth(1f)
                .fillMaxHeight(1f))
        {
            AppScreenNavigation(navHostController = navHostController)
        }
    }
}
