package itson.edu.mx.vital.ui.alimentos

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
import itson.edu.mx.vital.LogInActivity
import itson.edu.mx.vital.R
import itson.edu.mx.vital.databinding.AlimentosFragmentBinding
import itson.edu.mx.vital.ui.recetas.RecetasMenuFragment

class AlimentosFragment : Fragment() {

    private lateinit var alimentosViewModel: AlimentosViewModel
    private var _binding: AlimentosFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        alimentosViewModel =
            ViewModelProvider(this).get(AlimentosViewModel::class.java)

        _binding = AlimentosFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root


        var btn_fruta = root.findViewById<Button>(R.id.btn_frutas)

        btn_fruta.setOnClickListener{
            var fr = getFragmentManager()?.beginTransaction()
            fr?.replace(R.id.alimentosFragment, VistaAlimentosFragment())
            fr?.commit()
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}