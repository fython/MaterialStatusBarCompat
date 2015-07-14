package moe.feng.material.statusbar

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.LinearLayout
import moe.feng.material.statusbar.R
import moe.feng.material.statusbar.StatusBarHeaderView
import moe.feng.material.statusbar.util.ViewHelper

open public class AppBarLayout : LinearLayout {

    private var colorNormal : Int
    private var colorDark : Int
    private var enableMode : Int

    private var headerView: StatusBarHeaderView

    final var MODE_KITKAT = 1 ; final var MODE_LOLLIPOP = 2 ; final var MODE_ALL = 3

    public constructor(context: Context) : this(context, null) {
    }

    public constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
    }

    public constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        var a = context.obtainStyledAttributes(attrs, R.styleable.StatusBarHeaderView, defStyle,
                R.style.Widget_FengMoe_StatusBarHeaderView)
        colorNormal = a.getColor(R.styleable.StatusBarHeaderView_colorNormal, Color.TRANSPARENT)
        if (a.hasValue(R.styleable.StatusBarHeaderView_colorDark)) {
            colorDark = a.getColor(R.styleable.StatusBarHeaderView_colorDark, Color.TRANSPARENT)
        } else {
            colorDark = ViewHelper().getMiddleColor(colorNormal, Color.BLACK, 0.2f)
        }
        enableMode = a.getInt(R.styleable.StatusBarHeaderView_enableMode, MODE_KITKAT or MODE_LOLLIPOP)
        headerView = StatusBarHeaderView(context, colorNormal, colorDark, enableMode)
        this.setBackgroundColorWithoutAlpha(colorNormal)
        this.setOrientation(LinearLayout.VERTICAL)
        this.addView(headerView)
        a.recycle()
        if (Build.VERSION.SDK_INT >= 21) {
            this.setElevation(ViewHelper().dpToPx(context, 5f))
        }
    }

    public fun setNormalColor(colorNormal: Int) {
        this.colorNormal = colorNormal
        this.setBackgroundColorWithoutAlpha(colorNormal)
        headerView.setNormalColor(colorNormal)
        headerView.init()
    }

    public fun setDarkColor(colorDark: Int) {
        this.colorDark = colorDark
        headerView.setDarkColor(colorDark)
        headerView.init()
    }

    public fun setColor(colorNormal: Int, colorDark: Int) {
        this.colorNormal = colorNormal
        this.colorDark = colorDark
        this.setBackgroundColorWithoutAlpha(colorNormal)
        headerView.setNormalColor(colorNormal)
        headerView.setDarkColor(colorDark)
        headerView.init()
    }

    public fun getNormalColor(): Int {
        return this.colorNormal
    }

    public fun getDarkColor(): Int {
        return this.colorDark
    }

    public fun setMode(mode: Int) {
        this.enableMode = mode
        headerView.setMode(mode)
        headerView.init()
    }

    public fun getMode(): Int {
        return this.enableMode
    }

    private fun setBackgroundColorWithoutAlpha(color: Int) {
        this.setBackgroundColor(Color.argb(255, Color.red(color), Color.green(color), Color.blue(color)))
    }

}
