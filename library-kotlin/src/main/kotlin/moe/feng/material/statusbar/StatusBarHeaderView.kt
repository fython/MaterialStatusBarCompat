package moe.feng.material.statusbar

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.util.AttributeSet
import android.view.View
import moe.feng.material.statusbar.util.ViewHelper

open public class StatusBarHeaderView : View {

    private var colorNormal : Int
    private var colorDark : Int
    private var enableMode : Int

    final var MODE_KITKAT = 1 ; final var MODE_LOLLIPOP = 2 ; final var MODE_ALL = 3

    public constructor(context: Context): this(context, null) {
    }

    public constructor(context: Context, attrs: AttributeSet?): this(context, attrs, 0) {
    }

    public constructor(context: Context, attrs: AttributeSet?, defStyle: Int): super(context, attrs, defStyle) {
        var a = context.obtainStyledAttributes(attrs, R.styleable.StatusBarHeaderView, defStyle,
                R.style.Widget_FengMoe_StatusBarHeaderView)
        colorNormal = a.getColor(R.styleable.StatusBarHeaderView_colorNormal, Color.TRANSPARENT)
        if (a.hasValue(R.styleable.StatusBarHeaderView_colorDark)) {
            colorDark = a.getColor(R.styleable.StatusBarHeaderView_colorDark, Color.TRANSPARENT)
        } else {
            colorDark = ViewHelper().getMiddleColor(colorNormal, Color.BLACK, 0.2f)
        }
        enableMode = a.getInt(R.styleable.StatusBarHeaderView_enableMode, MODE_KITKAT or MODE_LOLLIPOP)
        init()
        a.recycle()
    }

    public constructor(context: Context, colorNormal: Int, colorDark: Int, enableMode: Int): super(context) {
        this.colorNormal = colorNormal
        this.colorDark = colorDark
        this.enableMode = enableMode
        init()
    }

    override public fun onMeasure(widthSpec: Int, heightSpec: Int) {
        super.onMeasure(widthSpec, heightSpec)
        adjustHeight()
    }

    override public fun invalidate() {
        super.invalidate()
        adjustHeight()
    }

    public fun adjustHeight() {
        var params = getLayoutParams()
        params.height = ViewHelper().getStatusBarHeight(getContext())
    }

    fun init() {
        var SDK_INT = Build.VERSION.SDK_INT
        this.setBackgroundColor(if (SDK_INT == 19) colorNormal else colorDark)
        this.setVisibility(
                if (!ViewHelper().isChrome() and (
                        (
                                ((enableMode == MODE_KITKAT) and (SDK_INT == 19)) or
                                        ((enableMode == MODE_LOLLIPOP) and (SDK_INT == 21)) or
                                        ((enableMode == MODE_ALL) and (SDK_INT >= 19)))
                        )) View.VISIBLE else View.GONE
        )
    }

    public fun setNormalColor(colorNormal: Int) {
        this.colorNormal = colorNormal
        init()
    }

    public fun setDarkColor(colorDark: Int) {
        this.colorDark = colorDark
        init()
    }

    public fun getNormalColor(): Int {
        return this.colorNormal
    }

    public fun getDarkColor(): Int {
        return this.colorDark
    }

    public fun setMode(mode: Int) {
        this.enableMode = mode
        init()
    }

    public fun getMode(): Int {
        return this.enableMode
    }

}