package itson.edu.mx.vital.ui.alimentos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VistaAlimentoViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is alimento Fragment"
    }
    val text: LiveData<String> = _text
}