package itson.edu.mx.vital.ui.recetas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import itson.edu.mx.vital.R
import itson.edu.mx.vital.databinding.RecetaSeleccionadaMenuFragmentBinding
import itson.edu.mx.vital.ui.recetas.RecetaSeleccionadaMenuViewModel

class RecetaSeleccionadaMenuFragment : Fragment() {

    private lateinit var recetaSeleccionadaMenuViewModel: RecetaSeleccionadaMenuViewModel
    private var _binding: RecetaSeleccionadaMenuFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        recetaSeleccionadaMenuViewModel =
            ViewModelProvider(this).get(RecetaSeleccionadaMenuViewModel::class.java)

        _binding = RecetaSeleccionadaMenuFragmentBinding.inflate(inflater, container, false)
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