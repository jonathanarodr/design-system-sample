package br.com.jonathanarodr.designsystem.compose.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import br.com.jonathanarodr.designsystem.compose.core.tokens.ColorScheme
import br.com.jonathanarodr.designsystem.compose.core.tokens.CustomColorScheme
import br.com.jonathanarodr.designsystem.compose.core.tokens.CustomTypography
import br.com.jonathanarodr.designsystem.compose.core.tokens.LocalColorScheme
import br.com.jonathanarodr.designsystem.compose.core.tokens.LocalTypography
import br.com.jonathanarodr.designsystem.compose.core.tokens.TypographyDefaults

@Composable
fun getCurrentTheme(): DesignSystemTheme {
    val theme = if (isSystemInDarkTheme()) {
        Theme.Dark
    } else {
        Theme.Light
    }

    return DesignSystemTheme(theme = theme)
}

@Composable
fun CustomTheme(
    content: @Composable () -> Unit,
) {
    val currentTheme = getCurrentTheme()
    val themeState = remember { mutableStateOf(currentTheme) }

    val colorScheme = when (themeState.value.theme) {
        Theme.Light -> ColorScheme.LightColorScheme
        Theme.Dark -> ColorScheme.DarkColorScheme
        Theme.Unspecified -> error("Unspecified theme")
    }

    CompositionLocalProvider(
        LocalDesignSystemTheme provides themeState,
        LocalColorScheme provides colorScheme,
        LocalTypography provides TypographyDefaults,
        content = content,
    )
}

object CustomTheme {

    val theme: DesignSystemTheme
        @Composable
        @ReadOnlyComposable
        get() = LocalDesignSystemTheme.current.value

    val colorScheme: CustomColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalColorScheme.current

    val typography: CustomTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}
