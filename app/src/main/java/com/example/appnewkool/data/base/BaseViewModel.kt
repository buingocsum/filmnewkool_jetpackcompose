package com.example.appnewkool.data.base

import android.accounts.NetworkErrorException
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appnewkool.common.Event
import com.example.appnewkool.data.base.network.BaseNetworkException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job

open class BaseViewModel : ViewModel() {

    var baseNetworkException = mutableStateOf("")
        protected set


    var networkException = mutableStateOf("")
        protected set

    var isLoading = mutableStateOf(false)
        protected set

//    var onNavigateToPage = MutableLiveData<Event<Int>>()
//        protected set
//
//    var errorMessageResourceId = MutableLiveData<Event<Int>>()
//        protected set
//
//    var notifyMessageResourceId = MutableLiveData<Event<Int>>()
//        protected set

    var isLoadingMore = mutableStateOf(false)
        protected set

    var parentJob: Job? = null
        protected set

    protected fun addNetworkException(exception: NetworkErrorException) {
//        networkException.postValue(Event(exception))
    }


    protected fun registerJobFinish() {
        parentJob?.invokeOnCompletion {
            isLoading.value = false
        }
    }

    val handler = CoroutineExceptionHandler { _, exception ->
        parseErrorCallApi(exception)
    }

    protected fun showError(messageId: Int) {
//        errorMessageResourceId.postValue(Event(messageId))
    }

    protected fun showNotify(messageId: Int) {
//        notifyMessageResourceId.postValue(Event(messageId))
    }



    protected fun showLoading(isShow: Boolean) {
//        isLoading.postValue(Event(isShow))
    }

    protected fun showLoadingMore(isShow: Boolean) {
//        isLoadingMore.postValue(Event(isShow))
    }

    protected fun navigateToPage(actionId: Int) {
//        onNavigateToPage.postValue(Event(actionId))
    }

    protected fun addBaseNetworkException(exception: BaseNetworkException) {
//        baseNetworkException.postValue(Event(exception))
    }


    protected open fun parseErrorCallApi(e: Throwable) {
        when (e) {
            is BaseNetworkException -> {
//                baseNetworkException.postValue(Event(e))
            }
            is NetworkErrorException -> {
//                networkException.postValue(Event(e))
            }
            else -> {
                val unknowException = BaseNetworkException()
                unknowException.mainMessage = e.message ?: "Something went wrong"
//                baseNetworkException.postValue(Event(unknowException))
            }
        }
    }

    open fun fetchData() {

    }

}