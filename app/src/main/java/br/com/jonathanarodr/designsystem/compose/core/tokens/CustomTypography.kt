package br.com.jonathanarodr.designsystem.compose.core.tokens

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle

@Immutable
data class CustomTypography(
    val title: TextStyle,
    val body: TextStyle,
    val label: TextStyle,
)

val TypographyDefaults = CustomTypography(
    title = TypographyTokens.Title,
    body = TypographyTokens.Body,
    label = TypographyTokens.Label,
)

val LocalTypography = staticCompositionLocalOf {
    CustomTypography(
        title = TextStyle.Default,
        body = TextStyle.Default,
        label = TextStyle.Default,
    )
}
