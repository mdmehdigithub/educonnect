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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.educonnect.navigation.NavigationScreenNames
import com.example.educonnect.presentation.view.util.CustomTextField
import com.example.educonnect.ui.theme.Sky

@Composable
fun SignIn(navHostController: NavHostController){

    var name by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
                    text =  "Sign in",
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
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp)
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
                        text = "Name",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )
                    CustomTextField(
                        modifier = Modifier.height(40.dp),
                        value = name,
                        onValueChange = { name = it },
                        placeholderText = "Enter your name",
                        fontColor = Sky,
                        placeholderColor = Sky
                    )

                    Spacer(modifier = Modifier.padding(top = 15.dp ))

                    Text(
                        text = "Student ID",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )
                    CustomTextField(
                        modifier = Modifier.height(40.dp),
                        value = id,
                        onValueChange = { id = it },
                        placeholderText = "Enter your student ID number",
                        fontColor = Sky,
                        placeholderColor = Sky,
                    )

                    Spacer(modifier = Modifier.padding(top = 15.dp ))

                    Text(
                        text = "Password",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )
                    CustomTextField(
                        modifier = Modifier.height(40.dp),
                        value = password,
                        onValueChange = { password = it },
                        placeholderText = "Enter a password",
                        fontColor = Sky,
                        placeholderColor = Sky
                    )

                    Spacer(modifier = Modifier.padding(top = 15.dp ))

                }

            }

            Column(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier.weight(0.7f)
                ) {
                    Button(
                        modifier = Modifier
                            .padding(top = 15.dp)
                            .height(40.dp)
                            .width(200.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White) ,
                        onClick = {
                            navHostController.navigate(NavigationScreenNames.MainScreens.route){
                                popUpTo(route = NavigationScreenNames.Login.route){
                                    inclusive = true
                                }
                            }
                        }
                    ) {
                        Text(
                            text = "Sign in",
                            color = Sky,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }


                Column(
                    modifier = Modifier.weight(0.3f)
                ) {
                    Text(
                        text = "Already have an account ?",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Button(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .height(40.dp)
                            .width(200.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White) ,
                        onClick = {
                            navHostController.navigate(NavigationScreenNames.Login.route)
                        }
                    ) {
                        Text(
                            text = "Log in",
                            color = Sky,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun SignInPreview(){
    SignIn(navHostController = rememberNavController())
}