package com.example.feature_ui.util

import com.example.feature_domain.model.Country
import com.example.feature_domain.model.DisplayItem
import com.example.feature_domain.model.IDisplayItem

object Util {
    // Create a function to generate a list of headers and contacts
    fun generateCountryListWithHeaders(contacts: List<Country>): List<DisplayItem> {
        val groupedList = contacts.sortedBy { it.name }.groupBy { it.name?.first() }
        val listItems = mutableListOf<DisplayItem>()
        for ((header, items) in groupedList) {
            // Add the header (A, B, C, etc.)
            val item = IDisplayItem
            header?.let {
                listItems.add(item.fromHeader(it.toString()))
            }

            items.forEach { country ->
                val itemCountry = IDisplayItem
                listItems.add(itemCountry.fromCountry(country))
            }

        }
        return listItems
    }
}