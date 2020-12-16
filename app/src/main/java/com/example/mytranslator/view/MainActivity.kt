package com.example.mytranslator.view

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mytranslator.R
import com.example.mytranslator.data.AppState
import com.example.mytranslator.data.SearchResult
import org.koin.android.viewmodel.ext.android.viewModel
import androidx.lifecycle.Observer


class   MainActivity : BaseActivity<AppState, MainInteractor>() {

    override lateinit var model: MainViewModel
    private lateinit var recyclerView: RecyclerView
    private val adapter: MainRVAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel: MainViewModel by viewModel()
        model = viewModel
        model.subscribe().observe(this@MainActivity, Observer<AppState> { renderData(it) })
        val start = findViewById<Button>(R.id.translate_button)
        val text = findViewById<EditText>(R.id.text_edit)
        start.setOnClickListener {
            model.getData(text.text.toString())
        }
    }

    private fun initRV(searchResult: List<SearchResult>) {
        recyclerView = findViewById(R.id.main_rv)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = MainRVAdapter(searchResult)
        }
    }

    override fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                val searchResult = appState.data
                if (searchResult.isNullOrEmpty()) {
                    showErrorScreen(getString(R.string.empty_server_response_on_success))
                } else {
                    initRV(searchResult)
                }
            }
            is AppState.Error -> {
                showErrorScreen(appState.error.message)
            }
        }
    }

    private fun showErrorScreen(error: String?) {
        showViewError()
        val errorTextView = findViewById<TextView>(R.id.error_text)
        errorTextView.text = error ?: getString(R.string.undefined_error)
    }

    private fun showViewError() {
        val errorLayout = findViewById<ConstraintLayout>(R.id.error_layout)
        val successLayout = findViewById<FrameLayout>(R.id.success_layout)
        errorLayout.visibility = VISIBLE
        successLayout.visibility = GONE
    }

}