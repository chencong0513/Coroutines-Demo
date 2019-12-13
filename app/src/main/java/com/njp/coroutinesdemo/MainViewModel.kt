package com.njp.coroutinesdemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.async

class MainViewModel : ViewModel() {

    val imageData = MutableLiveData<List<String>>()
    val loadState = MutableLiveData<LoadState>()

    fun getData() {
        launch(
            {
                loadState.value = LoadState.Loading()
                val data1 = async { NetworkService.apiService.getImage() }
                val data2 = async { NetworkService.apiService.getImage() }
                val data3 = async { NetworkService.apiService.getImage() }
                imageData.value = listOf(data1.await(), data2.await(), data3.await()).map {
                    it.imgurl
                }
                loadState.value = LoadState.Success()
            },
            {
                loadState.value = LoadState.Fail(it.message ?: "加载失败")
            }
        )
    }


}