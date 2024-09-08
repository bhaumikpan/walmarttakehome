package com.example.feature_ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

import com.example.feature_domain.model.Country
import com.example.feature_domain.model.ListItem
import com.example.feature_ui.R
import com.example.feature_ui.databinding.ItemHeaderLayoutBinding
import com.example.feature_ui.databinding.ListItemLayoutBinding

class ListAdapter(private val items: List<ListItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // Define view types
    companion object {
        private const val VIEW_TYPE_HEADER = 0
        private const val VIEW_TYPE_ITEM = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        /*val binding =
            ListItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)*/
        return if (viewType == VIEW_TYPE_HEADER) {
            val binding =
                ItemHeaderLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            HeaderViewHolder(binding)
        } else {
            val binding =
                ListItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ListViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val listItem = items[position]
        if (holder is HeaderViewHolder) {
            holder.bind(listItem.char.toString())
        } else if (holder is ListViewHolder) {
            holder.bind(listItem.country)
        }
    }

    // Determine if it's a header or item
    override fun getItemViewType(position: Int): Int {
        return if (items[position].isHeader) VIEW_TYPE_HEADER else VIEW_TYPE_ITEM
    }

    override fun getItemCount() = items.size

    inner class HeaderViewHolder(private val binding: ItemHeaderLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.headerTextView.text = item
        }
    }

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
