package itson.edu.mx.vital.ui.ejercicios

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import itson.edu.mx.vital.R
import itson.edu.mx.vital.databinding.VistaEjerciciosFragmentBinding
import itson.edu.mx.vital.ui.alimentos.VistaAlimentosFragment
import itson.edu.mx.vital.ui.ejercicios.VistaEjerciciosViewModel
import itson.edu.mx.vital.ui.recetas.RecetasMenuFragment
import itson.edu.mx.vital.utilities.Ejercicio
import android.app.FragmentManager

class VistaEjerciciosFragment : Fragment() {

    companion object{
        var ejercicios:ArrayList<Ejercicio> = ArrayList<Ejercicio>()
        var adapter:EjercicioAdapter?=null
    }

    private lateinit var vistaEjerciciosViewModel: VistaEjerciciosViewModel
    private var _binding: VistaEjerciciosFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vistaEjerciciosViewModel =
            ViewModelProvider(this).get(VistaEjerciciosViewModel::class.java)

        _binding = VistaEjerciciosFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        cargarEjercicios()

        adapter = EjercicioAdapter(root.context, ejercicios)


        val gridView: GridView = root.findViewById(R.id.gridView_ejercicios)

        gridView.adapter = adapter


        return root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun cargarEjercicios(){
        ejercicios.clear()
        ejercicios.add(Ejercicio("Abducción", R.mipmap.gluteos_abduccion))
        ejercicios.add(Ejercicio("Frog", R.mipmap.gluteos_frog))
        ejercicios.add(Ejercicio("Patada", R.mipmap.gluteos_patada))
        ejercicios.add(Ejercicio("Peso muerto", R.mipmap.gluteos_pesomuerto))
        ejercicios.add(Ejercicio("Puente", R.mipmap.gluteos_puente))
        ejercicios.add(Ejercicio("Sentadilla", R.mipmap.gluteos_sentadilla))
        ejercicios.add(Ejercicio("Zancada", R.mipmap.gluteos_zancada))
        ejercicios.add(Ejercicio("Zancada lateral", R.mipmap.gluteos_zancadahorizontal))
    }

    class EjercicioAdapter:BaseAdapter{

        var ejercicios:ArrayList<Ejercicio> = ArrayList<Ejercicio>()
        var context:Context?=null

        constructor(context: Context, ejercicios:ArrayList<Ejercicio>){
            this.context = context
            this.ejercicios = ejercicios
        }

        override fun getCount(): Int {
            return this.ejercicios.size
        }

        override fun getItem(position: Int): Any {
            return this.ejercicios[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var ejercicio = this.getItem(position) as Ejercicio
            var inflator = LayoutInflater.from(this.context)
            var vista = inflator.inflate(R.layout.ejercicio_view, null)

            var image = vista.findViewById<ImageView>(R.id.img_ejercicio)
            var nombre = vista.findViewById<TextView>(R.id.textView_nombreEjercicio)

            image.setImageResource(ejercicio.src)
            nombre.text = ejercicio.nombre

            image.setOnClickListener{
                //var fr = getFragmentManager()?.beginTransaction()
                //fr?.replace(R.id.vistaEjerciciosFragment, EjercicioFragment())
                //fr?.commit()
            }

            return vista

        }

    }

}

