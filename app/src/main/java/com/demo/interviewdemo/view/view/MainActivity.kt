package com.demo.interviewdemo.view.view


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demo.interviewdemo.R
import com.demo.interviewdemo.view.data.dta.models.Repo
import com.demo.interviewdemo.view.view.adapter.RepoAdapter
import com.demo.interviewdemo.view.viewmodels.RepoViewModel
import com.demo.interviewdemo.view.viewmodels.viewmodelfactories.RepoViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var listRepos: MutableList<Repo>
    private lateinit var adapter: RepoAdapter
    lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler = findViewById<RecyclerView>(R.id. recycler)
        recycler.layoutManager = LinearLayoutManager(this@MainActivity)

        listRepos = mutableListOf<Repo>()

        adapter = RepoAdapter(this,
            listRepos
        )
        recycler.adapter = adapter

        //create viewmodel instnce and call the api.
        val RepoViewModel = ViewModelProviders.of(this, RepoViewModelFactory(this)).get(
            RepoViewModel::class.java)
        RepoViewModel.getData().observe(this,object: Observer<ArrayList<Repo>> {
            override fun onChanged(t: ArrayList<Repo>?) {
                listRepos.clear()
                t?.let { listRepos.addAll(it) }
                adapter.notifyDataSetChanged()
            }

        })

    }
}