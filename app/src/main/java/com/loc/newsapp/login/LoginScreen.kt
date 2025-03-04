package com.loc.newsapp.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loc.newsapp.R
import com.loc.newsapp.ui.theme.NewsAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(
                paddingValues = innerPadding
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.top_background),
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
            
            Image(
                modifier = Modifier.height(
                    height = 150.dp
                ),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
            )

            Text(
                text = "Welcome to UiLover",
                fontSize = 30.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                color = Color(android.graphics.Color.parseColor("#7d32a8"))
            )

            var user by remember { mutableStateOf("Username") }
            var pass by remember { mutableStateOf("Password") }
            var passVisible by remember { mutableStateOf(false) }

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 64.dp,
                        vertical = 8.dp
                    )
                    .border(
                        width = 1.dp,
                        color = Color(android.graphics.Color.parseColor("#7d32a8")),
                        shape = RoundedCornerShape(
                            percent = 50
                        )
                    ),
                shape = RoundedCornerShape(
                    percent = 50
                ),
                textStyle = TextStyle(
                    textAlign = TextAlign.Center,
                    color = Color(android.graphics.Color.parseColor("#7d32a8")),
                    fontSize = 14.sp
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,

                ),
                value = user,
                onValueChange = { newValue ->
                    user = newValue
                }
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 64.dp,
                        vertical = 8.dp
                    )
                    .border(
                        width = 1.dp,
                        color = Color(android.graphics.Color.parseColor("#7d32a8")),
                        shape = RoundedCornerShape(
                            percent = 50
                        )
                    ),
                shape = RoundedCornerShape(
                    percent = 50
                ),
                textStyle = TextStyle(
                    textAlign = TextAlign.Center,
                    color = Color(android.graphics.Color.parseColor("#7d32a8")),
                    fontSize = 14.sp
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,

                    ),
                value = pass,
                onValueChange = { newValue ->
                    pass = newValue
                },
                visualTransformation = if (passVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                )
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 64.dp,
                        vertical = 8.dp
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(android.graphics.Color.parseColor("#7d32a8"))
                ),
                onClick = { /*TODO*/ }
            ) {
                Text(
                    modifier = Modifier.padding(
                        vertical = 8.dp
                    ),
                    text = "Login",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                modifier = Modifier.padding(
                    vertical = 8.dp
                ),
                text = "Don't remember password? Click here",
                fontSize = 14.sp,
                color = Color(android.graphics.Color.parseColor("#7d32a8"))
            )

            Row(
                modifier = Modifier.padding(
                    all = 16.dp
                ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    modifier = Modifier.height(40.dp),
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.width(12.dp))

                Image(
                    modifier = Modifier.height(40.dp),
                    painter = painterResource(id = R.drawable.twitter),
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.width(12.dp))

                Image(
                    modifier = Modifier.height(40.dp),
                    painter = painterResource(id = R.drawable.facebook),
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )
            }

            Image(
                painter = painterResource(id = R.drawable.bottom_background),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    NewsAppTheme {
        LoginScreen()
    }
}