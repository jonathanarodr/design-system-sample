package br.com.jonathanarodr.designsystem.components.avatar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import br.com.jonathanarodr.designsystem.core.theme.ComponentDefaults
import br.com.jonathanarodr.designsystem.core.theme.ComponentStyle

// Define default style for this component
sealed interface AvatarComponentDefaults : ComponentDefaults {

    @get:Composable
    val shapeType: Shape

    @get:Composable
    val shapeColor: Color

    @get:Composable
    val shapeSize: Dp

    data object Default : AvatarComponentDefaults {

        override val shapeType: Shape
            @Composable get() = AvatarComponentTokens.shapeSquare

        override val shapeColor: Color
            @Composable get() = AvatarComponentTokens.shapeColorDefault

        override val shapeSize: Dp
            @Composable get() = AvatarComponentTokens.shapeSizeMedium
    }

    data object Highlight : AvatarComponentDefaults {

        override val style: ComponentStyle
            get() = ComponentStyle.HighLight

        override val shapeType: Shape
            @Composable get() = AvatarComponentTokens.shapeCircle

        override val shapeColor: Color
            @Composable get() = AvatarComponentTokens.shapeColorHighlight

        override val shapeSize: Dp
            @Composable get() = AvatarComponentTokens.shapeSizeMedium
    }
}

/**
 * Defines todas as configurações default possiveis do componente semelhante ao que temos no Figma
 */
@Immutable
data class AvatarComponentStyle(
    val key: ComponentStyle,
    val shapeType: Shape,
    val shapeColor: Color,
    val shapeSize: Dp,
)

// FIXME: Como padronizar implementacao de styles, atualmente nao temos uma convencao padrao
object AvatarComponentDefaultsV2 : ComponentDefaults {

    @Composable
    fun defaultStyle(): AvatarComponentStyle = AvatarComponentStyle(
        key = ComponentStyle.Default,
        shapeType = AvatarComponentTokens.shapeSquare,
        shapeColor = AvatarComponentTokens.shapeColorDefault,
        shapeSize = AvatarComponentTokens.shapeSizeMedium,
    )

    @Composable
    fun highlightStyle(): AvatarComponentStyle = defaultStyle().copy(
        key = ComponentStyle.HighLight,
        shapeType = AvatarComponentTokens.shapeCircle,
        shapeColor = AvatarComponentTokens.shapeColorHighlight
    )

    @Composable
    fun neutralStyle(): AvatarComponentStyle = defaultStyle().copy(
        key = ComponentStyle.Neutral,
        shapeColor = AvatarComponentTokens.shapeColorDefault,
    )
}
