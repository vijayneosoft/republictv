package com.neosoft.republictv.domain.usecases

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers


abstract class BaseUC<T, Param> {

    val disposables: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    abstract fun build(param: Param): Observable<T>

    fun execute(observer: DisposableObserver<T>, param: Param) {
        val observable: Observable<T> = build(param)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        disposables.add(observable.subscribeWith(observer))

    }

}