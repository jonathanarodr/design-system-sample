package br.com.jonathanarodr.designsystem.compose.core.tokens

import androidx.compose.ui.graphics.Color

internal object DarkColorTokens {

    val Primary = ColorPaletteTokens.Blue40

    val Background = ColorPaletteTokens.Black

    val OnBackground = ColorPaletteTokens.Gray401

    val Surface = ColorPaletteTokens.Gray402

    val OnSurface = ColorPaletteTokens.Gray403

    val SurfaceBright = ColorPaletteTokens.Gray801
}

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
