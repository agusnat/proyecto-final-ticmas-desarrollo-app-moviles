package com.curso.android.app.proyectoargentinaprograma.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curso.android.app.proyectoargentinaprograma.model.TextData

class CompareViewModel : ViewModel() {
    private val _compareData = MutableLiveData<TextData>()
    val compareData: LiveData<TextData> = _compareData

    fun compareTexts(text1: String, text2: String) {
        var resultado = "Resultado: No son iguales."

        if(text1 == text2)
            resultado = "Resultado: Son iguales."

        _compareData.value = TextData(resultado)
    }
}