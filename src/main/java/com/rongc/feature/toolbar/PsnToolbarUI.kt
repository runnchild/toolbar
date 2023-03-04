package com.rongc.feature.toolbar

//import androidx.core.view.updatePadding
import android.content.res.Resources
import android.view.View
import androidx.databinding.BindingAdapter

//import com.blankj.utilcode.util.BarUtils

@BindingAdapter("addStatusBarHeight")
fun View?.addPaddingTopEqualStatusBar(add: Boolean) {
    if (add) {
        this?.setPadding(paddingLeft, getStatusBarHeight(), paddingRight, paddingRight)
    }
}

private fun getStatusBarHeight(): Int {
    val resources = Resources.getSystem()
    val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
    return resources.getDimensionPixelSize(resourceId)
}
//@BindingAdapter("menus")
//fun ViewGroup.setMenus(items: ArrayList<TextView.() -> Unit>?) {
//    removeAllViews()
//    items?.forEach {
//        addItemMenu(it)
//    }
//}

//private fun ViewGroup.addItemMenu(item: TextView.() -> Unit) {
//    val menu = TextView(context).apply {
//        textSize = 16f
//        setTextColor(Color.parseColor("#353535"))
//        gravity = Gravity.CENTER
//        val padding = if (childCount > 0) {
//            7.idp
//        } else {
//            15.idp
//        }
//        setPadding(7.idp, 0, padding, 0)
//    }.apply(item)
//
//    addView(
//        menu, childCount - 1, FrameLayout.LayoutParams(-2, -1)
//    )
//}

//fun IAbilityList.toolbar(config: ToolbarConfig.() -> Unit) {
//    val toolbarAbility = findAbility { it is ToolbarAbility } as? ToolbarAbility
//    if (toolbarAbility == null) {
//        registerAbility(ToolbarAbility(this))
//    }
//    toolbarAbility?.toolBar?.toolbar(config)
//}
//
//fun IAbilityList.statusBar(config: StatusBarConfig.() -> Unit) {
//    val toolbarAbility = findAbility { it is ToolbarAbility } as? ToolbarAbility
//    if (toolbarAbility == null) {
//
//    }
//    toolbarAbility?.toolBar?.statusBar(config)
//}
@BindingAdapter("visible")
fun View.visible(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("orInvisible")
fun View.orInvisible(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.INVISIBLE
}

//fun PsnToolbar.config(config: BarConfig.()->Unit) {
//    setBarConfig(BarConfig().apply(config))
//}