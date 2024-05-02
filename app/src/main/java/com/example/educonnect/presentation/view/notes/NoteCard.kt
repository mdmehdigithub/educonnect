package com.example.educonnect.presentation.view.notes


import android.speech.tts.TextToSpeech
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.educonnect.R
import com.example.educonnect.ui.theme.EduConnectTheme

@Composable
fun NoteCard(
    modifier: Modifier = Modifier,
    title: String = "Title",
    date: String = "Date",
    onClick: () -> Unit,
    backGroundColor: CardColors = CardDefaults.cardColors(White),
){
    var extra by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(top = 15.dp)
            .width(300.dp)
            .height(
                if (extra) {
                    80.dp
                } else {
                    60.dp
                }
            ),
        colors = backGroundColor,
        elevation = CardDefaults.cardElevation(25.dp),

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        )
        {
            Row(
                modifier = Modifier
                    .weight(0.1f)
                    .fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    modifier = Modifier.padding(4.dp),
                    tint = Color.Unspecified,
                    painter = painterResource(id = R.drawable.pdf_file_icon_svg),
                    contentDescription = null)
            }
            Row(
                modifier = Modifier
                    .weight(0.6f)
                    .fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    modifier = Modifier.padding(start = 15.dp),
                    text = title,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineSmall
                )
            }

            Row(
                modifier = Modifier
                    .weight(0.1f)
                    .fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Icon(
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .clickable(
                            onClick = {
                                extra = !extra
                            }
                        ),
                    painter = painterResource(id = if(extra){R.drawable.expand_less}else{R.drawable.expand_more_icn}),
                    contentDescription = null)
            }
        }
        if(extra){
            Text(
                modifier = Modifier.padding(start = 15.dp),
                text = date,
                style = MaterialTheme.typography.labelMedium
            )
        }
    }

}


@Preview
@Composable
private fun NoteCardPreview(){
    EduConnectTheme {
        NoteCard(onClick = {})
    }
}