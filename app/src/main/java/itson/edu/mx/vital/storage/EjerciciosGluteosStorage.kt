package itson.edu.mx.vital.storage

import android.content.ContentValues
import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class EjerciciosGluteosStorage {
    private var storage: FirebaseFirestore = FirebaseFirestore.getInstance()
    private var usuario: FirebaseAuth = FirebaseAuth.getInstance()
    val ejerciciosGluteos = storage.collection("ejerciciosGluteos")

    fun fillEjercicios(){
//        ejerciciosGluteos.document().set(hashMapOf("nombre" to "Abducción"))
        ejerciciosGluteos.document().set(hashMapOf("nombre" to "Frog"))
        ejerciciosGluteos.document().set(hashMapOf("nombre" to "Patada"))
        ejerciciosGluteos.document().set(hashMapOf("nombre" to "Peso Muerto"))
        ejerciciosGluteos.document().set(hashMapOf("nombre" to "Sentadilla"))
        ejerciciosGluteos.document().set(hashMapOf("nombre" to "Puente"))
        ejerciciosGluteos.document().set(hashMapOf("nombre" to "Zancada"))
        ejerciciosGluteos.document().set(hashMapOf("nombre" to "Zancada Lateral"))
    }

    fun getEjercicios() : Task<QuerySnapshot> {
        return ejerciciosGluteos.get()
    }

    fun test() {
        getEjercicios().addOnSuccessListener { result ->
            for(document in result) {
                Log.d(ContentValues.TAG, "${document.id} => ${document.data}")
            }
        }.addOnFailureListener { exception ->
            Log.d(ContentValues.TAG, "Error getting documents: ", exception)
        }
    }

}