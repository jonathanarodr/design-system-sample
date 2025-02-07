package br.com.jonathanarodr.designsystem.components.avatar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import br.com.jonathanarodr.designsystem.R
import br.com.jonathanarodr.designsystem.core.theme.CustomTheme
import br.com.jonathanarodr.designsystem.core.tokens.SpacingTokens

// TODO: Avaliar estratégia de defaults por contexto de customização
// customizacao menos opinativa possibilitando customizações diferentes a guideline, porem evitavel com guardrail
@Composable
fun AvatarComponent(
    modifier: Modifier = Modifier,
    shapeSize: Dp = AvatarComponentDefaults.Default.shapeSize,
    shapeType: Shape = AvatarComponentDefaults.Default.shapeType,
    shapeColor: Color = AvatarComponentDefaults.Default.shapeColor,
    @DrawableRes illustration: Int,
) {
    Box(
        modifier = modifier
            .size(shapeSize)
            .clip(shapeType)
            .background(shapeColor),
    ) {
        Image(
            painter = painterResource(id = illustration),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
        )
    }
}

// TODO: Avaliar estratégia de defaults por estilo padrao, mais opinativo seguindo a guideline
@Composable
fun AvatarComponent2(
    modifier: Modifier = Modifier,
    style: AvatarComponentStyle = AvatarComponentDefaultsV2.defaultStyle(),
    @DrawableRes illustration: Int,
) {
    AvatarComponent(
        modifier = modifier,
        shapeSize = style.shapeSize,
        shapeType = style.shapeType,
        shapeColor = style.shapeColor,
        illustration = illustration,
    )
}

@Preview(showBackground = true)
@Composable
private fun AvatarComponentPreview() {
    CustomTheme {
        Column {
            AvatarComponent(
                modifier = Modifier.padding(SpacingTokens.Level2),
                shapeSize = AvatarComponentDefaults.Default.shapeSize,
                illustration = R.drawable.kodee_wink,
            )
            AvatarComponent2(
                modifier = Modifier.padding(SpacingTokens.Level2),
                style = AvatarComponentDefaultsV2.highlightStyle(),
                illustration = R.drawable.kodee_wink,
            )
        }
    }
}
