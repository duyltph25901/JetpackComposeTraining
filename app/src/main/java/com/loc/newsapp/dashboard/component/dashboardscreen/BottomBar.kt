package com.loc.newsapp.dashboard.component.dashboardscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.loc.newsapp.R
import com.loc.newsapp.dashboard.model.ItemBottomMenuDto
import com.loc.newsapp.ui.theme.NewsAppTheme

@Composable
fun CustomBottomAppBar() {
    val bottomBars = mutableListOf(
        ItemBottomMenuDto(id = 0L, label = "Home", icon = R.drawable.bottom_btn1),
        ItemBottomMenuDto(id = 1L, label = "Profile", icon = R.drawable.bottom_btn2),
        ItemBottomMenuDto(id = 2L, label = "Support", icon = R.drawable.bottom_btn3),
        ItemBottomMenuDto(id = 3L, label = "Settings", icon = R.drawable.bottom_btn4),
    )
    var selectedItem by remember { mutableStateOf("Profile") }

    BottomAppBar(
        cutoutShape = CircleShape,
        backgroundColor = Color.White,
        elevation = 4.dp,
    ) {
        bottomBars.forEachIndexed { index, bottomMenu ->
            if (index == 2) {
                BottomNavigationItem(
                    selected = false,
                    enabled = false,
                    onClick = {},
                    icon = {}
                )
            }

            BottomNavigationItem(
                selected = selectedItem == bottomMenu.label,
                onClick = {
                    selectedItem = bottomMenu.label
                },
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Icon(
                            modifier = Modifier.size(size = 20.dp),
                            painter = painterResource(id = bottomMenu.icon),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.height(8.dp)) // Tạo khoảng cách giữa icon và text
                        Text(
                            text = bottomMenu.label,
                            maxLines = 1,
                            overflow = TextOverflow.Clip,
                            softWrap = false
                        )
                    }
                },
                alwaysShowLabel = true,
                enabled = true
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBottomBar() {
    NewsAppTheme {
        CustomBottomAppBar()
    }
}