package itson.edu.mx.vital.ui.recetas

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import itson.edu.mx.vital.R
import itson.edu.mx.vital.databinding.RecetasMenuFragmentBinding
import itson.edu.mx.vital.ui.recetas.RecetasMenuViewModel

class RecetasMenuFragment : Fragment() {

    private lateinit var recetasMenuViewModel: RecetasMenuViewModel
    private var _binding: RecetasMenuFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        recetasMenuViewModel =
            ViewModelProvider(this).get(RecetasMenuViewModel::class.java)

        _binding = RecetasMenuFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        var btn_comida1 = root.findViewById<ImageButton>(R.id.btn_comida1)

        btn_comida1.setOnClickListener{
            var fr = getFragmentManager()?.beginTransaction()
            fr?.replace(R.id.recetasMenuFragment, RecetaSeleccionadaMenuFragment())
            fr?.commit()
        }



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}