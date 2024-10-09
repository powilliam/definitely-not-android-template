package com.example.template.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class Post(val id: Int, val title: String, val body: String)
