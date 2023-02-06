package com.example.appnewkool.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.appnewkool.data.base.BaseViewModel
import com.example.appnewkool.data.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository) :
    BaseViewModel() {
    private var _listProducts = MutableLiveData<List<Product>>()
//        private set

    val listProducts: LiveData<List<Product>>
    get() = _listProducts
    init {
        fetchData()
    }
    override fun fetchData() {
        parentJob = viewModelScope.launch(handler) {
//            isLoading.postValue(true)
            val products = homeRepository.getListProduct()
            if (products.isNotEmpty()) {
                _listProducts.postValue(products)
            }
        }
        registerJobFinish()
    }


    fun refresh() {
        parentJob = viewModelScope.launch(handler) {
//            isLoading.postValue(true)
            val products = homeRepository.getProductAndSaveFromRemote()
            if (products.isNotEmpty()) {
                _listProducts.postValue(products)
            }
        }
        registerJobFinish()
    }
}