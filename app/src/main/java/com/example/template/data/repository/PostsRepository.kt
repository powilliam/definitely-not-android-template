package com.example.template.data.repository

import com.example.template.data.entities.Post
import com.example.template.data.source.remote.PostsRemoteDataSource

interface PostsRepository {
    suspend fun all(): List<Post>
}

class PostsRepositoryImpl(
    private val dataSource: PostsRemoteDataSource
) : PostsRepository {
    override suspend fun all() = dataSource.all()
}