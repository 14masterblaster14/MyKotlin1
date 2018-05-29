package com.example.a243208.mykotlintry

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.example.admin.mykotlin1.Repository
import com.example.admin.mykotlin1.data.GitRepoRepository
import com.example.admin.mykotlin1.plusAssign
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by 243208 on 25/05/18.
 */


class MainViewModel @Inject constructor(var gitRepoRepository: GitRepoRepository) : ViewModel() {

    val text = ObservableField("old data")

    val isLoading = ObservableField(false)

    var repositories = MutableLiveData<ArrayList<Repository>>()

    private val compositeDisposable = CompositeDisposable()

    fun loadRepositories() {
        isLoading.set(true)
        compositeDisposable += gitRepoRepository
                .getRepositories()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<ArrayList<Repository>>() {

                    override fun onError(e: Throwable) {
                        //if some error happens in our data layer our app will not crash, we will
                        // get error here
                    }

                    override fun onNext(data: ArrayList<Repository>) {
                        repositories.value = data
                    }

                    override fun onComplete() {
                        isLoading.set(false)
                    }
                })
    }

    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }


}

/* var gitRepoRepository :GitRepoRepository = GitRepoRepository(NetManager(getApplication()))

 val repositories = MutableLiveData<ArrayList<Repository>>()

 val text = ObservableField("Old Data")

 val isLoading = ObservableField(false)

 //lateinit var disposable : Disposable
 lateinit var compositDisposable : CompositeDisposable()

 fun loadRepositories() {
     isLoading.set(true)

     compositDisposable += gitRepoRepository
             .getRepositories()
             .subscribeOn(Scheduler.newThread())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribeWith(object : DisposableObserver<ArrayList<Repository>>(){

     *//*gitRepoRepository.getRepositories().subscribe(object: Observer<ArrayList<Repository>> {
            override fun onSubscribe(d: Disposable) {


                disposable = d
            }
*//*

            //disposable =  gitRepoRepository.getRepositories().subscribeWith(object: Observer<ArrayList<Repository>>() {
            //compositDisposable.add(gitRepoRepository.getRepositories().subscribeWith(object : DisposableObserver<ArrayList<Repository>>(){

            // with the help of extension function
        *//*compositDisposable += gitRepoRepository.getRepositories().subscribeWith(object : DisposableObserver<ArrayList<Repository>>(){

*//*
        override fun onError(e: Throwable) {
            }

            override fun onNext(data: ArrayList<Repository>) {
                repositories.value = data
            }

            override fun onComplete() {
                isLoading.set(false)
            }
        })
    }


    override fun onCleared() {
        super.onCleared()

        *//*if(!disposable.isDisposed){
            disposable.dispose()
        }*//*

        if (!compositDisposable.isDisposed){
            compositDisposable.dispose()
        }
    }

}*/


//class MainViewModel : AndroidViewModel {

//    constructor(application: Application) :super(application) // getting context

/*class MainViewModel(application: Application) : AndroidViewModel(application){

    var gitRepoRepository :GitRepoRepository = GitRepoRepository(NetManager(getApplication()))



    //var repositories = MutableLiveData<ArrayList<Repository>>()
    val repositories = MutableLiveData<ArrayList<Repository>>()

    //var repoModel : RepoModel = RepoModel()

    //val text = ObservableField<String>()
    val text = ObservableField("Old Data")

    //val isLoading = ObservableField<Boolean>()
    val isLoading = ObservableField(false)

    fun loadRepositories(){

        isLoading.set(true)
        //repoModel.getRepositories(object : OnRepositoryReadyCallback{ override fun onDataReady(data: ArrayList<Repository>) {
        gitRepoRepository.getRepositories(object : OnRepositoryReadyCallback{ override fun onDataReady(data: ArrayList<Repository>) {
                isLoading.set(false)
                //repositories = data       *//*//**//*1*
                repositories.value = data
            }
        })
    }

}*/*/
