package com.loc.newsapp.demo.bottom_bar

import com.loc.newsapp.R

data class BottomNavItem(
    var label: String = "",
    var icon: Int = R.drawable.bottom_btn1,
    var countNotification: Int = 0
) {
}