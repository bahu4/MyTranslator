package com.example.mytranslator.presenter

import com.example.mytranslator.data.AppState
import com.example.mytranslator.datasource.DataSourceRemote
import com.example.mytranslator.repository.RepositoryImplementation
import com.example.mytranslator.rx.SchedulerProvider
import com.example.mytranslator.view.IMainView
import com.example.mytranslator.view.MainInteractor
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver

class MainPresenter<T : AppState, V : IMainView>(
    private val interactor: MainInteractor = MainInteractor(
        RepositoryImplementation(DataSourceRemote())
    ),
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable(),
    protected val schedulerProvider: SchedulerProvider = SchedulerProvider()
) : IPresenter<T, V> {

    private var currentView: V? = null

    override fun attachView(view: V) {
        if (view != currentView) {
            currentView = view
        }
    }

    override fun detachView(view: V) {
        compositeDisposable.clear()
        if (view == currentView) {
            currentView = null
        }
    }

    override fun getData(word: String, isOnline: Boolean) {
        compositeDisposable.add(
            interactor.getData(word, isOnline)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe(doOnSubscribe())
                .subscribeWith(getObserver())
        )
    }

    private fun doOnSubscribe(): (Disposable) -> Unit =
        { currentView?.renderData(AppState.Loading(null)) }

    private fun getObserver(): DisposableObserver<AppState> {
        return object : DisposableObserver<AppState>() {

            override fun onNext(state: AppState) {
                currentView?.renderData(state)
            }

            override fun onError(e: Throwable) {
                currentView?.renderData(AppState.Error(e))
            }

            override fun onComplete() {
            }
        }
    }
}