package com.example.feature_domain.model

data class DisplayItem(
    val header: String = "",
    val country: Country = Country(),
)


sealed interface IDisplayItem {
    companion object  {
        fun fromCountry (item: Country): DisplayItem {
             return DisplayItem(
                 country = item
             )
        }

        fun fromHeader (head: String): DisplayItem {
            return DisplayItem(
                header = head
            )
        }
    }
}