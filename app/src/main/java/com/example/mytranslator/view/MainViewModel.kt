package com.example.mytranslator.view

import androidx.lifecycle.LiveData
import com.example.mytranslator.data.AppState
import com.example.mytranslator.viewmodel.BaseViewModel
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val interactor: MainInteractor
) : BaseViewModel<AppState>() {
    private var appState: AppState? = null
    override fun getData(word: String, isOnline: Boolean): LiveData<AppState> {
        compositeDisposable.add(
            interactor.getData(word, isOnline)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe(doOnSubscribe())
                .subscribeWith(getObserver())
        )
        return super.getData(word, isOnline)
    }

    fun subscribe(): LiveData<AppState> {
        return liveDataForViewToObserve
    }

    private fun doOnSubscribe(): (Disposable) -> Unit =
        { liveDataForViewToObserve.value = AppState.Loading(null) }

    private fun getObserver(): DisposableObserver<AppState> {
        return object : DisposableObserver<AppState>() {
            override fun onNext(state: AppState) {
                appState = state
                liveDataForViewToObserve.value = state
            }

            override fun onError(e: Throwable) {
                liveDataForViewToObserve.value = AppState.Error(e)
            }

            override fun onComplete() {
            }
        }
    }
}


