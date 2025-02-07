package br.com.jonathanarodr.designsystem.compose.core.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf

// Manager app theme (i.e. Gold, Epic, Pj)
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
