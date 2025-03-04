package com.loc.newsapp.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.loc.newsapp.R
import com.loc.newsapp.ui.theme.NewsAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreenV2() {
    Scaffold(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues = innerPadding)
                .paint(
                    painter = painterResource(id = R.drawable.background_page),
                    contentScale = ContentScale.Crop
                ), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ConstraintLayout(
                modifier = Modifier.fillMaxSize()
            ) {
                val (topText, column) = createRefs()

                Text(
                    modifier = Modifier
                        .padding(
                            top = 16.dp,
                            start = 16.dp,
                        )
                        .constrainAs(topText) {
                            linkTo(top = parent.top, bottom = column.top, bias = .6f)
                            linkTo(start = parent.start, end = parent.end, bias = 0f)
                        },
                    text = "Login",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )

                Column(modifier = Modifier
                    .fillMaxWidth()
                    .height(height = 600.dp)
                    .constrainAs(column) {
                        bottom.linkTo(parent.bottom)
                    }
                    .background(
                        color = Color(
                            color = android.graphics.Color.parseColor("#e0e0e0"),
                        ), shape = RoundedCornerShape(
                            topStart = 40.dp, topEnd = 40.dp
                        )
                    )
                    .padding(all = 32.dp)) {

                    Text(
                        modifier = Modifier.padding(top = 16.dp),
                        text = "Email",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    var emailValue by rememberSaveable { mutableStateOf("") }
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                            .background(
                                color = Color.White,
                                shape = CircleShape
                            ),
                        label = {
                            Text(text = "example@gmail.com")
                        },
                        value = emailValue,
                        shape = RoundedCornerShape(size = 10.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White,
                            textColor = Color(color = android.graphics.Color.parseColor("#5e5e5e")),
                            unfocusedLabelColor = Color(color = android.graphics.Color.parseColor("#5e5e5e")),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        onValueChange = { newValue ->
                            emailValue = newValue
                        }
                    )

                    Text(
                        modifier = Modifier.padding(top = 16.dp),
                        text = "Password",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    var passValue by rememberSaveable { mutableStateOf("") }
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                            .background(
                                color = Color.White,
                                shape = CircleShape
                            ),
                        label = {
                            Text(text = "Type your password")
                        },
                        value = passValue,
                        shape = RoundedCornerShape(size = 10.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White,
                            textColor = Color(color = android.graphics.Color.parseColor("#5e5e5e")),
                            unfocusedLabelColor = Color(color = android.graphics.Color.parseColor("#5e5e5e")),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password
                        ),
                        onValueChange = { newValue ->
                            passValue = newValue
                        }
                    )

                    Text(
                        modifier = Modifier
                            .padding(top = 24.dp)
                            .fillMaxWidth(),
                        text = "Forget your password? Recovery it",
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        color = Color(color = android.graphics.Color.parseColor("#5E5E5E"))
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(modifier = Modifier
                            .height(height = 1.dp)
                            .weight(weight = 1f)
                            .background(
                                color = Color(
                                    color = android.graphics.Color.parseColor("#4d4d4d")
                                )
                            ))

                        Text(
                            modifier = Modifier.padding(
                                horizontal = 8.dp,
                            ),
                            text = "Or login with",
                            fontSize = 14.sp,
                            color = Color(
                                color = android.graphics.Color.parseColor("#4d4d4d")
                            )
                        )

                        Box(modifier = Modifier
                            .height(height = 1.dp)
                            .weight(weight = 1f)
                            .background(
                                color = Color(
                                    color = android.graphics.Color.parseColor("#4d4d4d")
                                )
                            ))
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                    ) {
                        OutlinedButton(
                            modifier = Modifier.weight(weight = 1f),
                            shape = RoundedCornerShape(
                                size = 12.dp
                            ),
                            onClick = { /*TODO*/ }
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    modifier = Modifier.size(size = 24.dp),
                                    painter = painterResource(id = R.drawable.gg_blue),
                                    contentDescription = null
                                )

                                Text(
                                    modifier = Modifier
                                        .weight(weight = 1f)
                                        .padding(
                                            start = 12.dp
                                        ),
                                    text = "Google",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center,
                                    maxLines = 1,
                                )
                            }
                        }

                        Spacer(modifier = Modifier.width(width = 12.dp))

                        OutlinedButton(
                            modifier = Modifier.weight(weight = 1f),
                            shape = RoundedCornerShape(
                                size = 12.dp
                            ),
                            onClick = { /*TODO*/ }
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    modifier = Modifier.size(size = 24.dp),
                                    painter = painterResource(id = R.drawable.fb_blue),
                                    contentDescription = null
                                )

                                Text(
                                    modifier = Modifier
                                        .weight(weight = 1f)
                                        .padding(
                                            start = 12.dp
                                        ),
                                    text = "Facebook",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center,
                                    maxLines = 1,
                                )
                            }
                        }
                    }

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp),
                        shape = RoundedCornerShape(size = 12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(
                                color = android.graphics.Color.parseColor("#fa951a")
                            )
                        ),
                        onClick = { /*TODO*/ },
                    ) {
                        Text(
                            modifier = Modifier.padding(vertical = 8.dp),
                            text = "Login",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreenV2() {
    NewsAppTheme {
        LoginScreenV2()
    }
}
