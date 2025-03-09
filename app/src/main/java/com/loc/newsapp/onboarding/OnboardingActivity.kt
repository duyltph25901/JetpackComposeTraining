package com.loc.newsapp.onboarding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.loc.newsapp.onboarding.model.OnbModel.Companion.listOnbModels
import com.loc.newsapp.onboarding.page.BackButton
import com.loc.newsapp.onboarding.page.ButtonUi
import com.loc.newsapp.onboarding.page.Indicator
import com.loc.newsapp.onboarding.page.IndicatorUiPreview1
import com.loc.newsapp.onboarding.page.IndicatorUiPreview2
import com.loc.newsapp.onboarding.page.IndicatorUiPreview3
import com.loc.newsapp.onboarding.page.NextButton
import com.loc.newsapp.onboarding.page.OnbGraphicUi
import com.loc.newsapp.onboarding.page.OnbPage1
import com.loc.newsapp.onboarding.page.OnbPage2
import com.loc.newsapp.onboarding.page.OnbPage3
import com.loc.newsapp.onboarding.page.StaticBackButton
import com.loc.newsapp.ui.theme.NewsAppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class OnboardingActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NewsAppTheme {
                OnboardingScreen()
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
private fun OnboardingScreen() {
    val pages = listOnbModels
    val pagerState = rememberPagerState(
        initialPage = 0
    ) {
        pages.size
    }
    val buttonState = remember {
        derivedStateOf {
            when (pagerState.currentPage) {
                0 -> listOf("", "Next")
                1 -> listOf("Back", "Next")
                else -> listOf("Back", "Start")
            }
        }
    }
    val indexValueBtnBack = 0
    val indexValueBtnNext = 1
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        Column(
            modifier = Modifier.padding(
                paddingValues = innerPadding
            ).background(
                color = Color.White
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            HorizontalPager(
                state = pagerState
            ) { index ->
                OnbGraphicUi(pages[index])
            }
            Spacer(
                modifier = Modifier.weight(
                    weight = 1f,
                )
            )
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(
                        horizontal = 12.dp
                    ).padding(
                        bottom = 12.dp
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.weight(
                        weight = 1f
                    ),
                    horizontalAlignment = Alignment.Start,
                ) {
                    if (buttonState.value[indexValueBtnBack].isNotEmpty()) {
                        ButtonUi(
                            text = buttonState.value[indexValueBtnBack],
                            bgColor = Color.Transparent,
                            txtColor = Color.Gray,
                            txtStyle = MaterialTheme.typography.bodySmall,
                            fontSize = 13,
                        ) {
                            scope.launch(Dispatchers.IO + Job()) {
                                if (pagerState.currentPage > 0) {
                                    pagerState.animateScrollToPage(
                                        page = pagerState.currentPage - 1
                                    )
                                }
                                cancel("Completed Event Back")
                            }
                        }
                    }
                }

                Column(
                    modifier = Modifier.weight(
                        weight = 1f
                    ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Indicator(
                        pageSize = pages.size,
                        currentPage = pagerState.currentPage,
                    )
                }

                Column(
                    modifier = Modifier.weight(
                        weight = 1f
                    ),
                    horizontalAlignment = Alignment.End,
                ) {
                    ButtonUi(
                        text = buttonState.value[indexValueBtnNext]
                    ) {
                        val isLastItem = pagerState.currentPage == pages.size - 1
                        if (!isLastItem) {
                            scope.launch(Dispatchers.IO + Job()) {
                                pagerState.animateScrollToPage(
                                    page = pagerState.currentPage + 1
                                )
                                cancel("Completed Next Event")
                            }
                        } else {

                        }
                    }
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewOnboardingScreen() {
    NewsAppTheme {
        OnboardingScreen()
    }
}