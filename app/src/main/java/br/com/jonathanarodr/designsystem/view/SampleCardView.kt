package br.com.jonathanarodr.designsystem.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.withStyledAttributes
import androidx.core.view.isVisible
import br.com.jonathanarodr.designsystem.R

class SampleCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val titleView: TextView
    private val labelView: TextView
    private val checkboxView: CheckBox

    init {
        LayoutInflater.from(context).inflate(R.layout.sample_card_layout, this, true)

        titleView = findViewById(R.id.card_title)
        labelView = findViewById(R.id.card_tag)
        checkboxView = findViewById(R.id.card_checkbox)

        context.withStyledAttributes(
            set = attrs,
            attrs = R.styleable.SampleCard,
            defStyleAttr = defStyleAttr,
        ) {
            titleView.text = getString(R.styleable.SampleCard_title)

            when (getInt(R.styleable.SampleCard_indicator, -1)) {
                0 -> {
                    labelView.isVisible = true
                    labelView.text = getString(R.styleable.SampleCard_tagLabel)
                }

                1 -> {
                    checkboxView.isVisible = true
                    checkboxView.isChecked = getBoolean(R.styleable.SampleCard_isChecked, false)
                }

                else -> throw IllegalArgumentException("SampleCard indicator must be either 0 or 1")
            }
        }
    }
}
