package com.example.admin.mykotlin1

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.example.a243208.mykotlintry.MainViewModel
import com.example.admin.mykotlin1.databinding.ContentMainBinding
import com.example.test1.RepositoryRecyclerViewAdapter
import dagger.android.support.DaggerAppCompatActivity

import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), RepositoryRecyclerViewAdapter.OnItemClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var dataBinding: ContentMainBinding

    private val repositoryRecyclerViewAdapter = RepositoryRecyclerViewAdapter(arrayListOf(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding = DataBindingUtil.setContentView(this, R.layout.content_main)

        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        dataBinding.viewModel = viewModel

        dataBinding.executePendingBindings()

        dataBinding.repositoryRv.layoutManager = LinearLayoutManager(this)

        //dataBinding.repositoryRv.adapter = RepositoryRecyclerViewAdapter(viewModel.repositories,this)     //*1*

        dataBinding.repositoryRv.adapter = repositoryRecyclerViewAdapter

        viewModel.repositories.observe(this, Observer<ArrayList<Repository>> { it?.let { repositoryRecyclerViewAdapter.replaceData(it) } })


        //setContentView(R.layout.activity_main)


        /* setSupportActionBar(toolbar)

         fab.setOnClickListener { view ->
             Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                     .setAction("Action", null).show()
         }*/
    }


    override fun onItemClick(position: Int) {
    }


    /*override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }*/
}
