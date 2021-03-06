package com.example.api.models.requests


import com.example.api.models.entities.UserRegisterCreds
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SignUpRequest(
    @Json(name = "user")
    val user: UserRegisterCreds
)