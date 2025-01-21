package br.com.jonathanarodr.designsystem.component

import android.content.Context
import android.util.AttributeSet
import br.com.jonathanarodr.designsystem.base.BaseComponent
import br.com.jonathanarodr.designsystem.base.BaseComponentView.Companion.NO_DEF_STYLE
import br.com.jonathanarodr.designsystem.base.ComponentUiModel

enum class IndicatorType(val type: Int) {
    TAG(0),
    CHECKBOX(1),
}

data class CardUiModel(
    val title: String = "Lorem ipsum",
    val indicatorType: IndicatorType = IndicatorType.CHECKBOX,
    val tag: String = "v1",
    val isChecked: Boolean = true,
) : ComponentUiModel

// TODO WIP
class SampleCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = NO_DEF_STYLE,
) : BaseComponent(
    context = context,
    attrs = attrs,
    defStyleAttr = defStyleAttr,
)
