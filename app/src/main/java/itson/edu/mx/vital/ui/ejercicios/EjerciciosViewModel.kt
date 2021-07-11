package itson.edu.mx.vital.ui.ejercicios

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EjerciciosViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is ejercicios Fragment"
    }
    val text: LiveData<String> = _text
}