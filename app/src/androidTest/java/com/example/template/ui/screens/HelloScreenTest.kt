package com.example.template.ui.screens

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.template.data.entities.Post
import com.example.template.ui.theming.MainTheme
import com.example.template.ui.viewmodel.HelloUiState
import org.junit.Rule
import org.junit.Test

class HelloScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun test() {
        val posts = listOf(Post(id = 1, title = "Hello World", body = "Hello World"))
        val uiState = HelloUiState(posts)

        with(composeTestRule) {
            setContent {
                MainTheme({ activity }) {
                    HelloScreen(uiState)
                }
            }

            onNodeWithText(text = "Hello World")
                .assertExists()
                .assertIsDisplayed()
        }
    }
}