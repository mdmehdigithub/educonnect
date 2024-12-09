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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.educonnect.R
import com.example.educonnect.navigation.NavigationScreenNames
import com.example.educonnect.presentation.viewmodel.notes.ChatViewModel
import com.example.educonnect.ui.theme.Sky

@Composable
fun ChatListScreen(
    chatViewModel: ChatViewModel,
    navHostController: NavHostController
){
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
                    numOfText = it.numText,
                    imageID = it.photo,
                    onClick = {
                        chatViewModel.getInfo(it.photo, it.name)
                        navHostController.navigate(NavigationScreenNames.Chat.route)
                    }
                )
            }
        }
    }
}

data class ChatListScreenModel(
    val photo: Int = 0,
    val name: String = "",
    val numText: Int = 0
)

val listOfContact = listOf<ChatListScreenModel>(
    ChatListScreenModel(
        photo = R.drawable.person1,
        name = "Mehdi",
        numText = 20
    ),
    ChatListScreenModel(
        photo = R.drawable.person2,
        name = "Abrar",
        numText = 68
    ),
    ChatListScreenModel(
        photo = R.drawable.person3,
        name = "Faisal",
        numText = 13
    )
)

@Preview
@Composable
fun ChatListScreenPreview(){
    ChatListScreen(
        chatViewModel = ChatViewModel(),
        navHostController = rememberNavController()
    )
}