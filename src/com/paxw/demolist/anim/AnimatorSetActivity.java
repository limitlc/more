package com.paxw.demolist.anim;



import com.paxw.demolist.R;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class AnimatorSetActivity extends Activity
{
	private ImageView mBlueBall;
	private LinearLayout tab;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.anim_set);
		tab = (LinearLayout) findViewById(R.id.linearlayout_route_tab);
		mBlueBall = (ImageView) findViewById(R.id.id_ball);

	}

	public void togetherRun(View view)
	{
//		ObjectAnimator anim1 = ObjectAnimator.ofFloat(mBlueBall, "scaleX",
//				1.0f, 2f);
//		ObjectAnimator anim2 = ObjectAnimator.ofFloat(mBlueBall, "scaleY",
//				1.0f, 2f);
//		
//		AnimatorSet animSet = new AnimatorSet();
//		animSet.setDuration(2000);
//		animSet.setInterpolator(new LinearInterpolator());
//		//两个动画同时执行
//		animSet.playTogether(anim1, anim2);
////		animSet.playSequentially(items)
//		animSet.start();
		
		tab.removeAllViews();
		tab.setVisibility(View.VISIBLE);
		int height = 56;
		LinearLayout.LayoutParams mLl = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height);
		mLl.weight = 1.0f;
		for (int i = 0; i < 3; i++) {
			View tabView = LayoutInflater.from(this).inflate(R.layout.view_route_tab_item, null);
			tabView.setLayoutParams(mLl);
			tabView.setTag(tabView.getId(), i);
			tab.addView(tabView);
			
			
			
		}
	}

	public void playWithAfter(View view)
	{
		float cx = mBlueBall.getX();

		ObjectAnimator anim1 = ObjectAnimator.ofFloat(mBlueBall, "scaleX",
				1.0f, 2f);
		ObjectAnimator anim2 = ObjectAnimator.ofFloat(mBlueBall, "scaleY",
				1.0f, 2f);
		ObjectAnimator anim3 = ObjectAnimator.ofFloat(mBlueBall,
				"x",  cx ,  0f);
		ObjectAnimator anim4 = ObjectAnimator.ofFloat(mBlueBall,
				"x", cx);
		
		/**
		 * anim1，anim2,anim3同时执行
		 * anim4接着执行
		 */
		AnimatorSet animSet = new AnimatorSet();
		animSet.play(anim1).with(anim2);
		animSet.play(anim2).with(anim3);
		animSet.play(anim4).after(anim3);
		animSet.setDuration(1000);
		animSet.start();
	}
}
