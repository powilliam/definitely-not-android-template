package com.example.template.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.template.data.entities.Post
import com.example.template.data.repository.PostsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class HelloUiState(val posts: List<Post> = emptyList())

class HelloViewModel(private val posts: PostsRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(HelloUiState())
    val uiState: StateFlow<HelloUiState> = _uiState

    fun onView() = viewModelScope.launch {
        try {
            val all = posts.all()
            _uiState.update { it.copy(posts = all) }
        } catch (_: Exception) {
        }
    }
}