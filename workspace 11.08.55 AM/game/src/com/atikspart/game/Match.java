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
	boolean init=true;
	boolean l1touch=false,l2touch=false,l3touch=false;
	boolean r1place=false,r2place=false,r3place=false;
	boolean l1r1=false,l1r2=false,l1r3=false,l2r1=false,l2r2=false,l2r3=false,l3r1=false,l3r2=false,l3r3=false;
	boolean l1matched=false,l2matched=false,l3matched=false;
	Canvas c;
	
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
		init=false;
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
			
			l1 = BitmapFactory.decodeResource(getResources(), R.drawable .a);
			l2 = BitmapFactory.decodeResource(getResources(), R.drawable .b);
			l3 = BitmapFactory.decodeResource(getResources(), R.drawable .c);
			r1 = BitmapFactory.decodeResource(getResources(), R.drawable .a);
			r2 = BitmapFactory.decodeResource(getResources(), R.drawable .b);
			r3 = BitmapFactory.decodeResource(getResources(), R.drawable .c);
			
			while (ok == true) {
				if (!holder.getSurface().isValid()) {
					continue;
				}
				c = holder.lockCanvas();
				c.drawRGB(49,79,79);
				if(init){ initialLoad();
				}else{	
                if(x>=50 && x<=100 && y>=100 && y<=150){
                	l1touch=true;
                	l2touch=false;
                	l3touch=false;
                }
                else
                	if(x>=50 && x<=100 && y>=200 && y<=250){
                		l2touch=true;
                		l1touch=false;
                		l3touch=false;
                	}
                	else	
                		if(x>=50 && x<=100 && y>=300 && y<=350){
                			l3touch=true;
                			l1touch=false;
                			l2touch=false;
                		}else
                			initialLoad();
                
                if(x>=300 && x<=350 && y>=100 && y<=150)
                	if(l3touch)
                	r1place=true;
                if(x>=300 && x<=350 && y>=200 && y<=250)
                	if(l2touch)
                    r2place=true;
                if(x>=300 && x<=350 && y>=300 && y<=350)
                	if(l1touch)
                    r3place=true;
                /*
                 code to set the match 
                 */
                l1r3=true;
                l2r2=true;
                l3r1=true;
                
                if(l1touch && l1r3){
                	c.drawRGB(49,79,79);
                	if(!r3place)
                		c.drawBitmap(l1, x -(l1.getWidth()/2), y-(l1.getHeight()/2) ,null);
                	else{
                		l1matched=true;
                		c.drawBitmap(l1,300 ,300  ,null);
                		}
                	if(!l2matched)
                		c.drawBitmap(l2,50 ,200  ,null);
                	else
                		c.drawBitmap(l2,300 ,200  ,null);
                	if(!l3matched)	
                		c.drawBitmap(l3,50 ,300  ,null);
                	else
                		c.drawBitmap(l3,300 ,100  ,null);
                	c.drawBitmap(r1,350 ,100  ,null);
                	c.drawBitmap(r2,350 ,200  ,null);
                	c.drawBitmap(r3,350 ,300  ,null);
                }
                
                if(l2touch && l2r2){
                	c.drawRGB(49,79,79);
                	if(!r2place)
                		c.drawBitmap(l2, x -(l2.getWidth()/2), y-(l2.getHeight()/2) ,null);
                	else{
                		l2matched=true;
                		c.drawBitmap(l2,300 ,200  ,null);
                		}
                	if(!l1matched)
                		c.drawBitmap(l1,50 ,100  ,null);
                	else
                		c.drawBitmap(l1,300 ,300  ,null);
                	if(!l3matched)	
                		c.drawBitmap(l3,50 ,300  ,null);
                	else
                		c.drawBitmap(l3,300 ,100  ,null);
    				c.drawBitmap(r1,350 ,100  ,null);
    				c.drawBitmap(r2,350 ,200  ,null);
    				c.drawBitmap(r3,350 ,300  ,null);
                    }
  
                if(l3touch && l3r1){
                	c.drawRGB(49,79,79);
                	if(!r1place)
                		c.drawBitmap(l3, x -(l3.getWidth()/2), y-(l3.getHeight()/2) ,null);
                	else{
                		l3matched=true;
                		c.drawBitmap(l3,300 ,100  ,null);
                		}
                	if(!l2matched)
                		c.drawBitmap(l2,50 ,200  ,null);
                	else
                		c.drawBitmap(l2,300 ,200  ,null);
                	if(!l1matched)
                		c.drawBitmap(l1,50 ,100  ,null);
                	else
                		c.drawBitmap(l1,300 ,300  ,null);
    				c.drawBitmap(r1,350 ,100  ,null);
    				c.drawBitmap(r2,350 ,200  ,null);
    				c.drawBitmap(r3,350 ,300  ,null);
                    }
            
				}
				holder.unlockCanvasAndPost(c);

			}

		}

		public void initialLoad(){
			c.drawBitmap(l1,50 ,100  ,null);
			c.drawBitmap(l2,50 ,200  ,null);
			c.drawBitmap(l3,50 ,300  ,null);
			c.drawBitmap(r1,350 ,100  ,null);
			c.drawBitmap(r2,350 ,200  ,null);
			c.drawBitmap(r3,350 ,300  ,null);
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
