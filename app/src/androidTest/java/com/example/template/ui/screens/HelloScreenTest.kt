package com.example.template.ui.screens

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.template.ui.theming.MainTheme
import org.junit.Rule
import org.junit.Test

class HelloScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun test() {
        with(composeTestRule) {
            setContent {
                MainTheme({ activity }) {
                    HelloScreen()
                }
            }

            onNodeWithText(text = "Hello World")
                .assertExists()
                .assertIsDisplayed()
        }
    }
}