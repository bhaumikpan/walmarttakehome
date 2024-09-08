package com.example.feature_ui.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feature_domain.model.Country
import com.example.feature_domain.model.ListItem

import com.example.feature_ui.adapter.ListAdapter
import com.example.feature_ui.databinding.ListFragmentBinding
import com.example.feature_ui.viewmodel.FeatureViewModel

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment: Fragment() {

    private val viewModel by viewModels<FeatureViewModel>()

    private var _binding: ListFragmentBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Access views using the binding property

        // Initialize RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Observe the items LiveData
        viewModel.items.observe(viewLifecycleOwner) { items ->
            // Update RecyclerView with the new list
            val answer = generateCountryListWithHeaders(items)
            Log.d("BMK", ""+ answer[0])
            binding.recyclerView.adapter = ListAdapter(answer)
        }

        // Observe the error LiveData
        viewModel.error.observe(viewLifecycleOwner) { errorMessage ->
            errorMessage?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Create a function to generate a list of headers and contacts
    private fun generateCountryListWithHeaders(contacts: List<Country>): List<ListItem> {
        val groupedContacts = contacts.sortedBy { it.name }.groupBy { it.name?.first() }
        val listItems = mutableListOf<ListItem>()

        for ((header, items) in groupedContacts) {
            // Add the header (A, B, C, etc.)
            listItems.add(header?.let { ListItem(char = it, country = Country(), isHeader = true) }!!)

            // Add the contacts under that header
            items.forEach { contact ->
                listItems.add(ListItem( country = contact, isHeader = false))
            }
        }

        return listItems
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}