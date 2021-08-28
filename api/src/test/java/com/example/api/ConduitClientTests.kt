package com.example.api

import com.example.api.models.entities.UserRegisterCreds
import com.example.api.models.requests.SignUpRequest
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import kotlin.random.Random

class ConduitClientTests {

    private val conduitClient = ConduitClient()

    @Test
    fun `Get articles`() {
        runBlocking {
            val articles = conduitClient.api.getArticles()
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `Get articles by author`() {
        runBlocking {
            val articles = conduitClient.api.getArticles(author = "444")
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `Get articles by tags`() {
        runBlocking {
            val articles = conduitClient.api.getArticles(tag = "dragons")
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `Post users - create user`() {
        val userCreds = UserRegisterCreds(
            email = "testemail${Random.nextInt(999, 9999)}@test.com",
            password = "pass${Random.nextInt(9999, 99999)}",
            username = "rand_user_${Random.nextInt(99, 999)}"
        )
        runBlocking {
            val resp = conduitClient.api.signUpUser(SignUpRequest(userCreds))
            assertEquals(userCreds.username, resp.body()?.user?.username)
        }
    }
}