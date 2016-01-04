package com.paxw.demolist.canvas;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;

import android.view.View;

@SuppressLint("DrawAllocation")
public class CanvasActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new CustomView1(this));
		
		sendMsg();
	}
	private void sendMsg(){
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(8);
		newFixedThreadPool.execute(new Runnable() {
			
			@Override
			public void run() {
				
				
				
				
				
				
				
			}
		});
		
		
		
		
	}
	private void harassHim(){
		//网络请求
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	弧线(arcs)、填充颜色(argb和color)、 Bitmap、圆(circle和oval)、点(point)、线(line)、矩形(Rect)、图片(Picture)、圆角矩形 (RoundRect)、文本(text)、顶点(Vertices)、路径(path)。
	class CustomView1 extends View{    
        Paint paint;    
        public CustomView1(Context context) {    

            super(context);    

            paint = new Paint(); //设置一个笔刷大小是3的黄色的画笔    

            paint.setColor(Color.YELLOW);    

            paint.setStrokeJoin(Paint.Join.ROUND);    

            paint.setStrokeCap(Paint.Cap.ROUND);    

            paint.setStrokeWidth(3);    

        }    

          

        //在这里我们将测试canvas提供的绘制图形方法    

        @SuppressWarnings("deprecation")
		@Override    

        protected void onDraw(Canvas canvas) {    

          canvas.drawCircle(100, 100, 100, paint);
          RectF rectF = new RectF(0, 200, 200, 400);
          paint.setColor(Color.RED);
          canvas.drawArc(rectF, 0, 120, true, paint);
          paint.setColor(Color.BLACK);
          canvas.drawLine(0, 400, 200, 600, paint);
          rectF = new RectF(0, 600, 200, 1000);
          paint.setColor(Color.BLUE);
          canvas.drawOval(rectF, paint);
          //按照既定点 绘制文本内容    
          paint.setColor(Color.GREEN);
          paint.setTextSize(40);
          canvas.drawPosText("Android777", new float[]{    

                  20,20, //第一个字母在坐标10,10    

                  40,40, //第二个字母在坐标20,20    

                  60,60, //....    

                  80,80,    

                  100,100,    

                  120,120,    

                  140,140,    

                  160,160,    

                  180,180,    

                  200,200    

          }, paint);    
          canvas.drawRect(new RectF(20, 1000, 200, 1100), paint);
          canvas.drawRoundRect(new RectF(20, 1200, 200, 1300), 50, 50, paint);
          paint.setColor(Color.RED);
          Path  path = new Path();
          canvas.drawPath(path, paint);
          //还是画布比较好玩
        }   
        
        

    }    
	
}
