package itson.edu.mx.vital.ui.favoritos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import itson.edu.mx.vital.R
import itson.edu.mx.vital.databinding.FavoritosFragmentBinding
import itson.edu.mx.vital.ui.favoritos.FavoritosViewModel

class FavoritosFragment : Fragment() {

    private lateinit var favoritosViewModel: FavoritosViewModel
    private var _binding: FavoritosFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        favoritosViewModel =
            ViewModelProvider(this).get(FavoritosViewModel::class.java)

        _binding = FavoritosFragmentBinding.inflate(inflater, container, false)
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