package com.wusl.demo.hover;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.wusl.demo.R;
import com.wusl.demo.hover.InnerScrollView.OnScrollChangedListener;

public class HoverFragment extends Fragment{
	TitleView v;
	InnerScrollView s;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_hovertitle, null);
		
		v = (TitleView) view.findViewById(R.id.true_title);
		s = (InnerScrollView) view.findViewById(R.id.scrollView);
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
		return view;
	}
}
