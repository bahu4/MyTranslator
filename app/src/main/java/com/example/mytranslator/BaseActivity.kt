package com.example.mytranslator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mytranslator.data.AppState

abstract class BaseActivity<T: AppState>: AppCompatActivity(), MainView {
    protected lateinit var presenter: Presenter<T, MainView>
    protected abstract fun createPresenter(): Presenter<T, MainView>
    abstract override fun renderData(appState: AppState)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView(this)
    }
}