package com.example.mytranslator.view

import androidx.appcompat.app.AppCompatActivity
import com.example.mytranslator.data.AppState
import com.example.mytranslator.viewmodel.BaseViewModel
import com.example.mytranslator.viewmodel.IInteractor

abstract class BaseActivity<T : AppState, I : IInteractor<T>> : AppCompatActivity() {
    abstract val model: BaseViewModel<T>

    abstract fun renderData(dataModel: T)
}