package com.example.educonnect.presentation.view.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.educonnect.navigation.NavigationScreenNames
import com.example.educonnect.presentation.view.util.CustomTextField
import com.example.educonnect.ui.theme.Sky


@Composable
fun ForgotPass(navHostController: NavHostController){

    var id by remember { mutableStateOf("") }
    var verification by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .height(90.dp)
                    .background(color = Sky)
                    .fillMaxWidth(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 2.dp, top = 2.dp),
                    text = "EduConnect",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    style = MaterialTheme.typography.displayMedium
                )

                Text(
                    text =  "Forgot Password",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    ) {
        it ->
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxWidth(1f)
                .fillMaxHeight(1f)
                .background(color = Sky),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(top = 10.dp),
                text = if(verification){"Verification code"}else{"Find your Account"},
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium)
            Column(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 10.dp)
                    .fillMaxWidth(1f)
                    .background(
                        color = Color.White.copy(alpha = 0.3f),
                        shape = RoundedCornerShape(20.dp)
                    )
            ) {
                Column(
                    modifier = Modifier.padding(15.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(bottom = 5.dp),
                        text = if(verification){"Enter the 6 digit verification code that we sent to "}else{"Enter your ID"},
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )
                    CustomTextField(
                        modifier = Modifier.height(40.dp),
                        value = id,
                        onValueChange = { id = it },
                        placeholderText = "Enter your verification code",
                        placeholderColor = Sky
                    )

                }

            }

            Column(
                modifier = Modifier
                    .fillMaxWidth(1f),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    modifier = Modifier
                        .height(40.dp)
                        .width(200.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White) ,
                    onClick = { verification = !verification }
                ) {
                    Text(
                        text = "Next",
                        color = Sky,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    modifier = Modifier
                        .height(40.dp)
                        .width(220.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White) ,
                    onClick = {
                        navHostController.navigate(NavigationScreenNames.Login.route)
                    }
                ) {
                    Text(
                        text = "Return back to login",
                        color = Sky,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ForgotPassPreview(){
    ForgotPass(navHostController = rememberNavController())
}