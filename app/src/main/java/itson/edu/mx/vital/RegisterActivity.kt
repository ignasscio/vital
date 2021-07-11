package itson.edu.mx.vital


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = Firebase.auth

        val btn_create: Button = findViewById(R.id.btn_create)

        btn_create.setOnClickListener{
            valida_registro()
        }
    }

    private fun valida_registro(){
        val et_correo: EditText = findViewById(R.id.et_email)
        val et_contra1: EditText = findViewById(R.id.et_password)

        //val et_contra2: EditText = findViewById(R.id.et_contra2_reg)

        var correo: String = et_correo.text.toString()
        var contra1: String = et_contra1.text.toString()
       // var contra2: String = et_contra2.text.toString()

        if(!correo.isNullOrBlank() && !contra1.isNullOrBlank()){

            registrarFirebase(correo, contra1)
            /*
            if(contra1 == contra2){

                registrarFirebase(correo, contra1)

            }else{
                Toast.makeText(this, "Las contraseña no coinciden",
                    Toast.LENGTH_SHORT).show()
            }
            */

        }else{
            Toast.makeText(this, "Ingresar datos",
                Toast.LENGTH_SHORT).show()
        }
    }

    private fun registrarFirebase(email: String, password: String){

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    //Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser

                    Toast.makeText(baseContext, "${user!!.email} se ha creado correctamente",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    //Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(null)
                }
            }
    }
}