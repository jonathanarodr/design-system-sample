package br.com.jonathanarodr.designsystem

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// Primitives
internal object SpacingTokens {

    val Level1: Dp = 4.dp
    val Level2: Dp = 8.dp
    val Level3: Dp = 16.dp
    val Level4: Dp = 24.dp
    val Level5: Dp = 80.dp
}

// Semantics
object SpacingScheme {

    val ScreenSpacing: Dp = SpacingTokens.Level3
    val ContentSpacing: Dp = SpacingTokens.Level4
}
