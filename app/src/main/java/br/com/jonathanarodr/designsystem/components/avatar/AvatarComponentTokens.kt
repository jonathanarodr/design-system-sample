package br.com.jonathanarodr.designsystem.components.avatar

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.jonathanarodr.designsystem.core.theme.ComponentTokens
import br.com.jonathanarodr.designsystem.core.theme.CustomTheme
import br.com.jonathanarodr.designsystem.core.tokens.SpacingTokens

// Mapping all available tokens for this component similar specified in Figma
internal object AvatarComponentTokens : ComponentTokens {

    val shapeCircle: Shape
        get() = CircleShape

    val shapeSquare: Shape
        get() = RoundedCornerShape(SpacingTokens.Level3)

    val shapeSizeSmall: Dp
        get() = 50.dp

    val shapeSizeMedium: Dp
        get() = 80.dp

    val shapeColorDefault: Color
        @Composable get() = CustomTheme.colorScheme.surface

    val shapeColorHighlight: Color
        @Composable get() = CustomTheme.colorScheme.surfaceBright
}
