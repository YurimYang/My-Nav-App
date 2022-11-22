package com.example.mynavapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mynavapplication.repository.MbtiRepository

const val UNCHECKEDMBTI = "ISTP"


//viewmodel에서는 api (데이터만 !! )
class MbtiViewModel: ViewModel() {
    private val _mbti = MutableLiveData<String>(UNCHECKEDMBTI)
    val mbti : LiveData<String> = _mbti //밖에서 볼수있는 프로퍼티(내부적으로는 바꿀수 있는 livedata, 외부적으로는 바꿀수없는 mutable)
    private val repository = MbtiRepository()
    init {
        repository.observeMbti(_mbti)
    }


    private fun modifyMbti(index:Int, newValue: Char){
        val newMbti = _mbti.value?.let{
            val chArr = it.toCharArray()
            chArr[index] = newValue
            String(chArr)
        }?: UNCHECKEDMBTI

        repository.postMbti(newMbti)
    }

    val isE get() =_mbti.value?.get(0) == 'E'
    val isN get() =_mbti.value?.get(1) == 'N'
    val isF get() =_mbti.value?.get(2) == 'F'
    val isJ get() =_mbti.value?.get(3) == 'J'

    fun setE(newValue : Boolean) {
        modifyMbti(0, if(newValue) 'E' else 'I')
    }
    fun setN(newValue : Boolean) {
        modifyMbti(1, if(newValue) 'N' else 'S')
    }
    fun setF(newValue : Boolean) {
        modifyMbti(2, if(newValue) 'F' else 'T')
    }
    fun setJ(newValue : Boolean) {
        modifyMbti(3, if(newValue) 'J' else 'P')
    }

}