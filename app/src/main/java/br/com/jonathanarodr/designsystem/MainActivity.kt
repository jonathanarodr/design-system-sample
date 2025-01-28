package br.com.jonathanarodr.designsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.rounded.DarkMode
import androidx.compose.material.icons.rounded.LightMode
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CustomTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .consumeWindowInsets(innerPadding)
                    ) {
                        MainScreen(
                            modifier = Modifier.padding(SpacingScheme.ScreenSpacing)
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
fun SampleCard(
    @DrawableRes illustration: Int,
    title: String,
    description: String,
    modifier: Modifier = Modifier,
) {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(1.dp, Color.Gray),
        modifier = modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = illustration),
                contentDescription = null,
                modifier = Modifier.size(80.dp),
            )
            Text(
                text = title,
                fontFamily = MaterialTheme.typography.headlineLarge.fontFamily,
                textAlign = TextAlign.Center,
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = description,
                fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
            )
            Spacer(Modifier.height(8.dp))
            Button(
                onClick = { },
                shape = ShapeDefaults.ExtraLarge,
            ) {
                Text(
                    text = "Label",
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(16.dp)
                )
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
            Spacer(Modifier.height(80.dp))
        }
        item {
            SampleCard(
                illustration = R.drawable.kodee_hello,
                title = "Kodee Hello",
                description = "Mussum Ipsum, cacilds vidis litro abertis."
            )
        }
        item {
            Spacer(Modifier.height(24.dp))
        }
        item {
            SampleCard(
                illustration = R.drawable.kodee_wink,
                title = "Kodee Wink",
                description = "Lorem Ipsum is simply dummy text of the printing.",
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
                .padding(SpacingScheme.ContentSpacing)
        )
    }
}
