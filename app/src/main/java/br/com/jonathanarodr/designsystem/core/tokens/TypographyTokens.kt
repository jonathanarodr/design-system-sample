package br.com.jonathanarodr.designsystem.core.tokens

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
data class CustomTypography(
    val title: TextStyle,
    val body: TextStyle,
    val label: TextStyle,
)

// Primitive
internal object TypographyTokens {
    val Title = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
    )

    val Body = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    )

    val Label = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
    )
}

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
