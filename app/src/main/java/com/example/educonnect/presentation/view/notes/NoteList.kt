package com.example.educonnect.presentation.view.notes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.educonnect.R
import com.example.educonnect.presentation.view.util.BottomBar
import com.example.educonnect.presentation.view.util.TopBar
import com.example.educonnect.presentation.viewmodel.notes.NoteUIState
import com.example.educonnect.ui.theme.Sky

//-------------- Test Data -------------------------
data class Note(
    val title: String,
    val date: String
)

val CS410 = listOf(
    Note(
        "Resource vs communication deadlock","9/07/2024"
    ),
    Note(
        "Logical Clock,","23/11/2024"
    ),
    Note(
        "Lamports and Vectors Logical","19/02/2024"
    ),
)

val CS412 = listOf(
    Note(
        "Security Attacks","9/07/2024"
    ),
    Note(
        "RSA algorithm","23/11/2024"
    ),
    Note(
        "Message Authentication","19/02/2024"
    ),
)

val CS417 = listOf(
    Note(
        "Frequency for radio transmission","9/07/2024"
    ),
    Note(
        "Signals","23/11/2024"
    ),
    Note(
        "Multiplexing","19/02/2024"
    ),
)

val listOfNoteList = listOf<List<Note>>(
    CS410,
    CS412,
    CS417
)

//-------------- Test Data -------------------------


@Composable
fun NoteList(noteUIState: NoteUIState){
    Scaffold(
        topBar = {
            TopBar()
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = Color.White,
                contentColor = Sky
            )
            {
                Icon(
                    painter = painterResource(id = R.drawable.add_icn),
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
            items(listOfNoteList[noteUIState.subjectIndex]) {
                Spacer(modifier = Modifier.padding(start = 15.dp))

                NoteCard(
                    title = it.title,
                    date = "Last Updated on : ${it.date}",
                    onClick = {})
            }
        }
    }
}

@Preview
@Composable
private fun NoteListPreview(){
    MaterialTheme {
        NoteList(noteUIState = NoteUIState())
    }
}