package com.hsiaoling.mytest


enum class AddArticleIndex(val string: String){
    Title("article_title"),
    Author("article_author"),
    Tag("article_tag"),
    VreatedTime("article_created_time"),
    Content("article_content")
}

data class AddArticle(
    val article_author: String? = null,
    val article_author_email:String? = null,
    val article_author_id: String? = null,
    val article_author_name: String? = null,
    val article_title: String? = null,
    val article_content: String? = null,
    val article_create_time: String? = null,
    val article_tag: String? = null
     )