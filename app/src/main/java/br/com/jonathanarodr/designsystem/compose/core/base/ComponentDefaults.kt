package br.com.jonathanarodr.designsystem.compose.core.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.StableMarker

@StableMarker
interface ComponentStyle

@StableMarker
interface ComponentDefaults {

    @Composable
    fun defaultStyle(): ComponentStyle
}
