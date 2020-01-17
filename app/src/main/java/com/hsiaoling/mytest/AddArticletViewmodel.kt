package com.hsiaoling.mytest

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.*
import com.hsiaoling.mytest.FireBase
import com.hsiaoling.mytest.FireBase.articles


class AddArticletViewmodel:ViewModel() {



    val new_article_title = MutableLiveData<String>()
    val new_article_author = MutableLiveData<String>()
    val new_article_author_email = MutableLiveData<String>()
    val new_article_author_id = MutableLiveData<String>()
    val new_article_author_name = MutableLiveData<String>()
    val new_article_content = MutableLiveData<String>()
    val new_article_tag = MutableLiveData<String>()
    val new_article_time = MutableLiveData<String>()



    fun addArticle(){

        val articleOnFirebase = FirebaseFirestore.getInstance().collection("articleOnFirebase")


        val addArticle = AddArticle(
            article_author = new_article_author.value,
            article_author_email = new_article_author_email.value,
            article_author_id = new_article_author_id.value,
            article_author_name = new_article_author_name.value,
            article_title = new_article_title.value,
            article_tag = new_article_tag.value,
            article_create_time = new_article_time.value
            )

        articleOnFirebase
            .document()
            .set(addArticle)
            .addOnCompleteListener {
        }
            .addOnFailureListener { e -> Log.w(TAG, "Error adding document", e) }

    }



}