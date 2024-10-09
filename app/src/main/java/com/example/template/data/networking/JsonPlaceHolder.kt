package com.example.template.data.networking

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

val jsonPlaceHolderClient = HttpClient(OkHttp) {
    defaultRequest {
        url("https://jsonplaceholder.typicode.com")
    }

    install(ContentNegotiation) {
        json(json = Json { ignoreUnknownKeys = true })
    }
}