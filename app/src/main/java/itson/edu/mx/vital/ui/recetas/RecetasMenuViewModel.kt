package itson.edu.mx.vital.ui.recetas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecetasMenuViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is recetas menu Fragment"
    }
    val text: LiveData<String> = _text
}