package br.com.jonathanarodr.designsystem.compose.foundation.components.avatar

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.jonathanarodr.designsystem.R
import br.com.jonathanarodr.designsystem.compose.core.theme.CustomTheme
import br.com.jonathanarodr.designsystem.compose.core.tokens.SpacingTokens

@Composable
fun AvatarComponent(
    modifier: Modifier = Modifier,
    style: AvatarComponentStyle = AvatarComponentDefaults.defaultStyle(),
    @DrawableRes illustration: Int,
) {
    Box(
        modifier = modifier
            .size(style.shapeSize)
            .padding(SpacingTokens.Level1)
            .clip(style.shapeType)
            .background(style.shapeColor),
    ) {
        Image(
            painter = painterResource(id = illustration),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AvatarComponentPreview() {
    CustomTheme {
        Column {
            AvatarComponent(
                modifier = Modifier.padding(SpacingTokens.Level2),
                style = AvatarComponentDefaults.defaultStyle(),
                illustration = R.drawable.kodee_wink,
            )
            AvatarComponent(
                modifier = Modifier.padding(SpacingTokens.Level2),
                style = AvatarComponentDefaults.highlightStyle(),
                illustration = R.drawable.kodee_jumping,
            )
        }
    }
}
