package br.com.jonathanarodr.designsystem.compose.core.tokens

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

object ColorScheme {

    val LightColorScheme = customLightColorScheme()

    val DarkColorScheme = customDarkColorScheme()
}

@Immutable
data class CustomColorScheme(
    val primary: Color,
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onSurface: Color,
    val surfaceBright: Color,
)

val LocalColorScheme = staticCompositionLocalOf {
    CustomColorScheme(
        primary = Color.Unspecified,
        background = Color.Unspecified,
        onBackground = Color.Unspecified,
        surface = Color.Unspecified,
        onSurface = Color.Unspecified,
        surfaceBright = Color.Unspecified,
    )
}
