package com.example.admin.mykotlin1

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by 243208 on 25/05/18.
 */
operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
    add(disposable)
}