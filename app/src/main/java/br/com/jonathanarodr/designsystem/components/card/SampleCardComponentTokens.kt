package br.com.jonathanarodr.designsystem.components.card

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.jonathanarodr.designsystem.core.theme.ComponentTokens
import br.com.jonathanarodr.designsystem.core.theme.CustomTheme
import br.com.jonathanarodr.designsystem.core.tokens.PaletteTokens

// Mapping all available tokens for this component similar specified in Figma
internal object SampleCardComponentTokens : ComponentTokens {

    val cardColorDefault: Color
        @Composable get() = CustomTheme.colorScheme.background

    val cardColorHighlight: Color
        @Composable get() = PaletteTokens.Purple

    val cardBorderWidth: Dp
        @Composable get() = 1.dp

    val cardBorderColor: Color
        @Composable get() = PaletteTokens.Gray403

    val textColor: Color
        @Composable get() = CustomTheme.colorScheme.surfaceBright

    val buttonColor: Color
        @Composable get() = CustomTheme.colorScheme.primary
}
