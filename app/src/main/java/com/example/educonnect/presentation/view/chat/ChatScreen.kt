package com.example.educonnect.presentation.view.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.educonnect.presentation.view.util.TopBar
import com.example.educonnect.ui.theme.Sky

@Composable
fun ChatScreen(
    chatListScreenModel: ChatListScreenModel
){
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .height(80.dp)
                    .background(color = Color.White),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    shape = CircleShape,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .background(
                                color = Color.LightGray,
                                shape = CircleShape
                            )
                            .width(60.dp)
                            .height(60.dp),
                        painter = painterResource(id = chatListScreenModel.photo),
                        contentDescription = null)
                }

                Column(
                    modifier = Modifier
                        .weight(0.2f)
                        .padding(start = 10.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Row {
                        Text(
                            text = chatListScreenModel.name,
                            modifier = Modifier.fillMaxWidth(1f),
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                    Row {
                        Text(
                            text = "status",
                            modifier = Modifier.fillMaxWidth(1f),
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                }
            }
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth(1f)
                    .background(color = Color.White),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .height(50.dp)
                        .width(300.dp)
                        .background(color = Color.LightGray, shape = RoundedCornerShape(20.dp))
                        .padding(top = 10.dp, bottom = 10.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Text(
                        modifier = Modifier.padding(start = 10.dp),
                        text = "Type a message"
                    )
                }
            }
        }
    ) {
        paddingValues ->
        Column(
            modifier = Modifier
                .background(color = Sky)
                .fillMaxWidth(1f)
                .fillMaxHeight(1f)
                .padding(paddingValues)
        ) {
            LazyColumn {
                items(2){
                    Row(
                        modifier = Modifier.fillMaxWidth(1f),
                        horizontalArrangement = when(it){
                            0 -> Arrangement.End
                            1 -> Arrangement.Start
                            else -> Arrangement.Start
                        }
                    ) {
                        Chat()
                    }
                }
            }
        }
    }
}

@Composable
private fun Chat(){
    Card(
        modifier = Modifier
            .padding(10.dp)
            .width(intrinsicSize = IntrinsicSize.Max)
            .height(intrinsicSize = IntrinsicSize.Max)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(1f),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 12.dp),
                text = "hello, im am your friend"
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(1f),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(top = 6.dp, bottom = 6.dp, end = 12.dp),
                text = "10:00 AM")
        }

    }
}

@Preview
@Composable
private fun ChatPreview(){
    Chat()
}
@Preview
@Composable
private fun ChatScreenPreview(){
    ChatScreen(ChatListScreenModel())
}