package com.example.moviez

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearSnapHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_movies.layoutManager!!.scrollToPosition(3)
        rv_movies.adapter = MoviesAdapter()
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(rv_movies)
//        val  anim_out = AnimationUtils.loadAnimation(c, android.R.anim.fade_out);

    }
}