package br.com.jonathanarodr.designsystem.compose.core.tokens

import androidx.compose.ui.graphics.Color

internal object LightColorTokens {

    val Primary = ColorPaletteTokens.Blue80

    val Background = ColorPaletteTokens.White

    val OnBackground = ColorPaletteTokens.Gray801

    val Surface = ColorPaletteTokens.Gray802

    val OnSurface = ColorPaletteTokens.Gray803

    val SurfaceBright = ColorPaletteTokens.Gray401
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
