package com.e_slate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class Splashanim extends View {
	Bitmap splashboy, splashe;
	Paint p = new Paint();
	int x, y;

	public Splashanim(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		splashe = BitmapFactory.decodeResource(getResources(), R.drawable.e1);
		splashboy = BitmapFactory.decodeResource(getResources(),
				R.drawable.boy1);
		x = 0;
		y = 0;
	}		Rect totalarea = new Rect();

	

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		totalarea.set(0, 0, canvas.getWidth(), canvas.getHeight());
		canvas.drawBitmap(splashboy, null, totalarea, p);
		if (y < (canvas.getHeight()/2)) {
			y += 10;
			
		}
		canvas.drawBitmap(splashe, x, y, p);
		invalidate();

	}
}
