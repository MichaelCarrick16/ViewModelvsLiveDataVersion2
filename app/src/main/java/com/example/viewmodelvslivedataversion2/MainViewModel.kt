package com.example.viewmodelvslivedataversion2

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private lateinit var timer : CountDownTimer

     val _second : MutableLiveData<Int> by lazy {
         MutableLiveData<Int>()
     }

    val checkFinish : MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun startTimer(){
        timer =object :CountDownTimer(10000,1000){
            override fun onTick(p0: Long) {
                var timeCurrent = p0/1000
                _second.value = timeCurrent.toInt()
                checkFinish.value = false
            }

            override fun onFinish() {
                checkFinish.value = true
            }

        }.start()
    }

    fun stopTimer(){
        timer.cancel()
    }
}