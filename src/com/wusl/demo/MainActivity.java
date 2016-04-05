package com.wusl.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.wusl.demo.InnerScrollView.OnScrollChangedListener;

public class MainActivity extends Activity {
	TitleView v;
	InnerScrollView s;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		v = (TitleView) findViewById(R.id.true_title);
		s = (InnerScrollView) findViewById(R.id.scrollView);
		s.setOnScrollChangedListener(new OnScrollChangedListener() {
			public void onScrollChange(int l, int t, int oldl, int oldt) {
				int height = ((LinearLayout) s.getChildAt(0)).getChildAt(0)
						.getHeight();
				if (oldt >= height) {
					v.setVisibility(View.VISIBLE);
				} else {
					v.setVisibility(View.GONE);
				}
			}
		});
	}
}
