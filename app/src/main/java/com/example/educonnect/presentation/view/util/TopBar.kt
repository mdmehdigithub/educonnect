package com.example.educonnect.presentation.view.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.educonnect.R
import com.example.educonnect.ui.theme.Sky

@Composable
fun TopBar(
    title: String = ""
){
    Row(
        modifier = Modifier
            .height(80.dp)
            .background(color = Sky)
            .fillMaxWidth(1f),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(0.8f)
        ) {
            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = "EduConnect",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                style = MaterialTheme.typography.displayMedium
            )
        }
        Column(
            modifier = Modifier.weight(0.1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                tint = Color.White,
                painter = painterResource(id = R.drawable.menu_icn),
                contentDescription = null )
        }
    }

}