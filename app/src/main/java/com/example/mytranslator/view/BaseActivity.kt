package com.example.mytranslator.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mytranslator.data.AppState
import com.example.mytranslator.presenter.IPresenter

abstract class BaseActivity<T: AppState>: AppCompatActivity(), IMainView {
    protected lateinit var presenter: IPresenter<T, IMainView>
    protected abstract fun createPresenter(): IPresenter<T, IMainView>
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