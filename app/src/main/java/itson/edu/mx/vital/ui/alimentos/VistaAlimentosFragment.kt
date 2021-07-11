package itson.edu.mx.vital.ui.alimentos

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import itson.edu.mx.vital.databinding.AlimentoFragmentBinding
import itson.edu.mx.vital.utilities.Alimento
import itson.edu.mx.vital.R
import org.w3c.dom.Text


class VistaAlimentosFragment : Fragment() {

    companion object{
        var alimentos:ArrayList<Alimento> = ArrayList<Alimento>()
        var adapter:AlimentosAdapter?=null
    }
    private lateinit var vistaAlimentoViewModel: VistaAlimentoViewModel
    private var _binding: AlimentoFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vistaAlimentoViewModel =
            ViewModelProvider(this).get(VistaAlimentoViewModel::class.java)

        _binding = AlimentoFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        cargarAlimentos()

        adapter = AlimentosAdapter(root.context, alimentos)

        val gridView: GridView = root.findViewById(R.id.gridview_alimentos)

        gridView.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun cargarAlimentos(){
        alimentos.clear()
        alimentos.add(Alimento("Banana", R.mipmap.banana))
        alimentos.add(Alimento("Cereza", R.mipmap.cereza))   //Cereza
        alimentos.add(Alimento("Durazno", R.mipmap.durazno))  //Durazno
        alimentos.add(Alimento("Fresa", R.mipmap.fresa))    //Fresa
        alimentos.add(Alimento("Manzana", R.mipmap.manzana))  //Manzana
        alimentos.add(Alimento("Moras", R.mipmap.moras))    //Moras
        alimentos.add(Alimento("Naranja", R.mipmap.naranja))  //Naranja
        alimentos.add(Alimento("Pera", R.mipmap.pera))     //Pera
        alimentos.add(Alimento("Piña", R.mipmap.pina))     //Piña
        alimentos.add(Alimento("Uvas", R.mipmap.uvas))     //Uvas
        alimentos.add(Alimento("Zarzamora", R.mipmap.zarzamora))//Zarzamora
    }

    class AlimentosAdapter:BaseAdapter {

        var alimentos:ArrayList<Alimento> = ArrayList<Alimento>()
        var context:Context? = null

        constructor(context:Context, alimentos:ArrayList<Alimento>){
            this.context = context
            this.alimentos = alimentos
        }

        override fun getCount(): Int {
            return this.alimentos.size
        }

        override fun getItem(position: Int): Any {
            return this.alimentos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var alimento = getItem(position) as Alimento
            var inflator = LayoutInflater.from(this.context)
            var vista = inflator.inflate(R.layout.alimento_view, null)

            var nombre = vista.findViewById<TextView>(R.id.textView_alimentoNombre)
            var imagen = vista.findViewById<ImageView>(R.id.img_alimento)

            nombre.text = alimento.nombre
            imagen.setImageResource(alimento.src)

            return vista
        }


    }

}