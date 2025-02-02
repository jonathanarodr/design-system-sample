package br.com.jonathanarodr.designsystem.base

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.appcompat.view.ContextThemeWrapper
import androidx.core.content.withStyledAttributes
import br.com.jonathanarodr.designsystem.R

private const val NoStyleDef = 0

object ComponentThemeOverlay {

    @Suppress("TooGenericExceptionCaught")
    @StyleRes
    private fun obtainMaterialThemeOverlayId(
        context: Context,
        attrs: AttributeSet?,
        @AttrRes defStyleAttr: Int,
    ): Int {
        val customThemeOverlayAttr = intArrayOf(R.attr.customThemeOverlay)
        var customThemeOverlayId = NoStyleDef

        return try {
            context.withStyledAttributes(
                set = attrs,
                attrs = customThemeOverlayAttr,
                defStyleAttr = defStyleAttr,
            ) {
                // todo test with zero
                customThemeOverlayId = getResourceId(0, 0)
            }

            customThemeOverlayId
        } catch (exception: Exception) {
            Log.e("ComponentThemeOverlay", "Failure to obtain customThemeOverlayId", exception)
            customThemeOverlayId
        }
    }

    fun wrap(
        context: Context,
        attrs: AttributeSet?,
        @AttrRes defStyleAttr: Int,
    ): Context {
        val customThemeOverlayId = obtainMaterialThemeOverlayId(context, attrs, defStyleAttr)

        // fixme check if is necessary when combine multiples components
        val contextHasOverlay = (context is ContextThemeWrapper) && (context.themeResId == customThemeOverlayId)

        if (customThemeOverlayId == 0 || contextHasOverlay) {
            return context
        }

        return ContextThemeWrapper(context, customThemeOverlayId)
    }
}
