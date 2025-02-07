package br.com.jonathanarodr.designsystem.core.theme

import androidx.compose.runtime.StableMarker

// Required interface used to define default values for each component
@StableMarker
interface ComponentDefaults {

    val style: ComponentStyle
        get() = ComponentStyle.Default
}

@StableMarker
interface ComponentTokens

