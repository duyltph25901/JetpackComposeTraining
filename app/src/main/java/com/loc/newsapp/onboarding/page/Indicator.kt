package com.loc.newsapp.onboarding.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.loc.newsapp.onboarding.model.OnbModel.Companion.listOnbModels

@Composable
fun Indicator(
    pageSize: Int = 0,
    currentPage: Int = 0,
    selectedColor: Color = MaterialTheme.colorScheme.secondary,
    unSelectedColor: Color = MaterialTheme.colorScheme.secondaryContainer,
) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        repeat(pageSize) { index ->
            Box(
                modifier = Modifier
                    .padding(
                        horizontal = 2.5.dp
                    )
                    .height(
                        height = 16.dp
                    )
                    .width(
                        width = if (index == currentPage) 24.dp else 16.dp
                    )
                    .clip(
                        shape = RoundedCornerShape(10.dp)
                    )
                    .background(
                        color = if (index == currentPage) selectedColor else unSelectedColor
                    )
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun IndicatorUiPreview1() {
    Indicator(
        pageSize = listOnbModels.size,
        currentPage = 0
    )
}

@Preview(showBackground = true)
@Composable
fun IndicatorUiPreview2() {
    Indicator(
        pageSize = listOnbModels.size,
        currentPage = 1
    )
}

@Preview(showBackground = true)
@Composable
fun IndicatorUiPreview3() {
    Indicator(
        pageSize = listOnbModels.size,
        currentPage = 2
    )
}
