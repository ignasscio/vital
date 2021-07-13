package itson.edu.mx.vital.storage

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class PerfilStorage {
    private var storage: FirebaseFirestore = FirebaseFirestore.getInstance()
    private var usuario: FirebaseAuth = FirebaseAuth.getInstance()
    val perfiles = storage.collection("perfiles")
}