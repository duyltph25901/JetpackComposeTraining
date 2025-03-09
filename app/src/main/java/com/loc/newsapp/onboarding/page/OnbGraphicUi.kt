package com.loc.newsapp.onboarding.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loc.newsapp.onboarding.model.OnbModel
import com.loc.newsapp.onboarding.model.OnbModel.Companion.listOnbModels

@Composable
fun OnbGraphicUi(onbModel: OnbModel = OnbModel()) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier.size(50.dp)
        )
        Image(
            painter = painterResource(id = onbModel.image),
            contentDescription = onbModel.title,
            contentScale = ContentScale.Crop
        )
        Spacer(
            modifier = Modifier.size(50.dp)
        )
        Text(
            modifier = Modifier.fillMaxWidth()
                .padding(
                    horizontal = 12.dp
                ),
            text = onbModel.title,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(
            modifier = Modifier.size(10.dp)
        )
        Text(
            modifier = Modifier.fillMaxWidth()
                .padding(
                    horizontal = 12.dp
                ),
            text = onbModel.des,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface
        )
    }

}

@Preview(showBackground = true)
@Composable
fun OnbPage1() {
    OnbGraphicUi(listOnbModels[0])
}

@Preview(showBackground = true)
@Composable
fun OnbPage2() {
    OnbGraphicUi(listOnbModels[1])
}

@Preview(showBackground = true)
@Composable
fun OnbPage3() {
    OnbGraphicUi(listOnbModels[2])
}