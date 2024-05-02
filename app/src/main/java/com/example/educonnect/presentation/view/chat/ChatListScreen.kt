package com.example.educonnect.presentation.view.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.educonnect.R
import com.example.educonnect.ui.theme.Sky

@Composable
fun ChatListScreen(){
    Scaffold(
        topBar = {
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
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = Color.White,
                contentColor = Sky
            )
            {
                Icon(
                    painter = painterResource(id = R.drawable.add_contact_icn),
                    contentDescription = null )
            }
        }
    ){ paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(1f)
                .padding(paddingValues)
                .background(Sky),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            items(listOfContact) {
                it ->
                ChatCard(
                    modifier = Modifier.padding(top = 10.dp, start = 10.dp, end = 10.dp),
                    name = it.name,
                    numOfText = it.numText
                )
            }
        }
    }
}

data class ChatListScreenModel(
    val photo: String,
    val name: String,
    val numText: Int
)

val listOfContact = listOf<ChatListScreenModel>(
    ChatListScreenModel(
        photo = "Mehdi's Photo",
        name = "Mehdi",
        numText = 20
    ),
    ChatListScreenModel(
        photo = "Abrar's Photo",
        name = "Abrar",
        numText = 68
    )
)

@Preview
@Composable
fun ChatListScreenPreview(){
    ChatListScreen()
}