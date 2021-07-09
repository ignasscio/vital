package itson.edu.mx.vital

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_log_in.*
import kotlinx.android.synthetic.main.activity_register.*

class LogInActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        //Splash
        Thread.sleep(3000)
        setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)


        ////TEST *
        //AGREGAR  recycler view
        //AGREGAR  recycler
        /*
        adapter = MainAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        observeData()
        */
        /*
        val dummyList:MutableList<Paciente> = mutableListOf<Paciente>()
        dummyList.add(Paciente("https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
            "Paciente 1","Emferdedad de prueba"))
        adapter.setListaData(dummyList)
        adapter.notifyDataSetChanged()
*/


        //Analytics Event
        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()

        bundle.putString("message", "Integracion de firebase completa")
        analytics.logEvent("UInitScreen", bundle)


        //Setup
        setup()

        //showindex
        //  showIndex()
    }

    private fun setup() {
        title = " Vital"
       /*
        btn_create.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)


        }
        */


        //  emailEditText.setText("3@gmail.com")
        //  passwordEditText.setText("123456")
        btn_login.setOnClickListener {
            if (et_emailLogin.text.isNotEmpty() && et_passwordLogin.text.isNotEmpty()) {


                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(
                        et_emailLogin.text.toString(),
                        et_passwordLogin.text.toString()
                    )
                    .addOnCompleteListener() {


                        if (it.isSuccessful) {
                            showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                        } else {

                            showAlert()
                        }
                    }
            }

        }
    }

    private fun showAlert() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error al usario")
        builder.setPositiveButton("aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()

    }

    //Muestra el index
    private fun showHome(email: String, provider: ProviderType) {

        val profileIntent = Intent(this, MainActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(profileIntent)
    }

    //Muestra el index
    private fun showIndex() {
        val profileIntent = Intent(this, RegisterActivity::class.java).apply {
        }
        startActivity(profileIntent)


    }
/*
    fun observeData() {
        viewModel.fetuserData().observe(this, Observer {
            adapter.setListaData(it)
            adapter.notifyDataSetChanged()
        })
*/

}
