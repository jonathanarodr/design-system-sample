package br.com.jonathanarodr.designsystem

import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf

enum class Theme {
    Light,
    Dark,
    Unspecified,
}

@Stable
data class DesignSystemTheme(
    val theme: Theme = Theme.Unspecified,
)

val DesignSystemTheme.isDarkMode: Boolean
    get() = theme == Theme.Dark

val LocalDesignSystemTheme = compositionLocalOf {
    mutableStateOf(DesignSystemTheme())
}
