package com.example.moviez

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main_view_pager.*

class MainActivityViewPager : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_view_pager)
        vp_poster.adapter = PostersAdapter()
        vp_poster.offscreenPageLimit = 3
        vp_poster.setPageTransformer(PosterSliderTransformer())

        vp_movies.adapter = MoviesAdapter()
        vp_movies.offscreenPageLimit = 3
        vp_movies.setPageTransformer(SliderTransformer(2))
        var lastPos = 0
        vp_movies.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                vp_poster.beginFakeDrag()
                vp_poster.fakeDragBy((positionOffsetPixels - lastPos).toFloat())

                lastPos = if (positionOffsetPixels != 0) {
                    positionOffsetPixels
                } else {
                    vp_poster.endFakeDrag()
//                    vp_poster.currentItem = position
                    0
                }
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

        })
    }
}