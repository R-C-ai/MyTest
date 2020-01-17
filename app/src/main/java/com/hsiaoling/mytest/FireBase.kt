package com.hsiaoling.mytest

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

object FireBase {

    val articles = FirebaseFirestore.getInstance().collection("articles")
    val document = articles.document()
    val auth = FirebaseAuth.getInstance()
    val user = "users"

}