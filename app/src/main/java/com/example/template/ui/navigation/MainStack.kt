package com.example.template.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.template.ui.screens.Hello
import com.example.template.ui.screens.HelloScreen

@Composable
fun MainStack() {
    val controller = rememberNavController()

    NavHost(controller, startDestination = Hello) {
        composable<Hello> { HelloScreen() }
    }
}