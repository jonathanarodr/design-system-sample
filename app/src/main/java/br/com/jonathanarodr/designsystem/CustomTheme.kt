package br.com.jonathanarodr.designsystem

import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

@ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
fun supportsDynamicTheming() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

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
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val currentTheme = getCurrentTheme()
    val themeState = remember { mutableStateOf(currentTheme) }

    val colorScheme = when {
        dynamicColor && supportsDynamicTheming() -> {
            val context = LocalContext.current
            if (themeState.value.isDarkMode) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        themeState.value.isDarkMode -> ColorScheme.DarkColorScheme
        else -> ColorScheme.LightColorScheme
    }

    CompositionLocalProvider(
        LocalDesignSystemTheme provides themeState,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}

object CustomTheme {

    val theme: DesignSystemTheme
        @Composable
        @ReadOnlyComposable
        get() = LocalDesignSystemTheme.current.value
}
