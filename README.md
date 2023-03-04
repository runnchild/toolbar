虽然[Future](https://github.com/runnchild/Feature)中已有toolbar库，但他还是依赖于future库。
这个库与其他完全隔离开来

![toolbar](https://github.com/runnchild/Feature/wiki/PsnToolbar/toobar.png)

![image](https://user-images.githubusercontent.com/13394690/222884503-587b09fd-885e-42da-a556-36f2f900078f.png)

1.添加依赖
>  根目录build.gradle添加jitpack仓库

```
buildscript {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
```
implementation "com.github.runnchild:toolbar:$latest_version"
```
2.在页面xml中添加PsnToolbar

```
<com.rongc.feature.toolbar.PsnToolbar
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```
```
toolBar.setConfig {
    toolbar {
      // 更改返回键图标
      toolbarBackDrawable = R.mipmap.common_icon_back.drawable()
      // 返回键显示状态
      // toolbarBackVisible = false
      // 页面标题，默认会使用Activity的Title
      title = "UserRepository"
      // 右上角菜单按钮，可添加多个
      addMenu<TextView> {
          // 闭包的this为TextView，可当此菜单为TextView做的相关设置
          text = "more"
          setOnClickListener {
              findNavController().navigate(R.id.demo_dialog)
          }
      }
      addMenu<ImageView> {
         updatePadding(left = 10.idp, right = 10.idp)
         setImageResource(R.mipmap.message_search_icon)
      }
      // 设置toolbar背景颜色
      toolBarBackground = Color.BLUE
      // toolbar底部分割线颜色
      toolBarDividerColor = Color.RED
  }
  
  statusBar {
      // 虚拟导航栏颜色
      navColor = Color.BLUE
      // 沉浸且状态栏icon黑色
      // statusBarState = BarConfig.TRANSPARENT_BLACK
      // 沉浸且状态栏icon白色
      // statusBarState = BarConfig.TRANSPARENT_WHITE
      // 设置状态栏颜色 和 statusBarState对立
      statusColor = Color.BLUE
  }
}
```

更多[Future](https://github.com/runnchild/Feature)
