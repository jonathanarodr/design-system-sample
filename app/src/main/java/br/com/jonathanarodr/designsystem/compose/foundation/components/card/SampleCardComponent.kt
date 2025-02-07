package br.com.jonathanarodr.designsystem.compose.foundation.components.card

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.jonathanarodr.designsystem.R
import br.com.jonathanarodr.designsystem.compose.core.theme.CustomTheme
import br.com.jonathanarodr.designsystem.compose.core.tokens.SpacingTokens
import br.com.jonathanarodr.designsystem.compose.foundation.components.avatar.AvatarComponent

@Composable
fun SampleCardComponent(
    modifier: Modifier = Modifier,
    style: SampleCardComponentStyle = SampleCardComponentDefaults.defaultStyle(),
    @DrawableRes illustration: Int,
    title: String,
    description: String,
    label: String,
) {
    OutlinedCard(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = style.cardColor,
        ),
        border = BorderStroke(style.cardBorderWidth, style.cardBorderColor),
    ) {
        Column(
            modifier = Modifier
                .padding(SpacingTokens.Level3)
                .fillMaxWidth()
        ) {
            AvatarComponent(
                style = style.avatarStyle,
                illustration = illustration,
            )
            Spacer(Modifier.height(SpacingTokens.Level2))
            Text(
                text = title,
                color = style.textColor,
                style = CustomTheme.typography.title,
            )
            Spacer(Modifier.height(SpacingTokens.Level2))
            Text(
                text = description,
                color = style.textColor,
                style = CustomTheme.typography.body,
            )
            Spacer(Modifier.height(SpacingTokens.Level2))
            Button(
                colors = ButtonDefaults.buttonColors().copy(
                    containerColor = style.buttonColor,
                    contentColor = style.textColor,
                ),
                onClick = { },
            ) {
                Text(
                    text = label,
                    color = style.textColor,
                    style = CustomTheme.typography.label,
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                    tint = style.textColor,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = SpacingTokens.Level2)
                        .size(SpacingTokens.Level3)
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun SampleCardComponentPreview() {
    CustomTheme {
        Column {
            SampleCardComponent(
                modifier = Modifier.padding(SpacingTokens.Level2),
                style = SampleCardComponentDefaults.defaultStyle(),
                illustration = R.drawable.kodee_hello,
                title = "Kodee Hello",
                description = "Mussum Ipsum, cacilds vidis litro abertis.",
                label = "Let's go",
            )
            SampleCardComponent(
                modifier = Modifier.padding(SpacingTokens.Level2),
                style = SampleCardComponentDefaults.highlightStyle(),
                illustration = R.drawable.kodee_wink,
                title = "Kodee Wink",
                description = "Mussum Ipsum, cacilds vidis litro abertis.",
                label = "Let's go",
            )
        }
    }
}
