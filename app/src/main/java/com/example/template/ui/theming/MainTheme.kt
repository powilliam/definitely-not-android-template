package com.example.template.ui.theming

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val isDarkModeSupported = Build.VERSION.SDK_INT >= Build.VERSION_CODES.R
private val isDynamicColorSchemeSupported = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

@SuppressLint("NewApi")
@Composable
fun MainTheme(
    context: () -> Context,
    isDarkModeEnabled: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val ctx = context()
    val colorScheme = when {
        isDarkModeEnabled and isDarkModeSupported and isDynamicColorSchemeSupported -> dynamicDarkColorScheme(
            ctx
        )

        isDarkModeEnabled and isDarkModeSupported and isDynamicColorSchemeSupported.not() -> darkColorScheme()
        isDarkModeEnabled.not() and isDynamicColorSchemeSupported -> dynamicLightColorScheme(ctx)
        else -> lightColorScheme()
    }

    MaterialTheme(colorScheme = colorScheme, content = content)
}