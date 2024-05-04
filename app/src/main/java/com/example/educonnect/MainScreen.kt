package com.example.educonnect

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.educonnect.navigation.EduConnectNavigation

@Composable
fun MainScreen(navHostController: NavHostController = rememberNavController()){
    Column(
        modifier = Modifier
            .padding()
            .fillMaxWidth(1f)
            .fillMaxHeight(1f))
    {
        EduConnectNavigation(navHostController = navHostController)
    }
}

@Preview(apiLevel = 33)
@Composable
private fun MainScreenPreview(){
    MainScreen()
}

