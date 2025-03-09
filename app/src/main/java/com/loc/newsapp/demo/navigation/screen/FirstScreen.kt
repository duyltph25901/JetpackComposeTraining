package com.loc.newsapp.demo.navigation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import com.loc.newsapp.ui.theme.NewsAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(navController: NavController? = null) {

    var resultFromScreenScreen = remember { mutableStateOf("None Data From Second Screen") }
    val savedStateHandle = navController?.currentBackStackEntry?.savedStateHandle

    // Listen data returned from secondScreen
    LaunchedEffect(
        key1 = savedStateHandle
    ) {
        savedStateHandle?.getLiveData<String>(
            key = "result"
        )?.observeForever { valueReturned ->
            resultFromScreenScreen.value = valueReturned
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    paddingValues = innerPadding
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = resultFromScreenScreen.value,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Button(modifier = Modifier.padding(
                top = 12.dp
            ), onClick = {
                navController?.navigate("second_screen")
            }) {
                Text(
                    text = "Go To Second Screen", fontSize = 12.sp, color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewFirstScreen() {
    NewsAppTheme {
        FirstScreen()
    }
}