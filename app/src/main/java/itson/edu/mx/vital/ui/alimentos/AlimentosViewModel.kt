package itson.edu.mx.vital.ui.alimentos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AlimentosViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is alimentos Fragment"
    }
    val text: LiveData<String> = _text
}