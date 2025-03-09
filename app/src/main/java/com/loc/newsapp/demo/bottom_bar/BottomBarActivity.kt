package com.loc.newsapp.demo.bottom_bar

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.loc.newsapp.R
import com.loc.newsapp.demo.bottom_bar.page.HomePage
import com.loc.newsapp.demo.bottom_bar.page.ProfilePage
import com.loc.newsapp.demo.bottom_bar.page.SettingsPage
import com.loc.newsapp.demo.bottom_bar.page.SupportPage
import com.loc.newsapp.ui.theme.NewsAppTheme

class BottomBarActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {
                DemoBottomBarScreen()
            }
        }
    }

}

@SuppressLint("AutoboxingStateCreation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DemoBottomBarScreen() {

    val bottomNavItems = listOf(
        BottomNavItem("Home", R.drawable.bottom_btn1, 0),
        BottomNavItem("Profile", R.drawable.bottom_btn2, 0),
        BottomNavItem("Support", R.drawable.bottom_btn3, 7),
        BottomNavItem("Settings", R.drawable.bottom_btn4, 0),
    )
    var indexSelected by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                bottomNavItems.forEachIndexed { index, bottomNav ->
                    NavigationBarItem(
                        selected = index == indexSelected,
                        onClick = {
                            indexSelected = index
                        },
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (bottomNav.countNotification > 0) {
                                        Badge() {
                                            Text(
                                                text = bottomNav.countNotification.toString()
                                            )
                                        }
                                    }
                                }
                            ) {
                                Icon(
                                    painter = painterResource(
                                        id = bottomNav.icon
                                    ),
                                    contentDescription = null
                                )
                            }
                        },
                        label = {
                            Text(
                                text = bottomNav.label
                            )
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    paddingValues = innerPadding
                ),
            selectedIndex = indexSelected
        )
    }
}

@Composable
private fun ContentScreen(
    modifier: Modifier = Modifier,
    selectedIndex: Int = 0,
) {

    when (selectedIndex) {
        0 -> HomePage()
        1 -> ProfilePage()
        2 -> SupportPage()
        3 -> SettingsPage()
    }

}

@Preview(showBackground = true)
@Composable
private fun PreviewDemoBottomBarScreen() {
    NewsAppTheme {
        DemoBottomBarScreen()
    }
}