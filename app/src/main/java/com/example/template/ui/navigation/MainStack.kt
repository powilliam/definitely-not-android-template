package com.example.template.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.template.ui.screens.Hello
import com.example.template.ui.screens.HelloScreen
import com.example.template.ui.viewmodel.HelloViewModel
import org.koin.androidx.compose.navigation.koinNavViewModel

@Composable
fun MainStack() {
    val controller = rememberNavController()

    NavHost(controller, startDestination = Hello) {
        composable<Hello> {
            val viewModel = koinNavViewModel<HelloViewModel>()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()

            LaunchedEffect(Unit) {
                viewModel.onView()
            }

            HelloScreen(uiState)
        }
    }
}