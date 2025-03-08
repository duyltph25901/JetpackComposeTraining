package com.loc.newsapp.dashboard.component.dashboardscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loc.newsapp.R
import com.loc.newsapp.dashboard.model.FeatureDto
import com.loc.newsapp.ui.theme.NewsAppTheme

@Composable
fun ItemDashBoard(
    featureItem: FeatureDto
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(size = 12.dp)
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .padding(top = 12.dp)
                .size(size = 60.dp)
                .background(
                    color = Color(
                        android.graphics.Color.parseColor("#7868e5")
                    ), shape = RoundedCornerShape(size = 12.dp)
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(size = 32.dp),
                painter = painterResource(id = featureItem.iconRes),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 12.dp
                )
                .background(
                    color = Color(
                        color = android.graphics.Color.parseColor("#Dad8ff")
                    ),
                    shape = RoundedCornerShape(
                        bottomEnd = 12.dp,
                        bottomStart = 12.dp
                    )
                )
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 12.dp,
                        bottom = 12.dp,
                    ),
                textAlign = TextAlign.Center,
                maxLines = 1,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(
                    color = android.graphics.Color.parseColor("#7868e5")
                ),
                text = featureItem.featureName
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewItemDashBoard() {
    NewsAppTheme {
        ItemDashBoard(
            featureItem = FeatureDto(id = 0L, featureName = "Message", iconRes = R.drawable.ic_1),
        )
    }
}