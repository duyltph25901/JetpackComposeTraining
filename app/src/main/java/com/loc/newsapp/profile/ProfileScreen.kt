package com.loc.newsapp.profile

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.loc.newsapp.R
import com.loc.newsapp.ui.theme.NewsAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    paddingValues = innerPadding
                )
                .background(
                    color = Color(
                        color = android.graphics.Color.parseColor("#ececec")
                    )
                ), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ConstraintLayout {
                val (topImg, profile) = createRefs()

                Image(modifier = Modifier
                    .constrainAs(topImg) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .fillMaxWidth()
                    .fillMaxHeight(.2f),
                    painter = painterResource(id = R.drawable.bg_profile),
                    contentDescription = null,
                    contentScale = ContentScale.Crop)

                Image(modifier = Modifier
                    .constrainAs(profile) {
                        top.linkTo(topImg.bottom)
                        bottom.linkTo(topImg.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .size(size = 100.dp)
                    .clip(
                        shape = CircleShape,
                    )
                    .border(
                        width = 4.dp, color = Color.White, shape = CircleShape
                    ),
                    painter = painterResource(id = R.drawable.avt_default),
                    contentDescription = null,
                    contentScale = ContentScale.Crop)
            }

            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = "Lion Fischer",
                fontWeight = FontWeight.Bold,
                color = Color(color = android.graphics.Color.parseColor("#747679")),
                fontSize = 24.sp,
            )

            Text(
                text = "lionfischer@gmail.com",
                color = Color(color = android.graphics.Color.parseColor("#747679")),
            )

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 32.dp,
                        vertical = 10.dp
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(size = 12.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.size(size = 30.dp),
                        painter = painterResource(id = R.drawable.ic_setting),
                        contentDescription = null,
                        contentScale = ContentScale.FillHeight
                    )

                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 12.dp),
                        text = "My Reviews",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 32.dp,
                        vertical = 10.dp
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(size = 12.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.size(size = 30.dp),
                        painter = painterResource(id = R.drawable.ic_note),
                        contentDescription = null,
                        contentScale = ContentScale.FillHeight
                    )

                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 12.dp),
                        text = "Account Settings",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 32.dp,
                        vertical = 10.dp
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(size = 12.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.size(size = 30.dp),
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = null,
                        contentScale = ContentScale.FillHeight
                    )

                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 12.dp),
                        text = "Personal Information",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 32.dp,
                        vertical = 10.dp
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(size = 12.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.size(size = 30.dp),
                        painter = painterResource(id = R.drawable.ic_noti),
                        contentDescription = null,
                        contentScale = ContentScale.FillHeight
                    )

                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 12.dp),
                        text = "Notification",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Button(
                onClick = {
                    Log.d("duylt", "Hello")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 32.dp,
                        vertical = 10.dp
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(size = 12.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,

                ) {
                    Image(
                        modifier = Modifier.size(size = 30.dp),
                        painter = painterResource(id = R.drawable.ic_finger),
                        contentDescription = null,
                        contentScale = ContentScale.FillHeight
                    )

                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 12.dp),
                        text = "Fingerprint Setting",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 32.dp,
                        vertical = 10.dp
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(
                        color = android.graphics.Color.parseColor("#373ebf")
                    )
                ),
                onClick = { /*TODO*/ }
            ) {
                Text(
                    modifier = Modifier.padding(
                        vertical = 8.dp
                    ),
                    text = "Back To Main Page",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 18.sp,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    NewsAppTheme {
        ProfileScreen()
    }
}