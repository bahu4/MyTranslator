package com.example.mytranslator

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mytranslator.data.AppState

class MainActivity : BaseActivity<AppState>() {
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

    override fun createPresenter(): IPresenter<AppState, IMainView> {
        TODO("Not yet implemented")
    }

    override fun renderData(appState: AppState) {
        TODO("Not yet implemented")
    }
}