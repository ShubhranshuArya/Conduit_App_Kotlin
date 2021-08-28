package com.example.api.services

import com.example.api.models.requests.LoginRequest
import com.example.api.models.requests.SignUpRequest
import com.example.api.models.responses.ArticleResponse
import com.example.api.models.responses.ArticlesResponse
import com.example.api.models.responses.TagsResponse
import com.example.api.models.responses.UserResponse
import jdk.nashorn.internal.objects.annotations.Getter
import retrofit2.Response
import retrofit2.http.*

interface ConduitApi {

    @POST("users")
    suspend fun signUpUser(
        @Body userCreds: SignUpRequest
    ): Response<UserResponse>

    @POST("users")
    suspend fun logInUser(
        @Body userCreds: LoginRequest
    ): Response<UserResponse>

    @GET("articles")
    suspend fun getArticles(
        @Query("author") author: String? = null,
        @Query("favourited") favourited: String? = null,
        @Query("tags") tag: String? = null,
    ): Response<ArticlesResponse>

    @GET("articles/{slug}")
    suspend fun getArticleBySlug(
        @Path("slug") slug: String
    ): Response<ArticleResponse>

    @GET("tags")
    suspend fun getTags(): Response<TagsResponse>



}