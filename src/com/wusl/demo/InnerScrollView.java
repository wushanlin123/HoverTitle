package com.wusl.demo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class InnerScrollView extends ScrollView {

	public InnerScrollView(Context context, AttributeSet attrs,
			int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
	}

	public InnerScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public InnerScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public InnerScrollView(Context context) {
		super(context);
	}

	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
		if (listener != null) {
			listener.onScrollChange(l, t, oldl, oldt);
		}
	}

	OnScrollChangedListener listener;

	public void setOnScrollChangedListener(OnScrollChangedListener listener) {
		this.listener = listener;
	}

	public interface OnScrollChangedListener {
		void onScrollChange(int l, int t, int oldl, int oldt);
	}

}
