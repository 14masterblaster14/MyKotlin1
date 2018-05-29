package com.example.admin.mykotlin1.data

import com.example.admin.mykotlin1.Repository
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class GitRepoRemoteDataSource {
    fun getRepositories(): Observable<ArrayList<Repository>> {
        var arrayList = ArrayList<Repository>()
        arrayList.add(Repository("First from remote", "Owner 1R", 100, false))
        arrayList.add(Repository("Second from remote", "Owner 2R", 30, true))
        arrayList.add(Repository("Third from remote", "Owner 3R", 430, false))

        return Observable.just(arrayList).delay(2, TimeUnit.SECONDS)
    }
}