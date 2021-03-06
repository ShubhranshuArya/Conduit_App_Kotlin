package com.example.api.models.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserUpdateCreds(
    @Json(name = "bio")
    val bio: String?,
    @Json(name = "email")
    val email: String,
    @Json(name = "image")
    val image: String?
)