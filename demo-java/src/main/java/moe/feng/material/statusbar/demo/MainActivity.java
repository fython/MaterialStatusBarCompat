package moe.feng.material.statusbar.demo;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import moe.feng.material.statusbar.AppBarLayout;
import moe.feng.material.statusbar.TranslucentSBActivity;

public class MainActivity extends TranslucentSBActivity {

	private AppBarLayout mAppBarLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mAppBarLayout = (AppBarLayout) findViewById(R.id.appbar_layout);
		setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

		findViewById(R.id.button_blue).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				mAppBarLayout.setColorResources(R.color.blue_500, R.color.blue_700);
			}
		});

		findViewById(R.id.button_deep_purple).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				mAppBarLayout.setColorResources(R.color.deep_purple_500, R.color.deep_purple_700);
			}
		});
	}

}
