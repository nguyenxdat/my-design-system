package com.datnx.my_design_system.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import com.datnx.design_system.theme.LocalTypo
import com.datnx.design_system.theme.customType

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFEEFF33),
    secondary = Color(0xFF625b71),
    tertiary = Color(0xFF7D5260),
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFEEFF33),
    onPrimary = Color(0xFF282828),
    secondary = Color(0xFF625b71),
    tertiary = Color(0xFF7D5260),
    background = Color(0xFFFEF7F7),
    surface = Color(0xFFFEF7F7),
    onBackground = Color(0xFF282828),
    onSurface = Color(0xFF282828)
)

@Composable
fun MyDesignSystemTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    CompositionLocalProvider(
        LocalTypo provides customType
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}