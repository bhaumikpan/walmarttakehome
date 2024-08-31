package com.example.feature_domain.repository

import com.example.feature_domain.model.Country
import com.example.network_data.extensions.CoreResult

interface FeatureRepo {
    suspend fun getCountryList(): CoreResult<List<Country>>
}