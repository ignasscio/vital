package itson.edu.mx.vital.ui.ejercicios

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EjercicioViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is ejercicio Fragment"
    }
    val text: LiveData<String> = _text
}