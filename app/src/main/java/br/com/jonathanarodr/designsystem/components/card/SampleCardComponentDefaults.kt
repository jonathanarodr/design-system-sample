package br.com.jonathanarodr.designsystem.components.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import br.com.jonathanarodr.designsystem.components.avatar.AvatarComponentDefaultsV2
import br.com.jonathanarodr.designsystem.components.avatar.AvatarComponentStyle
import br.com.jonathanarodr.designsystem.core.theme.ComponentDefaults
import br.com.jonathanarodr.designsystem.core.theme.ComponentStyle

// Define default style for this component
sealed interface SampleCardComponentDefaults : ComponentDefaults {

    @get:Composable
    val cardContainerColor: Color

    val cardBorder: BorderStroke
        @Composable get() = BorderStroke(
            width = SampleCardComponentTokens.cardBorderWidth,
            color = SampleCardComponentTokens.cardBorderColor
        )

    val textColor: Color
        @Composable get() = SampleCardComponentTokens.textColor

    val buttonColor: Color
        @Composable get() = SampleCardComponentTokens.buttonColor

    val avatarStyle: AvatarComponentStyle
        @Composable get() = AvatarComponentDefaultsV2.defaultStyle()

    data object Default : SampleCardComponentDefaults {

        override val cardContainerColor: Color
            @Composable get() = SampleCardComponentTokens.cardColorDefault
    }

    data object HighLight : SampleCardComponentDefaults {

        override val style: ComponentStyle
            get() = ComponentStyle.HighLight

        override val cardContainerColor: Color
            @Composable get() = SampleCardComponentTokens.cardColorHighlight

        override val avatarStyle: AvatarComponentStyle
            @Composable get() = AvatarComponentDefaultsV2.highlightStyle()
    }
}
