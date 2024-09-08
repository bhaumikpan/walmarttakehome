package com.example.feature_domain.model

data class ListItem(
    val char: Char = Character.MIN_VALUE,
    val country: Country,
    val isHeader: Boolean = false
)
