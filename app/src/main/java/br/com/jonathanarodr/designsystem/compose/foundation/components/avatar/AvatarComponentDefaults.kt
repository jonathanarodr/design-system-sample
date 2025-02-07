package br.com.jonathanarodr.designsystem.compose.foundation.components.avatar

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.jonathanarodr.designsystem.compose.core.base.ComponentDefaults
import br.com.jonathanarodr.designsystem.compose.core.base.ComponentStyle
import br.com.jonathanarodr.designsystem.compose.core.theme.CustomTheme
import br.com.jonathanarodr.designsystem.compose.core.tokens.SpacingTokens

@Immutable
data class AvatarComponentStyle(
    val shapeType: Shape,
    val shapeColor: Color,
    val shapeSize: Dp,
) : ComponentStyle

object AvatarComponentDefaults : ComponentDefaults {

    @Composable
    override fun defaultStyle() = AvatarComponentStyle(
        shapeType = RoundedCornerShape(SpacingTokens.Level3),
        shapeColor = CustomTheme.colorScheme.surface,
        shapeSize = 80.dp,
    )

    @Composable
    fun highlightStyle(): AvatarComponentStyle = defaultStyle().copy(
        shapeType = CircleShape,
        shapeColor = CustomTheme.colorScheme.surfaceBright,
    )
}
