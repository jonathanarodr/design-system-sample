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

    val Purple: Color = Color(0xFF7F52FF)

    val Blue80: Color = Color(0xFFaac7ff)
    val Blue40: Color = Color(0xFF415f91)

    val Gray801: Color = Color(0xFFededf4)
    val Gray802: Color = Color(0xFFf3f3fa)
    val Gray803: Color = Color(0xFFf9f9ff)

    val Gray401: Color = Color(0xFF0c0e13)
    val Gray402: Color = Color(0xFF111318)
    val Gray403: Color = Color(0xFF1d2024)

}

internal object LightColorTokens {

    val Primary = PaletteTokens.Blue80

    val Background = PaletteTokens.White

    val OnBackground = PaletteTokens.Gray801

    val Surface = PaletteTokens.Gray802

    val OnSurface = PaletteTokens.Gray803

    val SurfaceBright = PaletteTokens.Gray401
}

internal object DarkColorTokens {

    val Primary = PaletteTokens.Blue40

    val Background = PaletteTokens.Black

    val OnBackground = PaletteTokens.Gray401

    val Surface = PaletteTokens.Gray402

    val OnSurface = PaletteTokens.Gray403

    val SurfaceBright = PaletteTokens.Gray801
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
