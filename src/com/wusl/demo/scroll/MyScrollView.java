package com.wusl.demo.scroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.Scroller;

public class MyScrollView extends LinearLayout {

	public MyScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	Scroller scroller = new Scroller(getContext());

	public void computeScroll() {
		if (scroller.computeScrollOffset()) {
			scrollTo(scroller.getCurrX(), scroller.getCurrY());
			postInvalidate();
		}
	}

	/**
	 * 缓慢滚动到指定位置
	 * 
	 * @param destX
	 * @param destY
	 */
	private void smoothScrollTo(int destX, int destY) {
		System.out.println("destX******" + destX + "********destY***********"
				+ destY);
		int scrollY = getScrollY();
		int delta = destX - scrollY;
		System.out.println("scrollY***********" + scrollY
				+ "********delta********" + delta);
		scroller.startScroll(0, scrollY, 0, delta, 1000);
		invalidate();
	}

	private int lastX, lastY;
	private int off;

	public boolean onTouchEvent(MotionEvent event) {
		int x = (int) event.getX();
		int y = (int) event.getY();
		int offset = lastY - y;
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			lastX = x;
			lastY = y;
			break;
		case MotionEvent.ACTION_UP:
			lastY = 0;
//			off = getScrollY();
			scroller.startScroll(0, getScrollY(), 0, -getScrollY(), 500);
//			invalidate();
			postInvalidate();
			break;
		case MotionEvent.ACTION_MOVE:
			scrollTo(0, off + offset);
			break;
		}
		return true;
	}
}
