package itson.edu.mx.vital.ui.ejercicios

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import itson.edu.mx.vital.R
import itson.edu.mx.vital.databinding.EjercicioFragmentBinding
import itson.edu.mx.vital.ui.ejercicios.EjercicioViewModel

class EjercicioFragment : Fragment() {

    private lateinit var ejercicioViewModel: EjercicioViewModel
    private var _binding: EjercicioFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ejercicioViewModel =
            ViewModelProvider(this).get(EjercicioViewModel::class.java)

        _binding = EjercicioFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        ////INICIA CODIGO AQUI


        ///TERMINA CODIGO



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}