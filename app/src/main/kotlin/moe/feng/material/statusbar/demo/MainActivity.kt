package moe.feng.material.statusbar.demo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

import moe.feng.material.statusbar.AppBarLayout
import moe.feng.material.statusbar.TranslucentSBActivity

public class MainActivity : TranslucentSBActivity() {

    var mAppBarLayout : AppBarLayout? = null

    override public fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAppBarLayout = findViewById(R.id.appbar_layout) as AppBarLayout
        setSupportActionBar(findViewById(R.id.toolbar) as Toolbar)

        findViewById(R.id.button_blue).setOnClickListener({
            mAppBarLayout?.setColor(
                    getResources().getColor(R.color.blue_500),
                    getResources().getColor(R.color.blue_700)
            )
        })

        findViewById(R.id.button_deep_purple).setOnClickListener({
            mAppBarLayout?.setColor(
                    getResources().getColor(R.color.deep_purple_500),
                    getResources().getColor(R.color.deep_purple_700)
            )
        })
    }

}