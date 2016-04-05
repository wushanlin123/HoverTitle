package com.wusl.demo;

import com.wusl.demo.InnerScrollView.OnScrollChangedListener;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

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
				System.out.println(l + "******" + oldt);
				// int height = dip2px(MainActivity.this, 300);
				int height = ((LinearLayout) s.getChildAt(0)).getChildAt(0)
						.getHeight();
				System.out.println("height-----" + height);
				if (oldt >= height) {
					v.setVisibility(View.VISIBLE);
				} else {
					v.setVisibility(View.GONE);
				}
			}
		});
	}

	/**
	 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
	 */
	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}
}
