package br.com.jonathanarodr.designsystem.core.tokens

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class CustomColorScheme(
    val primary: Color,
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onSurface: Color,
    val surfaceBright: Color,
)

// Primitives
internal object PaletteTokens {

    val White: Color = Color(0xFFFFFFFF)
    val Black: Color = Color(0xFF000000)

    val Purple80: Color = Color(0xFFD0BCFF)
    val PurpleGrey80: Color = Color(0xFFCCC2DC)
    val Pink80: Color = Color(0xFFEFB8C8)

    val Purple40: Color = Color(0xFF8f00e7)
    val PurpleGrey40: Color = Color(0xFF625b71)
    val Pink40: Color = Color(0xFF7D5260)
}

internal object LightColorTokens {

    val Primary = PaletteTokens.Purple80

    val Background = PaletteTokens.White

    val OnBackground = PaletteTokens.PurpleGrey80

    val Surface = PaletteTokens.Pink80

    val OnSurface = PaletteTokens.Pink80

    val SurfaceBright = PaletteTokens.Purple80
}

internal object DarkColorTokens {

    val Primary = PaletteTokens.Purple40

    val Background = PaletteTokens.Black

    val OnBackground = PaletteTokens.PurpleGrey40

    val Surface = PaletteTokens.Pink40

    val OnSurface = PaletteTokens.Pink40

    val SurfaceBright = PaletteTokens.Purple40
}

// i.e. Gold theme
fun customLightColorScheme(
    primary: Color = LightColorTokens.Primary,
    background: Color = LightColorTokens.Background,
    onBackground: Color = LightColorTokens.OnBackground,
    surface: Color = LightColorTokens.Surface,
    onSurface: Color = LightColorTokens.OnSurface,
    surfaceBright: Color = LightColorTokens.SurfaceBright,
) = CustomColorScheme(
    primary = primary,
    background = background,
    onBackground = onBackground,
    surface = surface,
    onSurface = onSurface,
    surfaceBright = surfaceBright,
)

// i.e. Epic theme
fun customDarkColorScheme(
    primary: Color = DarkColorTokens.Primary,
    background: Color = DarkColorTokens.Background,
    onBackground: Color = DarkColorTokens.OnBackground,
    surface: Color = DarkColorTokens.Surface,
    onSurface: Color = DarkColorTokens.OnSurface,
    surfaceBright: Color = DarkColorTokens.SurfaceBright,
) = CustomColorScheme(
    primary = primary,
    background = background,
    onBackground = onBackground,
    surface = surface,
    onSurface = onSurface,
    surfaceBright = surfaceBright,
)

object ColorScheme {

    val LightColorScheme = customLightColorScheme()

    val DarkColorScheme = customDarkColorScheme()
}

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
