package br.com.jonathanarodr.designsystem.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.withStyledAttributes
import androidx.core.view.isGone
import androidx.core.view.isVisible
import br.com.jonathanarodr.designsystem.R
import com.google.android.material.card.MaterialCardView

class SampleCardViewV2 @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {

    private val titleView: TextView
    private val labelView: TextView
    private val checkboxView: CheckBox
    private val iconView: AppCompatImageView

    init {
        // init component
        LayoutInflater.from(context).inflate(R.layout.sample_card_v2, this, true)

        titleView = findViewById(R.id.card_title)
        labelView = findViewById(R.id.card_tag)
        checkboxView = findViewById(R.id.card_checkbox)
        iconView = findViewById(R.id.card_icon)

        // parse custom attrs & styles
        context.withStyledAttributes(
            set = attrs,
            attrs = R.styleable.SampleCard,
            defStyleAttr = defStyleAttr,
        ) {
            // reset component
            titleView.text = ""
            labelView.isGone = true
            checkboxView.isGone = true

            // update component
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

                2 -> {
                    iconView.isVisible = true
                }

                else -> throw IllegalArgumentException("SampleCard indicator must be either 0 or 1")
            }
        }
    }
}
