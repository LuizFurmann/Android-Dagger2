package com.aplicativo.topikotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aplicativo.topikotlin.presenter.adapter.UsuarioAdapter
import com.aplicativo.topikotlin.databinding.ActivityMainBinding
import com.aplicativo.topikotlin.di.ViewModelFactory
import com.aplicativo.topikotlin.presenter.viewmodel.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var usuarioAdapter: UsuarioAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        (application as MainApplication).retrofitComponent.inject(this)
        setContentView(binding.root)

        initRecyclerView()
        initViewModel()
    }

    //RecyclerView
    private fun initRecyclerView() {
        binding.rvUsuarios.layoutManager = LinearLayoutManager(this)
        usuarioAdapter = UsuarioAdapter()
        binding.rvUsuarios.adapter = usuarioAdapter
    }

    //ViewModel
    private fun initViewModel() {
        val mainViewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        mainViewModel.getList().observe(this, {
            if(it != null) {
                usuarioAdapter.setlistData(it.items)
                usuarioAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Something is wrong with connection!", Toast.LENGTH_SHORT).show()
            }
        })
        mainViewModel.loadListUser()
    }

    //ToopBar
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