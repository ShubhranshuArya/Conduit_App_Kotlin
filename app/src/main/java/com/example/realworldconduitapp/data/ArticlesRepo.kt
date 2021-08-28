package com.example.realworldconduitapp.data

import com.example.api.ConduitClient

object ArticlesRepo {

    val api = ConduitClient().api

    suspend fun getGloblaFeed() = api.getArticles()
}