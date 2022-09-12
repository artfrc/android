package com.androiddev.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//    As linhas var count = 0 e count++ foram comentadas para inserir LiveData

class MainActivityViewModel : ViewModel() {

    //var count = 0
    var count = MutableLiveData<Int>() // LiveData

    init{
        count.value = 0
    }

    fun updateCount(){

      //  count++
        count.value = (count.value)?.plus(1)

    }

}