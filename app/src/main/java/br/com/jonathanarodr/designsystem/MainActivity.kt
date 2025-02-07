package br.com.jonathanarodr.designsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DarkMode
import androidx.compose.material.icons.rounded.LightMode
import androidx.compose.material3.Icon
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import br.com.jonathanarodr.designsystem.compose.core.theme.CustomTheme
import br.com.jonathanarodr.designsystem.compose.core.theme.DesignSystemTheme
import br.com.jonathanarodr.designsystem.compose.core.theme.LocalDesignSystemTheme
import br.com.jonathanarodr.designsystem.compose.core.theme.Theme
import br.com.jonathanarodr.designsystem.compose.core.theme.isDarkMode
import br.com.jonathanarodr.designsystem.compose.core.tokens.SpacingTokens
import br.com.jonathanarodr.designsystem.compose.foundation.components.card.SampleCardComponent
import br.com.jonathanarodr.designsystem.compose.foundation.components.card.SampleCardComponentDefaults

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CustomTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Surface(
                        Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .consumeWindowInsets(innerPadding)
                    ) {
                        MainScreen(
                            modifier = Modifier
                                .background(CustomTheme.colorScheme.background)
                                .padding(SpacingTokens.Level4)
                        )
                    }
                }
            }
        }
    }
}

data class DarkModeState(
    val index: Int,
    val label: String,
    val icon: ImageVector,
    val isEnabled: Boolean,
)

@Composable
fun DarkModeButton(
    modifier: Modifier = Modifier,
) {
    val currentTheme = LocalDesignSystemTheme.current

    val options = listOf(
        DarkModeState(0, "Light", Icons.Rounded.LightMode, !currentTheme.value.isDarkMode),
        DarkModeState(1, "Dark", Icons.Rounded.DarkMode, currentTheme.value.isDarkMode),
    )

    Row(modifier = modifier) {
        MultiChoiceSegmentedButtonRow {
            options.forEachIndexed { index, option ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(
                        index = index,
                        count = options.size,
                    ),
                    icon = {
                        SegmentedButtonDefaults.Icon(active = option.isEnabled) {
                            Icon(
                                imageVector = option.icon,
                                contentDescription = null,
                                modifier = Modifier.size(SegmentedButtonDefaults.IconSize)
                            )
                        }
                    },
                    onCheckedChange = {
                        currentTheme.value = if (index == 0) {
                            DesignSystemTheme(theme = Theme.Light)
                        } else {
                            DesignSystemTheme(theme = Theme.Dark)
                        }
                    },
                    checked = option.isEnabled
                ) {
                    Text(option.label)
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
    ) {
        item {
            DarkModeButton()
        }
        item {
            Spacer(Modifier.height(SpacingTokens.Level5))
        }
        item {
            SampleCardComponent(
                illustration = R.drawable.kodee_hello,
                title = "Kodee Hello",
                description = "Mussum Ipsum, cacilds vidis litro abertis.",
                label = "Let's go"
            )
        }
        item {
            Spacer(Modifier.height(SpacingTokens.Level4))
        }
        item {
            SampleCardComponent(
                style = SampleCardComponentDefaults.highlightStyle(),
                illustration = R.drawable.kodee_wink,
                title = "Kodee Wink",
                description = "Lorem Ipsum is simply dummy text of the printing.",
                label = "Let's go",
            )
        }
        item {
            Spacer(Modifier.height(SpacingTokens.Level4))
        }
        item {
            SampleCardComponent(
                illustration = R.drawable.kodee_jumping,
                title = "Kodee Jumping",
                description = "Mussum Ipsum, cacilds vidis litro abertis.",
                label = "Let's go"
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun MainScreenPreview() {
    CustomTheme {
        MainScreen(
            modifier = Modifier
                .fillMaxWidth()
                .padding(SpacingTokens.Level4)
        )
    }
}
