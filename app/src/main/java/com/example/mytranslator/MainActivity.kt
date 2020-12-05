package com.example.mytranslator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRV()
    }

    private fun initRV() {
        recyclerView = findViewById(R.id.main_rv)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = MainRVAdapter()
        }
    }
}