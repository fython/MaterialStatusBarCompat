package moe.feng.material.statusbar

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

open public class TranslucentSBActivity: AppCompatActivity() {

    var needSetTranslucent = true; var isCreated = false;

    override protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (needSetTranslucent) StatusBarCompat().setUpActivity(this)
        isCreated = true
    }

    public fun setStatusBarTranslucent(needSetTranslucent: Boolean) {
        if (isCreated) {
            throw ShouldSetBeforeActivityCreatedException()
        } else {
            this.needSetTranslucent = needSetTranslucent;
        }
    }

    public class ShouldSetBeforeActivityCreatedException : Exception() {}

}