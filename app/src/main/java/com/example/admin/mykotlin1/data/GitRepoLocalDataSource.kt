package com.example.admin.mykotlin1.data

import com.example.admin.mykotlin1.Repository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class GitRepoLocalDataSource {

    fun getRepositories(): Observable<ArrayList<Repository>> {
        var arrayList = ArrayList<Repository>()
        arrayList.add(Repository("First From Local", "Owner 1L", 100, false))
        arrayList.add(Repository("Second From Local", "Owner 2L", 30, true))
        arrayList.add(Repository("Third From Local", "Owner 3L", 430, false))

        return Observable.just(arrayList).delay(2, TimeUnit.SECONDS)
    }

    fun saveRepositories(arrayList: ArrayList<Repository>): Completable {
        return Single.just(1).delay(1, TimeUnit.SECONDS).toCompletable()
    }
}