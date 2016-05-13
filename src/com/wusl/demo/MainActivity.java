package com.wusl.demo;

import com.wusl.demo.hover.HoverFragment;
import com.wusl.demo.scroll.ScrollFragment;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getFragmentManager().beginTransaction()
				.replace(R.id.content, 
//						new HoverFragment()
						new ScrollFragment()
				).commit();
	}
}
