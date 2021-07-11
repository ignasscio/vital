package itson.edu.mx.vital

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions
import com.google.android.gms.common.api.GoogleApiClient
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_log_in.*
import kotlinx.android.synthetic.main.activity_register.*


class LogInActivity : AppCompatActivity() {


    lateinit var gso: GoogleSignInOptions
    lateinit var mGoogleSignInClient: GoogleSignInClient
    val RC_SIGN_IN: Int = 1
    lateinit var signOut: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        //Splash
        Thread.sleep(3000)
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)



        //Analytics Event
        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()

        bundle.putString("message", "Integracion de firebase completa")
        analytics.logEvent("UInitScreen", bundle)


        //Setup
        setup()
        //guerdado de datos

        var prefs:SharedPreferences = getSharedPreferences()

        //showindex
        //showIndex()
    }

    private fun setup() {
        title = " Vital"

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

        ///Crear cuenta
        btn_createAcc.setOnClickListener {
            val intent: Intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }

    private fun showAlert() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error al usuario")
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


}
