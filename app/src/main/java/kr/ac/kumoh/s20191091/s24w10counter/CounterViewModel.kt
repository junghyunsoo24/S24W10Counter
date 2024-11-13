package kr.ac.kumoh.s20191091.s24w10counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val _count = MutableLiveData(0)
//    private val _count = MutableLiveData<ModelClass>()
    val count: LiveData<Int> = _count //람다함수를 통해 return 생략

    fun onAdd(){
        _count.value = _count.value?.plus(1)
        //_count.value = _count.value?.plus(1)
    }

    fun onSub(){
        if((_count.value ?:0) > 0){
           _count.value = _count.value?.minus(1)
        }
    }

    fun onReset(){
        _count.value = 0
    }
}