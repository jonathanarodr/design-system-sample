package br.com.jonathanarodr.designsystem.component

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.Log
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isGone
import androidx.core.view.isVisible
import br.com.jonathanarodr.designsystem.R
import br.com.jonathanarodr.designsystem.base.BaseComponentView

class SampleCardViewV1 @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = NO_DEF_STYLE,
) : BaseComponentView<LinearLayout>(
    context = context,
    attrs = attrs,
    defStyleAttr = defStyleAttr,
) {

    private lateinit var titleView: TextView
    private lateinit var labelView: TextView
    private lateinit var checkboxView: CheckBox

    override fun getComponentLayout(): ComponentLayout = ComponentLayout(
        layout = R.layout.sample_card_v1,
        attrs = R.styleable.SampleCard,
    )

    override fun onComponentCreate(component: LinearLayout): LinearLayout {
        Log.e("jon", "View: onComponentCreate")
        return super.onComponentCreate(component)
    }

    override fun onComponentCreated(component: LinearLayout, typedArray: TypedArray) {
        super.onComponentCreated(component, typedArray)

        titleView = findViewById(R.id.card_title)
        labelView = findViewById(R.id.card_tag)
        checkboxView = findViewById(R.id.card_checkbox)

        titleView.text = ""
        labelView.isGone = true
        checkboxView.isGone = true

        // update component
        titleView.text = typedArray.getString(R.styleable.SampleCard_title)

        when (typedArray.getInt(R.styleable.SampleCard_indicator, -1)) {
            0 -> {
                labelView.isVisible = true
                labelView.text = typedArray.getString(R.styleable.SampleCard_tagLabel)
            }

            1 -> {
                checkboxView.isVisible = true
                checkboxView.isChecked = typedArray.getBoolean(R.styleable.SampleCard_isChecked, false)
            }

            else -> throw IllegalArgumentException("SampleCard indicator must be either 0 or 1")
        }
    }
}
