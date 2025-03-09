package com.loc.newsapp.demo.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.loc.newsapp.demo.navigation.screen.FirstScreen
import com.loc.newsapp.demo.navigation.screen.SecondScreen
import com.loc.newsapp.ui.theme.NewsAppTheme

class MainNavScreenActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NewsAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "first_screen",
                    builder = {
                        composable("first_screen") {
                            FirstScreen(navController)
                        }

                        composable("second_screen") {
                            SecondScreen(navController)
                        }
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewNavMain() {
    NewsAppTheme {
        FirstScreen()
    }
}