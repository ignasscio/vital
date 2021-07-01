package itson.edu.mx.vital.ui.ejercicios

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import itson.edu.mx.vital.R

class EjerciciosFragment : Fragment() {

    companion object {
        fun newInstance() = EjerciciosFragment()
    }

    private lateinit var viewModel: EjerciciosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.ejercicios_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EjerciciosViewModel::class.java)
        // TODO: Use the ViewModel
    }

}