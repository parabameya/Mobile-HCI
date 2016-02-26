package com.atikspart.game;

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

public class Match extends Activity implements OnTouchListener {
	OurView v;
	Bitmap l1,l2,l3,r1,r2,r3;
	float x, y;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		v = new OurView(this);
		v.setOnTouchListener(this);
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
	
	@Override
	public boolean onTouch(View vi, MotionEvent me) {
		// TODO Auto-generated method stub
		x=me.getX();
		y=me.getY();
		
		return true;
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
				c.drawRGB(05,05,120);
                if(x!=0 && y!=0){
                l1 = BitmapFactory.decodeResource(getResources(), R.drawable .a);
				c.drawBitmap(l1, x -(l1.getWidth()/2), y-(l1.getHeight()/2) ,
						null);
                }

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

	}
