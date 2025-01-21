package br.com.jonathanarodr.designsystem.base

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.LayoutRes
import androidx.annotation.StyleableRes
import androidx.core.content.withStyledAttributes
import androidx.core.view.children
import br.com.jonathanarodr.designsystem.base.BaseComponentView.Companion.NO_DEF_STYLE

interface BaseComponentSelector {

    fun select()
}

interface BaseComponentFactory<T : View> {

    fun inflate(context: Context, parent: ViewGroup): T
}

interface ComponentUiModel

abstract class BaseComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = NO_DEF_STYLE,
) : FrameLayout(context, attrs, defStyleAttr) {

    // TODO adicionar component factory e fazer selector de acordo com a flag
}

abstract class BaseComponentView<T : View> @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = NO_DEF_STYLE,
) : FrameLayout(context, attrs, defStyleAttr) {

    companion object {

        /**
         * An attribute in the current theme that contains a reference to a style resource
         * that supplies defaults values for the TypedArray. Can be 0 to not look for defaults
         */
        const val NO_DEF_STYLE = 0
    }

    inner class ComponentLayout(
        @LayoutRes
        val layout: Int,
        @StyleableRes
        val attrs: IntArray,
    )

    abstract fun getComponentLayout(): ComponentLayout

    /**
     * Lazy load the component view attached in the root context.
     */
    @Suppress("UNCHECKED_CAST")
    private val componentView: T by lazy {
        if (childCount == 0) {
            error("Component not yet attached to the window")
        } else {
            children.first() as T
        }
    }

    init {
        inflateComponent()
        parseCustomAttrs(attrs, defStyleAttr)
    }

    @Suppress("UNCHECKED_CAST")
    private fun inflateComponent(): T {
        Log.e("jon", "Base: inflateComponent")

        return (LayoutInflater.from(context).inflate(getComponentLayout().layout, this, true) as T).also {
            onComponentCreate(componentView)
        }
    }

    private fun parseCustomAttrs(attrs: AttributeSet?, defStyleAttr: Int) {
        Log.e("jon", "Base: parseCustomAttrs")

        context.withStyledAttributes(
            set = attrs,
            attrs = getComponentLayout().attrs,
            defStyleAttr = defStyleAttr,
        ) {
            onComponentCreated(componentView, this)
        }
    }

    fun refreshComponent() {
        if (isInLayout) {
            Log.e("jon", "Base: refreshComponent")
            invalidate()
            requestLayout()
        }
    }

    open fun onComponentCreate(component: T): T {
        Log.e("jon", "Base: onComponentCreate")
        return component
    }

    open fun onComponentCreated(component: T, typedArray: TypedArray) {
        Log.e("jon", "Base: onComponentCreated")
    }

    open fun onComponentUpdated(data: ComponentUiModel) {
        Log.e("jon", "Base: onComponentUpdated")
    }
}
