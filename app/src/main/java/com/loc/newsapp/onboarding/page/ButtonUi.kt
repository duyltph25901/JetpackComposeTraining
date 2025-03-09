package com.loc.newsapp.onboarding.page

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonUi(
    text: String = "",
    bgColor: Color = MaterialTheme.colorScheme.primary,
    txtColor: Color = MaterialTheme.colorScheme.onPrimary,
    txtStyle: TextStyle = MaterialTheme.typography.titleMedium,
    fontSize: Int = 12,
    onClick: () -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = bgColor,
            contentColor = txtColor,
        ),
        shape = RoundedCornerShape(
            size = 12.dp
        ),
        onClick = {
            onClick.invoke()
        }
    ) {
        Text(
            text = text,
            fontSize = fontSize.sp,
            style = txtStyle
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NextButton() {
    ButtonUi(
        text = "Next"
    ) {
    }
}

@Preview(showBackground = true)
@Composable
fun BackButton() {
    ButtonUi(
        text = "Back",
        bgColor = Color.Transparent,
        txtColor = Color.Gray,
        txtStyle = MaterialTheme.typography.bodySmall,
        fontSize = 13,
    ) {

    }
}

@Composable
fun StaticBackButton() {
    ButtonUi(
        bgColor = Color.Transparent,
        txtColor = Color.Transparent,
    ) {

    }
}