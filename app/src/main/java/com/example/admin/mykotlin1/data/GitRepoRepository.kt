package com.example.admin.mykotlin1.data

import com.example.admin.mykotlin1.NetManager
import com.example.admin.mykotlin1.Repository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by ADMIN on 5/26/2018.
 */
class GitRepoRepository @Inject constructor(var netManager: NetManager) {

    private val localDataSource = GitRepoLocalDataSource()
    private val remoteDataSource = GitRepoRemoteDataSource()

    fun getRepositories(): Observable<ArrayList<Repository>> {

        netManager.isConnectedToInternet?.let {
            if (it) {
                return remoteDataSource.getRepositories().flatMap {
                    return@flatMap localDataSource.saveRepositories(it)
                            .toSingleDefault(it)
                            .toObservable()
                }
            }
        }

        return localDataSource.getRepositories()
    }
}