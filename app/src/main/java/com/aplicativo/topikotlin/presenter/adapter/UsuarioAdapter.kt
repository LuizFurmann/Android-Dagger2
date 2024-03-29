package com.aplicativo.topikotlin.presenter.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.aplicativo.topikotlin.databinding.CardItemBinding
import com.aplicativo.topikotlin.data.model.User
import com.bumptech.glide.Glide
import java.util.*
import kotlin.collections.ArrayList

class UsuarioAdapter : RecyclerView.Adapter<UsuarioAdapter.MyViewHolder>(), Filterable {

    var listUser: ArrayList<User> = ArrayList()
    var filteredListItems: ArrayList<User> = ArrayList()

    fun setlistData(listUser: List<User>?) {
        filteredListItems.clear()
        this.listUser.clear()
        this.listUser.addAll(listUser!!)
        this.filteredListItems.addAll(listUser)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view  = CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val account = listUser.get(position)
        holder.bind(listUser[position])


        callToast(holder, account)
    }

    private fun callToast(
        holder: MyViewHolder,
        account: User
    ) {
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "User ${account.name}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val searchText = charSequence.toString().lowercase(Locale.getDefault())
                listUser.clear()
                if (searchText.isEmpty()) {
                    listUser.addAll(filteredListItems)
                } else {
                    for (item in filteredListItems) {
                        if (searchText.isNotEmpty() && item.name.lowercase(Locale.getDefault()).contains(searchText)) {
                            listUser.add(item)
                        }
                    }
                }
                val filterResults = FilterResults()
                filterResults.values = listUser
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
                @Suppress("UNCHECKED_CAST")
                listUser = filterResults.values as ArrayList<User>
                notifyDataSetChanged()
            }
        }
    }

    class MyViewHolder(binding: CardItemBinding): RecyclerView.ViewHolder(binding.root) {
        val thumbImage = binding.thumbImage
        val name = binding.name
        val description = binding.description
        val forks = binding.forks
        val full_name = binding.fullName
        val login = binding.login
        val stargazers_count = binding.star

        fun bind(user: User) {
            name.text = user.name
            description.text = user.description
            forks.text = user.forks
            full_name.text = user.full_name
            login.text = user.login
            stargazers_count.text = user.stargazers_count

            Glide.with(thumbImage)
                .load(user.owner.avatar_url)
                .into(thumbImage)
        }
    }
}