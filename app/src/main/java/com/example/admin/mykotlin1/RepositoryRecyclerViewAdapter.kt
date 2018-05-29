package com.example.test1

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.admin.mykotlin1.Repository
import com.example.admin.mykotlin1.databinding.RvItemRepositoryBinding

/**
 * Created by 243208 on 25/05/18.
 */
class RepositoryRecyclerViewAdapter(private var items: ArrayList<Repository>, private var listener: OnItemClickListener)
    : RecyclerView.Adapter<RepositoryRecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //To change body of created functions use File | Settings | File Templates.

        val layoutInflater = LayoutInflater.from(parent?.context)
        val binding = RvItemRepositoryBinding.inflate(LayoutInflater.from(parent?.context), parent, false)

        //val binding = RvItemRepositoryBinding.inflate(LayoutInflater.from(parent?.context),parent,false)

        return ViewHolder(binding)

        //return ViewHolder(RvItemRepositoryBinding.inflate(LayoutInflater.from(parent?.context),parent,false))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], listener)
    /*{
    }*/

    override fun getItemCount(): Int = items.size
    /*{
    }*/

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }


    fun replaceData(arrayList: ArrayList<Repository>) {
        items = arrayList
        notifyDataSetChanged()
    }


    class ViewHolder(private var binding: RvItemRepositoryBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(repo: Repository, listener: OnItemClickListener?) {
            binding.repository = repo

            if (listener != null) {

                //binding.root.setOnClickListener({ _ -> listener.onItemClick(layoutPosition) })

                binding.root.setOnClickListener({ View.OnClickListener { listener.onItemClick(layoutPosition) } })
            }

            binding.executePendingBindings()
        }

    }


}