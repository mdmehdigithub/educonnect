package com.example.educonnect.presentation.view.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.educonnect.R
import com.example.educonnect.ui.theme.Sky

@Composable
fun BottomBar(){
    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(80.dp)
            .background(color = Color.White)
    ) {
        Row(
            modifier = Modifier.weight(0.5f).fillMaxHeight(1f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                tint = Sky,
                painter = painterResource(id = R.drawable.notes_icn),
                contentDescription = null )
        }
        Row(
            modifier = Modifier.weight(0.5f).fillMaxHeight(1f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        )  {
            Icon(
                tint = Sky,
                painter = painterResource(id = R.drawable.chat_icn),
                contentDescription = null )
        }
    }
}

@Preview
@Composable
private fun BottomBarPreview(){
    BottomBar()
}