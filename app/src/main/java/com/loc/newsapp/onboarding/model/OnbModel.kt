package com.loc.newsapp.onboarding.model

import com.loc.newsapp.R

data class OnbModel(
    var image: Int = R.drawable.img_intro_1,
    var title: String = "",
    var des: String = ""
) {

    companion object {
        val listOnbModels = mutableListOf(
            OnbModel(image = R.drawable.img_intro_1, title = "Lorem Ipsum Dolor Sit Amet", des = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium"),
            OnbModel(image = R.drawable.img_intro_2, title = "Lorem Ipsum Dolor Sit Amet", des = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium"),
            OnbModel(image = R.drawable.img_intro_3, title = "Lorem Ipsum Dolor Sit Amet", des = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium"),
        )
    }

}