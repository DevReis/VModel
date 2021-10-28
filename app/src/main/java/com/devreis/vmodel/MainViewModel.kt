package com.devreis.vmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var contador: Int = 0
    var mContador = MutableLiveData<String>().apply { value = contador.toString() }

    private fun setmContador() {
        mContador.value = contador.toString()
    }

    fun rodaContador(){
        contador++
        if (contador > 5) { contador = 0 }
        setmContador()
    }
}