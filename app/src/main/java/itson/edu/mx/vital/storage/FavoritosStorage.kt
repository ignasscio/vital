package itson.edu.mx.vital.storage

import android.content.ContentValues.TAG
import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class FavoritosStorage {
    private var storage: FirebaseFirestore = FirebaseFirestore.getInstance()
    private var usuario: FirebaseAuth = FirebaseAuth.getInstance()
    val favoritos = storage.collection("favoritos")

//    fun fillFavoritos(){
////        favoritos.document().set(hashMapOf("nombre" to "cereza"))
//        favoritos.document().set(hashMapOf("nombre" to "banana"))
//        favoritos.document().set(hashMapOf("nombre" to "durazno"))
//        favoritos.document().set(hashMapOf("nombre" to "fresa"))
//        favoritos.document().set(hashMapOf("nombre" to "manzana"))
//        favoritos.document().set(hashMapOf("nombre" to "moras"))
//        favoritos.document().set(hashMapOf("nombre" to "naranja"))
//        favoritos.document().set(hashMapOf("nombre" to "pera"))
//        favoritos.document().set(hashMapOf("nombre" to "piña"))
//        favoritos.document().set(hashMapOf("nombre" to "sandia"))
//        favoritos.document().set(hashMapOf("nombre" to "uvas"))
//        favoritos.document().set(hashMapOf("nombre" to "zarzamora"))
//    }

    fun test(){
        favoritos.get().addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }
    }

    fun getFavoritos (): Task<QuerySnapshot> {
        return favoritos.get()
    }
}