package com.example.appnewkool.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.appnewkool.data.base.BaseViewModel
import com.example.appnewkool.data.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository) :
    BaseViewModel() {
    var listProducts by mutableStateOf<List<Product>>(mutableListOf())
        private set
    var token by mutableStateOf<String?>("")

    init {
        fetchData()
    }

    override fun fetchData() {
        parentJob = viewModelScope.launch(handler) {
            isLoading = true
            token = homeRepository.getToken()
            val products = homeRepository.getListProduct()
            if (products.isNotEmpty()) {
                listProducts = products
            }
        }
        onJobFinish()
    }


    fun refresh() {
        parentJob = viewModelScope.launch(handler) {
            isLoading = true
            val products = homeRepository.getProductAndSaveFromRemote()
            if (products.isNotEmpty()) {
                listProducts = products
            }
        }
        onJobFinish()
    }
}