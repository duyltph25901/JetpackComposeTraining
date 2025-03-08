package com.loc.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.loc.newsapp.dashboard.DashboardScreen
import com.loc.newsapp.login.LoginScreenV2
import com.loc.newsapp.ui.theme.NewsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {
//                LoginScreen()
//                LoginScreenV2()
//                ProfileScreen()
                DashboardScreen()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewMainActivity() {
        NewsAppTheme {
            DashboardScreen()
        }
    }
}