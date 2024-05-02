package com.example.educonnect.presentation.view.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ChatCard(
    modifier: Modifier = Modifier,
    name: String = "Name of the person",
    numOfText: Int = 0,
){
    Row(
        modifier = modifier
            .fillMaxWidth(1f)
            .height(100.dp)
            .background(color = Color.White, shape = RoundedCornerShape(16.dp) )
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(1f)
                .weight(0.1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .background(
                        color = Color.LightGray,
                        shape = CircleShape
                    )
                    .width(80.dp)
                    .height(80.dp)
            ) {

            }
        }
        Column(
            modifier = Modifier
                .fillMaxHeight(1f)
                .weight(0.2f),
            verticalArrangement = Arrangement.Center
        ) {
            Row {
                Text(
                    text = name,
                    modifier = Modifier.fillMaxWidth(1f),
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Row {
                Text(
                    text = "Recent message",
                    modifier = Modifier.fillMaxWidth(1f),
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxHeight(1f)
                .weight(0.05f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Time")
            Spacer(modifier = Modifier.padding(5.dp))
            Row(
                modifier = Modifier
                    .background(
                        color = Color.LightGray,
                        shape = CircleShape
                    )
                    .width(26.dp)
                    .height(26.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = numOfText.toString())
            }

        }
    }
}

@Preview
@Composable
private fun ChatCardPreview(){
    ChatCard()
}