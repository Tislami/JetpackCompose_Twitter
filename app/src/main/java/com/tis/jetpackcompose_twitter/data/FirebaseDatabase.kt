package com.tis.jetpackcompose_twitter.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseDatabase {
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    val auth : FirebaseAuth = FirebaseAuth.getInstance()

    val userCollection: CollectionReference = firestore.collection("users")
    val postCollection: CollectionReference = firestore.collection("posts")



}