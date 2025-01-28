package br.com.jonathanarodr.designsystem

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// Primitives
internal object ColorTokens {

    val Purple80: Color = Color(0xFFD0BCFF)
    val PurpleGrey80: Color = Color(0xFFCCC2DC)
    val Pink80: Color = Color(0xFFEFB8C8)

    val Purple40: Color = Color(0xFF8f00e7)
    val PurpleGrey40: Color = Color(0xFF625b71)
    val Pink40: Color = Color(0xFF7D5260)
}

// Semantics
object ColorScheme {

    val LightColorScheme = lightColorScheme(
        primary = ColorTokens.Purple40,
        secondary = ColorTokens.PurpleGrey40,
        tertiary = ColorTokens.Pink40,
    )

    val DarkColorScheme = darkColorScheme(
        primary = ColorTokens.Purple80,
        secondary = ColorTokens.PurpleGrey80,
        tertiary = ColorTokens.Pink80,
    )
}
