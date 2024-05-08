package com.example.educonnect.presentation.view.notes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.example.educonnect.presentation.view.util.BottomBar
import com.example.educonnect.ui.theme.Sky

//-------------- Test Data -------------------------
data class Subject(
    val courseCode: String,
    val title: String
)
val subjectlist  = listOf<Subject>(
    Subject(courseCode = "CS410", title = "Distributed System",),
    Subject(courseCode = "CS412", title = "Cryptography"),
    Subject(courseCode = "CS417", title = "Mobile Computing Course"),
    )
//-------------- Test Data -------------------------

@Composable
fun SubjectList(){
    Scaffold(
        bottomBar = {
            BottomBar()
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
            items(subjectlist) {
                SubjectCard(
                    title = it.title,
                    courseCode = it.courseCode,
                    onClick = { /*TODO*/ })
            }
        }
    }
}

@Composable
private fun SubjectCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    title: String = "Title",
    courseCode: String = "Code"
){
    Card(
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(top = 15.dp)
            .width(300.dp)
            .height(80.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(25.dp),

        ){
        Row(
            modifier = Modifier
                .weight(0.6f)
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Spacer(modifier = Modifier.padding(start = 15.dp))
            Text(
                text = "$courseCode - $title",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Preview
@Composable
private fun SubjectCardPreview(){
    SubjectCard(
        onClick = {}
    )
}

@Preview
@Composable
private fun SubjectListPreview(){
    SubjectList()
}