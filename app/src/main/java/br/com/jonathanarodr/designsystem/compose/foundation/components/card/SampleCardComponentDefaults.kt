package br.com.jonathanarodr.designsystem.compose.foundation.components.card

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.jonathanarodr.designsystem.compose.core.base.ComponentDefaults
import br.com.jonathanarodr.designsystem.compose.core.base.ComponentStyle
import br.com.jonathanarodr.designsystem.compose.core.theme.CustomTheme
import br.com.jonathanarodr.designsystem.compose.core.tokens.ColorPaletteTokens
import br.com.jonathanarodr.designsystem.compose.foundation.components.avatar.AvatarComponentDefaults
import br.com.jonathanarodr.designsystem.compose.foundation.components.avatar.AvatarComponentStyle

@Immutable
data class SampleCardComponentStyle(
    val cardColor: Color,
    val cardBorderWidth: Dp,
    val cardBorderColor: Color,
    val textColor: Color,
    val buttonColor: Color,
    val avatarStyle: AvatarComponentStyle,
) : ComponentStyle

object SampleCardComponentDefaults : ComponentDefaults {

    @Composable
    override fun defaultStyle() = SampleCardComponentStyle(
        cardColor = CustomTheme.colorScheme.background,
        cardBorderWidth = 1.dp,
        cardBorderColor = ColorPaletteTokens.Gray403,
        textColor = CustomTheme.colorScheme.surfaceBright,
        buttonColor = CustomTheme.colorScheme.primary,
        avatarStyle = AvatarComponentDefaults.defaultStyle(),
    )

    @Composable
    fun highlightStyle(): SampleCardComponentStyle = defaultStyle().copy(
        cardColor = ColorPaletteTokens.Purple,
        avatarStyle = AvatarComponentDefaults.highlightStyle(),
    )
}
