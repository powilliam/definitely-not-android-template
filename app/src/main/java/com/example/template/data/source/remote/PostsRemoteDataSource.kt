package com.example.template.data.source.remote

import com.example.template.data.entities.Post
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface PostsRemoteDataSource {
    suspend fun all(): List<Post>
}

class PostsRemoteDataSourceImpl(
    private val client: HttpClient
) : PostsRemoteDataSource {
    override suspend fun all() = withContext(Dispatchers.IO) {
        client.get("posts").body<List<Post>>()
    }
}