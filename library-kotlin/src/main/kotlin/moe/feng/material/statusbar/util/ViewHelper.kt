package moe.feng.material.statusbar.util

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.util.TypedValue

class ViewHelper {

    fun isChrome(): Boolean {
        return Build.BRAND == "chromium" || Build.BRAND == "chrome"
    }

    fun getStatusBarHeight(context: Context): Int {
        var result = 0
        val resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId)
        }
        return result
    }

    private fun getMiddleValue(prev: Int, next: Int, factor: Float): Int{
        return Math.round(prev + (next - prev) * factor);
    }

    fun getMiddleColor(prevColor: Int, curColor: Int, factor: Float): Int {
        if (prevColor == curColor) {
            return curColor
        };

        if (factor == 0f) {
            return prevColor;
        } else if(factor == 1f) {
            return curColor;
        }

        var a = getMiddleValue(Color.alpha(prevColor), Color.alpha(curColor), factor)
        var r = getMiddleValue(Color.red(prevColor), Color.red(curColor), factor)
        var g = getMiddleValue(Color.green(prevColor), Color.green(curColor), factor)
        var b = getMiddleValue(Color.blue(prevColor), Color.blue(curColor), factor)

        return Color.argb(a, r, g, b);
    }

    fun getColor(baseColor: Int, alphaPercent: Float): Int{
        var alpha = Math.round(Color.alpha(baseColor) * alphaPercent)

        return (baseColor and 0x00FFFFFF) or (alpha shl 24)
    }

    fun dpToPx(context: Context, dp: Float) : Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics()) + 0.5f;
    }

}
