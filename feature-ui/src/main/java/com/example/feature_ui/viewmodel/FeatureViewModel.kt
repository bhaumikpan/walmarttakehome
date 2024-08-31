package com.example.feature_ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.analytics.impl.AnalyticsRepoImpl
import com.example.feature_domain.model.Country
import com.example.feature_domain.repository.FeatureRepo
import com.example.network_data.extensions.CoreResult

import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class FeatureViewModel @Inject constructor(
    private val repo: FeatureRepo, private val analyticsRepo: AnalyticsRepoImpl
) : ViewModel() {

    private val _items = MutableLiveData<List<Country>>()
    val items: LiveData<List<Country>> get() = _items

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    init {
        loadItems()
    }

    private fun loadItems() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                when (val response = repo.getCountryList()) {
                    is CoreResult.OnSuccess -> {
                        _items.postValue(response.data)
                        analyticsRepo.submit("GOT DATA TO DISPLAY SIZE:" + response.data.size)
                    }

                    is CoreResult.OnError -> {
                        val error = response.error ?: Throwable("EMPTY ERROR IN RESPONSE: UNKNOWN ERROR")
                        _error.postValue(error.message)
                        analyticsRepo.submit("GOT ERROR:" + error.message)
                    }

                    else -> {
                        _error.postValue("UNKNOWN ERROR")
                        analyticsRepo.submit("GOT ERROR: UNKNOWN")
                    }
                }
            } catch (e: Exception) {
                _error.postValue(e.message)
            }
        }
    }
}