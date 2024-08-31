package com.example.feature_ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.feature_domain.model.Country
import com.example.feature_ui.databinding.ListItemLayoutBinding

class ListAdapter(private val items: List<Country>) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            ListItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class ListViewHolder(private val binding: ListItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Country) {
            binding.nameTxtView.text = item.name
            binding.regionTxtView.text = item.region
            binding.codeTxtView.text = item.code
            binding.capitalTxtView.text = item.capital
        }
    }
}
