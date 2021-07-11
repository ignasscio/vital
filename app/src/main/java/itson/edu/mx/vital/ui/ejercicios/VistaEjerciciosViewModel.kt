package itson.edu.mx.vital.ui.ejercicios

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VistaEjerciciosViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is alimentos Fragment"
    }
    val text: LiveData<String> = _text
}