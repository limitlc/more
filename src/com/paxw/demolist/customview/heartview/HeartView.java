package com.paxw.demolist.customview.heartview;

import android.content.Context;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class HeartView extends SurfaceView implements SurfaceHolder.Callback,Runnable {

	boolean mbloop = false;

	SurfaceHolder mSurfaceHolder = null;

	private Canvas canvas;

	int miCount = 0;

	int y = 50;

	/**
	 * @param context
	 */

	public HeartView(Context context) {

		super(context);

		mSurfaceHolder = this.getHolder();

		mSurfaceHolder.addCallback(this);
		//FIXME 这两个方法是干什么的

		this.setFocusable(true);

		this.setKeepScreenOn(true);

		

	}
	/**
	 * surfaceholder.callback 的回调方法
	 */

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,int height) {
		Log.e("heart", "---------surfaceChanged------------");
	}
	
	/**
	 * surfaceholder.callback 的回调方法;
	 */
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		Log.e("heart", "---------surfaceCreated------------");
		mbloop = true;
		new Thread(this).start();

	}
	
	/**
	 * surfaceholder.callback 的回调方法;
	 */
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		Log.e("heart", "---------surfaceDestroyed------------");
		mbloop = false;
	}

	/**
	 * {@link Runnable}
	 * 多线程要求实现的的接口的实现方法
	 * 
	 */
	@Override
	public void run() {

		// TODO Auto-generated method stub

		while (mbloop) {

			try {

				Thread.sleep(200);

			} catch (Exception e) {

				// TODO: handle exception

			}

			synchronized (mSurfaceHolder) {

				Draw();

			}

		}

	}

	/**
	 * 
	 * @Description:
	 * @author chuang.li
	 * @date 2015-11-3 下午2:17:33
	 * @pramas null
	 * 
	 */
	private void Draw() {
		
		// TODO Auto-generated method stub
		canvas = mSurfaceHolder.lockCanvas();
		try {
			if (mSurfaceHolder == null || canvas == null) {
				return;
			}
			if (miCount < 100) {
				miCount++;
			} else {
				miCount = 0;
			}
			Paint paint = new Paint();
			paint.setAntiAlias(true);
			paint.setColor(Color.BLACK);
			paint.setStrokeWidth(5);
			canvas.drawRect(0, 0, 320, 480, paint);
			switch (miCount % 6) {
			case 0:
				paint.setColor(Color.BLUE);
				break;
			case 1:
				paint.setColor(Color.GREEN);
				break;
			case 2:
				paint.setColor(Color.RED);
				break;
			case 3:
				paint.setColor(Color.YELLOW);
				break;
			case 4:
				paint.setColor(Color.argb(255, 255, 181, 216));
				break;
			case 5:
				paint.setColor(Color.argb(255, 0, 255, 255));
				break;
			default:
				paint.setColor(Color.WHITE);
				break;
			}
			int  j;
			double x, y;
			double tempmin=0,tempmax=0;
			double i=0;
			for (j = 0; j <= 9000; j++) {
				x = Math.cos(Math.PI / 45 * j/100f);
				y= Math.sin(Math.PI / 45 * j/100f)+ Math.pow(Math.cos(Math.PI / 45 *j/100f)*Math.cos(Math.PI / 45 * j/100f), 1/(3d));
				if (y<tempmin) {
					tempmin =y;
				}
				if (y>tempmax) {
					tempmax =y;
					i=x;
				}
				canvas.drawPoint((float) (x*200+220), (float) (-y*200+400), paint);
			}
			paint.setTextSize(32);
			paint.setTypeface(Typeface.create(Typeface.SERIF, Typeface.ITALIC));
			RectF rect = new RectF(60, 400, 260, 405);
			canvas.drawRoundRect(rect, (float) 1.0, (float) 1.0, paint);
			canvas.drawText("Loving You", 75, 400, paint);
			mSurfaceHolder.unlockCanvasAndPost(canvas);
		} catch (Exception e) {

		}

	}
	BitmapRegionDecoder brd ;
}