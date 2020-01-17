package com.hsiaoling.mytest

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.annotation.NonNull
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.firestore.DocumentReference
import com.google.android.gms.tasks.OnSuccessListener
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.OnCompleteListener
import androidx.core.app.ComponentActivity.ExtraData
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hsiaoling.mytest.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding:FragmentActivity

    val new_article_title = MutableLiveData<String>()
    val new_article_author = MutableLiveData<String>()
    val new_article_author_email = MutableLiveData<String>()
    val new_article_author_id = MutableLiveData<String>()
    val new_article_author_name = MutableLiveData<String>()
    val new_article_content = MutableLiveData<String>()
    val new_article_tag = MutableLiveData<String>()


    val new_article_time = MutableLiveData<String>()
    private val _added = MutableLiveData<Boolean>()
    val added: LiveData<Boolean>
        get() = _added

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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentActivity()
        setContentView(R.layout.activity_main)

    }
        fun addArticle() {
            if (new_article_content.value == null ||
                new_article_content.value == "" ||
                new_article_title.value == null ||
                new_article_title.value == "" || new_article_tag.value == null
            ) {
                return
            }


            articleOnFirebase
                .document()
                .set(addArticle)
                .addOnCompleteListener {

                    if (it.isSuccessful) {
                        new_article_content.value = null
                        _added.value = true
                    } else {
                        Log.w(
                            ContentValues.TAG,
                            "addPost FAILED : ${it.exception?.localizedMessage}"
                        )
                    }

                }
                .addOnFailureListener { e -> Log.w(ContentValues.TAG, "Error adding document", e) }

        }

    




    //----------------------------------------------------------------------------------------------
//    fun addData(){
//
//    val articles = FirebaseFirestore.getInstance().collection("articles")
//    // Create a new user with a first and last name
//    val document = articles.document()
//
//    val data = hashSetOf(
//        "author" to hashMapOf(
//            "email" to "hsiao@gmail.com",
//            "id" to "hsiao01",
//            "name" to "HsiaoLing"
//        ),
//        "title" to "好冷的一天",
//        "content" to "今天氣溫17度",
//        "creatTime" to Calendar.getInstance().timeInMillis,
//        "id" to document.id,
//        "tag" to "Weather"
//    )
//        document.set(data)
//
//        articles.document().set(data).addOnCanceledListener {
//        }
//}



// READ
//        articles.collection("articles")
//            .get()
//            .addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    for (document in task.result!!) {
//                        Log.d(TAG, document.id + " => " + document.data)
//                    }
//                } else {
//                    Log.w(TAG, "Error getting documents.", task.exception)
//                }
//            }

    }

