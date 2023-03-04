package com.rongc.feature.toolbar

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import com.rongc.feature.toolbar.databinding.PsnToolbarBinding
import kotlin.reflect.KClass

/**
 * @description 全局标题栏
 * @author rongc
 * @date 20-8-24$
 * @update
 */
class PsnToolbar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), IToolBar {

    lateinit var binding: PsnToolbarBinding
    val toolbarConfig = MutableLiveData<ToolbarConfig>()

    init {
        if (isInEditMode) {
            LayoutInflater.from(context).inflate(R.layout.psn_toolbar, this, true)
        } else {
            binding = PsnToolbarBinding.inflate(LayoutInflater.from(context), this, true)
//            binding.ivBack.singleClick { viewModel.backClick() }
        }
    }

    override fun setBarConfig(barConfig: BarConfig) {
        super.setBarConfig(barConfig)
        toolbarConfig.value = barConfig.toolbarConfig
        binding.config = toolbarConfig
        addMenu(barConfig.toolbarConfig.menuItems)
    }

    private fun addMenu(menus: ArrayList<Pair<KClass<*>, MenuFunction<*>>>) {
        fun addItem(view: View) {
            binding.menuParent.addView(view, LayoutParams(-2, -1))
        }

        menus.forEach {
            @Suppress("UNCHECKED_CAST")
            val func = it.second as MenuFunction<View>
            val menu = it.first.java.getConstructor(Context::class.java)
                .newInstance(context) as View
            menu.apply(func)
            addItem(menu)
        }
    }

    override fun title(block: (TextView.() -> Unit)?) {
        block?.let { binding.tvTitle.apply(it) }
    }

    override fun navigation(block: (ImageView.() -> Unit)?) {
        block?.let { binding.ivBack.apply(it) }
    }

    fun <T : View> menuAt(index: Int = 0, block: T.() -> Unit) {
        post {
            binding.menuParent.getChildAt(index)?.let {
                @Suppress("UNCHECKED_CAST")
                block.invoke(it as T)
            }
        }
    }

    override fun setBackgroundColor(color: Int) {
        toolbar { background = color }
    }

    fun setBackPressedListener(listener: View.OnClickListener) {
        binding.ivBack.setOnClickListener(listener)
    }
}