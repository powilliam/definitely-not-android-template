package com.example.template.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.template.ui.theming.MainTheme
import kotlinx.serialization.Serializable

@Serializable
object Hello

@Composable
fun HelloScreen() {
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "Hello World"
            )
        }
    }
}

@Preview
@Composable
private fun HelloScreenPreview() {
    val context = LocalContext.current

    MainTheme({ context }) {
        HelloScreen()
    }
}