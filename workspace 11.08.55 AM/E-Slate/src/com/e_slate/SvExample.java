package com.e_slate;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class SvExample extends Activity implements OnTouchListener {
	OurView v;
	Bitmap e,r;
	float x, y;
	int count =0;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		v = new OurView(this);
		v.setOnTouchListener(this);
		BitmapFactory.Options options = new BitmapFactory.Options();  
		options.inPreferredConfig = Bitmap.Config.ARGB_8888;
		e = BitmapFactory.decodeResource(getResources(), R.drawable .e1, options);
		r=BitmapFactory.decodeResource(getResources(), R.drawable.drawa,options);
		x = y = 0;
		setContentView(v);

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		v.pause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		v.resume();
	}

	class OurView extends SurfaceView implements Runnable {

		Thread t = null;
		SurfaceHolder holder;
		boolean ok = false;

		public OurView(Context context) {
			// TODO Auto-generted constructor stub
			super(context);
			holder = getHolder();
		}

		@Override
		public void run() {
			
			while (ok == true) {
				if (!holder.getSurface().isValid()) {
					continue;
				}
				Canvas c = holder.lockCanvas();

				c.drawBitmap(e, x -(e.getWidth()/2), y-(e.getHeight()/2) ,
						null);
				if(count==0){
				c.drawBitmap(r, 0, 0, null);}

				holder.unlockCanvasAndPost(c);

			}

		}

		public void pause() {
			ok = false;
			while (true) {
				try {
					t.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			t = null;
		}

		public void resume() {
			ok = true;
			t = new Thread(this);
			t.start();
			
		}
	}

	@Override
	public boolean onTouch(View vi, MotionEvent me) {
		count=1;
		// TODO Auto-generated method stub
		switch(me.getAction())
		{
		case MotionEvent.ACTION_DOWN :
			x=me.getX();
			y=me.getY();
			break;
		case MotionEvent.ACTION_MOVE :
			x=me.getX();
			y=me.getY();
			break;
		case MotionEvent.ACTION_UP: 
			x=me.getX();
			y=me.getY();
			break;
			
		}
		
		return true;
	}
}
