# MaterialStatusBarCompat
Easy to make status bar translucent/tint on both Kitkat and Lollipop
完美地使 Kitkat 与 Lollipop 上的状态栏同时透明/变色

第一个版本只有 Kotlin 版本，是作为 Hello, Kotlin! 的存在。
考虑到 Kotlin 在 Android 使用会增大安装包体积，稍后会推出 Java 版本。

Tips: It may not be compatibled with Android Support Design Library.
提示：不保证和 Android Support Design Library 兼容。（我也不打算兼容因为我很讨厌它很多奇葩问题）

### Usage 用法

##### Step 0 第一步

First, use `Theme.AppCompat.*.TranslucentStatusBar` instead of `Theme.AppCompat.*`
首先，采用 `Theme.AppCompat.*.TranslucentStatusBar` 主题代替 `Theme.AppCompat.*`


##### Step 1 第二步

Then, modify your Java/Kotlin code by these ways.
接着，根据这些方法修改你的 Java/Kotlin 中的 Activity 部分

Way 0 方法一:

Call `StatusBarCompat.setUpActivity(this)` before `setContentView()` in your activites
在你的 Activity 中调用 `setContentView()` 之前调用 `StatusBarCompat.setUpActivity(this)`

Java code:
```@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    StatusBarCompat.setUpActivity(this);
    setContentView(R.layout.activity_xxxxx);
}
```

Kotlin code:
```
override public fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    StatusBarCompat().setUpActivity(this)
    setContentView(R.layout.activity_xxxxx)
}
```

Way 1 方法二:

Use `TranslucentSBActivity` instead of `AppCompatActivity`
使用 `TranslucentSBActivity` 代替 `AppCompatActivity`

##### Step 2 第三步

Way 0 方法一：

Add `StatusBarHeaderView` above `Toolbar` in layout
在布局中添加 `StatusBarHeaderView` 到 `Toolbar` 上面

```<LinearLayout
    ...
    android:orientation="vertical"/>
        <moe.feng.material.statusbar.StatusBarHeaderView
            android:layout_height="0dp"
            android:layout_width="match_parent"
            app:colorNormal="@color/colorForKitkat"
            app:colorDark="@color/colorForLollipop"/>
        <android.support.v7.widget.Toolbar
            .../>
</LinearLayout>
```

Way 1 方法二:

Put `Toolbar` and other views which should be a part of appbar (Such as `TabLayout`) in `AppBarLayout`
将 `Toolbar` 和其他应当作为 App 顶栏一部分的 View (比如 Tab 栏) 放在 `AppBarLayout` 中

PS: AppBarLayout is based on a vertical LinearLayout（AppBarLayout 基于垂直方向的 LinearLayout）

```<moe.feng.material.statusbar.AppBarLayout
    ...
    app:colorNormal="@color/colorForKitkat"
    app:colorDark="@color/colorForLollipop"/>
        <android.support.v7.widget.Toolbar
            .../>
</LinearLayout>
```

##### Step 3 第三步

Finish! You also can change their color in Java/Kotlin code.
没有第三步了！你也可以在 Java/Kotlin 代码中随时更改它们的颜色。


### Contact me 联系我

Google Plus: +Fung Jichun
新浪微博: @某燒餅
我的 Android 开发交流群: 34725246

### 支持项目

Alipay 支付宝: 316643843@qq.com
