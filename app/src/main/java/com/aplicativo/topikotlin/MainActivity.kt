package com.aplicativo.topikotlin

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aplicativo.topikotlin.adapter.UsuarioAdapter
import com.aplicativo.topikotlin.databinding.ActivityMainBinding
import com.aplicativo.topikotlin.model.User
import com.aplicativo.topikotlin.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var usuarioAdapter: UsuarioAdapter
    val itemList : ArrayList<User> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        binding.rvUsuarios.layoutManager = LinearLayoutManager(this)
        usuarioAdapter = UsuarioAdapter()
        binding.rvUsuarios.adapter = usuarioAdapter
    }

    private fun initViewModel() {
        val viewModel: MainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getUser().observe(this, Observer {
            if(it != null) {
                usuarioAdapter.setlistData(it)
                usuarioAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Something is wrong with connection!", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.loadListUser()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val search = menu.findItem(R.id.search)
        val searchView = search.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                if (TextUtils.isEmpty(newText)) {
                    usuarioAdapter.getFilter().filter("")
                } else {
                    usuarioAdapter.getFilter().filter(newText)
                }
                return true
            }
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
}