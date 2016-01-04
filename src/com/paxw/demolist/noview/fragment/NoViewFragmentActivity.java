package com.paxw.demolist.noview.fragment;


import com.paxw.demolist.R;
import com.paxw.demolist.banner.utils.GetBannerData;

import android.R.color;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.database.DataSetObserver;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.BounceInterpolator;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class NoViewFragmentActivity extends FragmentActivity {

    private NoViewFragment noViewFragment;
	private RelativeLayout relative;
	private GridView gridView;
	private int mScreenWidth;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        relative = (RelativeLayout) findViewById(R.id.banner_cont);
        gridView = new GridView(this);
        gridView.setNumColumns(4);
        DisplayMetrics outMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
		mScreenWidth = outMetrics.widthPixels;
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
//        layoutParams.width  = LayoutParams.MATCH_PARENT;
//        layoutParams.height = LayoutParams.MATCH_PARENT;
        relative.addView(gridView);
        new Thread(){
        	public void run() {
        		try {
					this.sleep(500l);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		runOnUiThread( new Runnable() {
					public void run() {
						gridView.setAdapter(new BaseAdapter() {
							
							@Override
							public View getView(int position, View convertView, ViewGroup parent) {
								final TextView text  = new TextView(NoViewFragmentActivity.this);
								android.widget.LinearLayout.LayoutParams layoutp = new android.widget.LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
								text.setGravity(Gravity.CENTER);
								text.setBackgroundColor(color.background_dark);
								text.setText(position+"");
								ValueAnimator animator = new ValueAnimator() ;
								switch (position%4) {
								case 0:
									animator.setObjectValues(new PointF(0, 0));
									break;
								case 1:
									animator.setObjectValues(new PointF(0, 0));
									break;
								case 2:
									animator.setObjectValues(new PointF(mScreenWidth+text.getWidth(), 0));
									break;
								case 3:
									animator.setObjectValues(new PointF(mScreenWidth+text.getWidth(), 0));
									break;
								
								}
								final int index = position;
								animator.setTarget(text);
								animator.setInterpolator(new BounceInterpolator());
								animator.setEvaluator(new TypeEvaluator<PointF>() {
									//fraction 是时间
									@Override
									public PointF evaluate(float fraction,
											PointF startValue, PointF endValue) {
										PointF point = new PointF();
										point.y = 0;
									
										point.x = 0.5f* (fraction) * (fraction);
								
										return point;
									}
								});
								animator.setDuration(2000).start();
								// animator.setInterpolator(value)
								animator.addUpdateListener(new AnimatorUpdateListener(){
									@Override
									public void onAnimationUpdate(ValueAnimator animation){
										PointF point = (PointF) animation.getAnimatedValue();
										switch (index%4) {
										case 0:
											text.setX((point.x/0.5f-1)*text.getWidth()*1);
											break;
										case 1:
											text.setX(point.x/0.5f*text.getWidth()*1);
											break;
										case 2:
											text.setX(text.getWidth()*3-(point.x/0.5f)*text.getWidth());
											break;
										case 3:
											text.setX(text.getWidth()*4-(point.x/0.5f)*text.getWidth());
											break;
										default:
											break;
										}
										text.setY(point.y);
									}
								});
								return text;
							}
							
							@Override
							public long getItemId(int position) {
								// TODO Auto-generated method stub
								return 0;
							}
							
							@Override
							public Object getItem(int position) {
								// TODO Auto-generated method stub
								return null;
							}
							
							@Override
							public int getCount() {
								// TODO Auto-generated method stub
								return 4;
							}
						});
					}
				});
        		
        		
        	};
        }.start();
        
    }




}
