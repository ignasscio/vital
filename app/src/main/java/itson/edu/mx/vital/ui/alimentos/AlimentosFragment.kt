package itson.edu.mx.vital.ui.alimentos

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import itson.edu.mx.vital.R

class AlimentosFragment : Fragment() {

    companion object {
        fun newInstance() = AlimentosFragment()
    }

    private lateinit var viewModel: AlimentosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.alimentos_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AlimentosViewModel::class.java)
        // TODO: Use the ViewModel
    }

}