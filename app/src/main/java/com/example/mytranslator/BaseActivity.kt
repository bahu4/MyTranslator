package com.example.mytranslator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mytranslator.data.AppState

abstract class BaseActivity<T: AppState>: AppCompatActivity(), IMainView {
    protected lateinit var IPresenter: IPresenter<T, IMainView>
    protected abstract fun createPresenter(): IPresenter<T, IMainView>
    abstract override fun renderData(appState: AppState)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        IPresenter = createPresenter()
    }

    override fun onStart() {
        super.onStart()
        IPresenter.attachView(this)
    }

    override fun onStop() {
        super.onStop()
        IPresenter.detachView(this)
    }
}