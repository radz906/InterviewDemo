package com.demo.interviewdemo.view.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.demo.interviewdemo.R

import com.demo.interviewdemo.view.data.dta.models.Repo

/*create adapter for the recyclerview to set all the items into recyclerview.*/
class RepoAdapter(private val context: Context, private var list: MutableList<Repo>) : RecyclerView.Adapter<RepoAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.repo_list_row,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {



        val user = list.get(position)
        holder.name?.text = user.name
        holder.desc?.text = user?.description


    }

    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view){

        var name: TextView? = null
        var desc: TextView? = null


        init {
            name = view.findViewById(R.id.txt_user_name)
            desc = view.findViewById(R.id.txt_desc)

        }

    }

}