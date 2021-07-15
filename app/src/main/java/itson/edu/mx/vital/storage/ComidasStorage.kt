package itson.edu.mx.vital.storage

import android.content.ContentValues
import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class ComidasStorage {
    private var storage: FirebaseFirestore = FirebaseFirestore.getInstance()
    private var usuario: FirebaseAuth = FirebaseAuth.getInstance()
    val comidas = storage.collection("comidas")

    fun fillComidas(){
//        comidas.document().set(hashMapOf("nombre" to "Pollo con brocoli"))
        comidas.document().set(hashMapOf("nombre" to "Caldo de papa"))
        comidas.document().set(hashMapOf("nombre" to "Lentejas"))
        comidas.document().set(hashMapOf("nombre" to "Pasta Alfredo"))
        comidas.document().set(hashMapOf("nombre" to "Albondigas"))
        comidas.document().set(hashMapOf("nombre" to "Enchiladas"))
        comidas.document().set(hashMapOf("nombre" to "Chile Relleno"))
        comidas.document().set(hashMapOf("nombre" to "Crema con Champiñones"))
    }

    fun getComidas() : Task<QuerySnapshot> {
        return comidas.get()
    }

    fun test() {
        getComidas().addOnSuccessListener { result ->
            for(document in result) {
                Log.d(ContentValues.TAG, "${document.id} => ${document.data}")
            }
        }.addOnFailureListener { exception ->
                Log.d(ContentValues.TAG, "Error getting documents: ", exception)
        }
    }
}