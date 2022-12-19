package com.example.appnewkool.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appnewkool.data.base.BaseViewModel
import com.example.appnewkool.data.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository) :
    BaseViewModel() {
    var listProduct = MutableLiveData<List<Product>>()
        private set

    override fun fetchData() {
        parentJob = viewModelScope.launch(handler) {
//            isLoading.postValue(true)
            val products = homeRepository.getListProduct()
            if (products.isNotEmpty()) {
                listProduct.postValue(products)
            }
        }
        registerJobFinish()
    }

    fun refresh() {
        parentJob = viewModelScope.launch(handler) {
//            isLoading.postValue(true)
            val products = homeRepository.getProductAndSaveFromRemote()
            if (products.isNotEmpty()) {
                listProduct.postValue(products)
            }
        }
        registerJobFinish()
    }
}