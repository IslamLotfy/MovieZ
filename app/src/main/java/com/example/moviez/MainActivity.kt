package com.example.moviez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_movies.layoutManager!!.scrollToPosition(3)
        rv_movies.adapter = MoviesAdapter(rv_movies)
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(rv_movies)
    }
}