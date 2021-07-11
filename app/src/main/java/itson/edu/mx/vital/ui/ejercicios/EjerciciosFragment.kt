package itson.edu.mx.vital.ui.ejercicios

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import itson.edu.mx.vital.R
import itson.edu.mx.vital.databinding.EjerciciosFragmentBinding
import itson.edu.mx.vital.ui.ejercicios.EjerciciosViewModel
import itson.edu.mx.vital.ui.recetas.RecetasMenuFragment

class EjerciciosFragment : Fragment() {

    private lateinit var ejerciciosViewModel: EjerciciosViewModel
    private var _binding: EjerciciosFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ejerciciosViewModel =
            ViewModelProvider(this).get(EjerciciosViewModel::class.java)

        _binding = EjerciciosFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        ////INICIA CODIGO AQUI

        var btn_gluteos = root.findViewById<Button>(R.id.btn_gluteos)

        btn_gluteos.setOnClickListener{
            var fr = getFragmentManager()?.beginTransaction()
            fr?.replace(R.id.ejerciciosFragment, VistaEjerciciosFragment())
            fr?.commit()
        }


        ///TERMINA CODIGO



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}