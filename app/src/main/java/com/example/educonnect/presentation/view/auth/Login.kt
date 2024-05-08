package com.example.educonnect.presentation.view.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.example.educonnect.data.Constants.STUDENT
import com.example.educonnect.data.Constants.TEACHER
import com.example.educonnect.navigation.NavigationScreenNames
import com.example.educonnect.presentation.view.util.CustomTextField
import com.example.educonnect.ui.theme.Sky


@Composable
fun Login(navHostController: NavHostController){
    var type by remember { mutableStateOf(STUDENT) }
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
                    text =  "Log in as $type",
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
                        text = "$type ID",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )
                    CustomTextField(
                        modifier = Modifier.height(40.dp),
                        value = id,
                        onValueChange = { id = it },
                        placeholderText = "Enter your $type ID",
                        fontColor = Sky,
                        placeholderColor = Sky
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
                        placeholderText = "Enter password",
                        fontColor = Sky,
                        placeholderColor = Sky,
                    )

                    Text(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .clickable(onClick = {
                                navHostController.navigate(NavigationScreenNames.ForgotPassword.route)
                            }),
                        text = "Forgot Password ?",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )

                }

            }

            Column(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(top = 15.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(
                        modifier = Modifier.weight(0.7f),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Button(
                            modifier = Modifier
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
                                text = "Log in",
                                color = Sky,
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }

                        Spacer(modifier = Modifier.padding(top = 15.dp))

                        Button(
                            modifier = Modifier
                                .height(40.dp)
                                .width(200.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White) ,
                            onClick = {
                                when(type){
                                    TEACHER -> type = STUDENT
                                    STUDENT -> type = TEACHER
                                }

                            }
                        ) {
                            Text(
                                text = "Switch to " + if(type == TEACHER){STUDENT}else{TEACHER},
                                color = Sky,
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    }


                    Column(
                        modifier = Modifier.weight(0.3f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Don't have an account ?",
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
                                navHostController.navigate(NavigationScreenNames.SignIn.route)
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
                }
            }
        }
    }
}

@Preview
@Composable
private fun LoginPreview(){
    Login(navHostController = rememberNavController())
}