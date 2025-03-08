package com.loc.newsapp.dashboard.model

import com.loc.newsapp.R

data class FeatureDto(
    var id: Long = 0L,
    var featureName: String = "",
    var iconRes: Int = R.drawable.ic_1
) {
}