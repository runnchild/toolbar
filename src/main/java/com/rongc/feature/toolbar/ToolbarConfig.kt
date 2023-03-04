package com.rongc.feature.toolbar

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.core.graphics.ColorUtils
import kotlin.reflect.KClass

/**
 * <p>
 * describe:
 *
 * </p>
 * @author qiurong
 * @date 2021/8/7
 */
typealias MenuFunction<T> = T.() -> Unit

class ToolbarConfig {
    /**
     * toolbar标题
     */
    var title: CharSequence? = null

    /**
     * 标题明亮模式颜色（深色）
     */
    @ColorInt
    var titleLightModeColor: Int = Color.BLACK

    @ColorInt
    var titleDarkModeColor: Int = Color.WHITE

    /**
     * 标题颜色（浅色）
     */
    @ColorInt
    var _titleColor = titleDarkModeColor

    /**
     * 返回键明亮模式颜色（深色）
     */
    @ColorInt
    var iconLightModeColor: Int = Color.BLACK

    @ColorInt
    var iconColor = Color.WHITE

    /**
     * toolbar显示状态
     */
    var toolbarVisible = true

    /**
     * 标题显示状态
     */
    var titleVisible = true

    val menuItems = arrayListOf<Pair<KClass<*>, MenuFunction<*>>>()

    var titleBlock: (TextView.() -> Unit)? = null
    var navigationBlock: (ImageView.() -> Unit)? = null

    /**
     * 是否时明亮模式（背景亮色）
     */
    var isLightMode = true

    /**
     * toolbar背景色
     */
    @ColorInt
    var background = 0
        set(value) {
            isLightMode = ColorUtils.calculateLuminance(value) > 0.5f
            field = value
        }

    /**
     * toolbar分割线颜色
     */
    @ColorInt
    var bottomLineColor = 0

    /**
     * toolbar返回按钮显示状态
     */
    var navigationVisible = true

    /**
     * toolbar返回按钮图标
     */
    lateinit var navigationIcon: Drawable

    var addStatusBarHeight = false

    /**
     * 右上角菜单配置
     */
    inline fun <reified T : View> addMenu(noinline menu: MenuFunction<T>) {
        menuItems.add(T::class to menu)
    }

    fun title(block: TextView.() -> Unit) {
        titleBlock = block
    }

    fun navigation(block: ImageView.() -> Unit) {
        navigationBlock = block
    }
}