package com.loc.newsapp.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.loc.newsapp.R
import com.loc.newsapp.dashboard.component.dashboardscreen.CustomBottomAppBar
import com.loc.newsapp.dashboard.component.dashboardscreen.ItemDashBoard
import com.loc.newsapp.dashboard.model.FeatureDto
import com.loc.newsapp.dashboard.model.ItemBottomMenuDto
import com.loc.newsapp.ui.theme.NewsAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentDashboard() {

    val features = mutableListOf(
        FeatureDto(id = 0L, featureName = "Message", iconRes = R.drawable.ic_1),
        FeatureDto(id = 1L, featureName = "Routing", iconRes = R.drawable.ic_2),
        FeatureDto(id = 2L, featureName = "Report", iconRes = R.drawable.ic_3),
        FeatureDto(id = 3L, featureName = "Inbox", iconRes = R.drawable.ic_4),
    )
    val gridState = rememberLazyGridState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = innerPadding)
                .background(color = Color(android.graphics.Color.parseColor("#ece8f9")))
        ) {

            // Information Layout
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .padding(top = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Image(
                    modifier = Modifier
                        .size(size = 100.dp)
                        .clip(
                            shape = CircleShape,
                        )
                        .border(
                            width = 2.dp,
                            color = Color.White,
                            shape = CircleShape
                        ),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = null
                )

                Column(
                    modifier = Modifier
                        .weight(weight = 1f)
                        .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Abby Sandet",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(
                            color = android.graphics.Color.parseColor("#3a3642")
                        )
                    )

                    Text(
                        text = "abbysandet@gmail.com",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(
                            color = android.graphics.Color.parseColor("#959595")
                        )
                    )
                }
            }

            // Layout Search

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .padding(top = 16.dp),
                shape = RoundedCornerShape(size = 12.dp),
                textStyle = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                label = {
                    Text(
                        modifier = Modifier.padding(bottom = 8.dp),
                        text = "Searching for...",
                        fontSize = 16.sp,
                        color = Color.Black,
                    )
                },
                trailingIcon = {
                    Box(
                        modifier = Modifier.padding(
                            top = 12.dp,
                            bottom = 12.dp,
                            end = 12.dp
                        )
                    ) {
                        IconButton(
                            modifier = Modifier
                                .size(size = 24.dp)
                                .clip(shape = RoundedCornerShape(size = 12.dp))
                                .background(color = Color.Red),
                            onClick = {},
                        ) {
                            Image(
                                painter = painterResource(R.drawable.search),
                                contentDescription = null,
                            )
                        }
                    }
                },
                value = "",
                onValueChange = { newValue ->

                },
            )

            // Layout Dashboard Feature

            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                columns = GridCells.Fixed(count = 2),
                state = gridState,
                contentPadding = PaddingValues(all = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(space = 12.dp),
                verticalArrangement = Arrangement.spacedBy(space = 12.dp)
            ) {
                items(features) { feature ->
                    ItemDashBoard(feature)
                }
            }

            // Banner
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .padding(top = 16.dp)
                    .height(height = 120.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(android.graphics.Color.parseColor("#BFA3EF")),
                                Color(android.graphics.Color.parseColor("#7E57c2")),
                            )
                        ), shape = RoundedCornerShape(size = 24.dp)
                    )
            ) {
                val (img, txt1, txt2) = createRefs()
                Image(
                    modifier = Modifier.constrainAs(img) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    },
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.arc),
                    contentDescription = null
                )

                Text(
                    modifier = Modifier.constrainAs(txt1) {
                        start.linkTo(img.end)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(txt2.top)
                    },
                    text = "To Get Unlimited",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Text(
                    modifier = Modifier.constrainAs(txt2) {
                        start.linkTo(img.end)
                        end.linkTo(parent.end)
                        top.linkTo(txt1.bottom)
                        bottom.linkTo(parent.bottom)
                    },
                    text = "Upgrade Your Account",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DashboardScreen() {
    val scaffoldState = rememberScaffoldState()

    androidx.compose.material.Scaffold(
        bottomBar = { CustomBottomAppBar() },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                backgroundColor = Color(
                    color = android.graphics.Color.parseColor("#Fe5b52")
                )
            ) {
                Icon(
                    modifier = Modifier.size(size = 30.dp),
                    painter = painterResource(id = R.drawable.shopping_cart),
                    contentDescription = null,
                )
            }
        },
        scaffoldState = scaffoldState,
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ComponentDashboard()
        }
    }
}