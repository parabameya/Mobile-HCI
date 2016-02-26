package com.e_slate;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Start extends Activity {

	ImageView abcd, num, games, general;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		abcd = (ImageView) findViewById(R.id.ibabcd);
		num = (ImageView) findViewById(R.id.ibnum);
		games = (ImageView) findViewById(R.id.ibgames);
		general = (ImageView) findViewById(R.id.ibgeneral);
		
		
		Animation blink=new AlphaAnimation(1,0);
		blink.setDuration(500); // duration - half a second
		blink.setInterpolator(new LinearInterpolator());
		blink.setRepeatCount(Animation.ABSOLUTE); // Repeat animation
		// infinitely
		blink.setRepeatMode(Animation.REVERSE); // Reverse animation at
		 

		Animation scale = AnimationUtils.loadAnimation(this,
				R.anim.abcdscale);
		findViewById(R.id.ibgames).startAnimation(scale);

		findViewById(R.id.ibabcd).startAnimation(blink);
		//Animation alpha = AnimationUtils.loadAnimation(this,
			//	R.anim.abcdscale);
		
		findViewById(R.id.ibnum).startAnimation(blink);
				abcd.setClickable(true);

		abcd.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				
				Intent i=new Intent("com.e_slate.AbcdList");
				 startActivity(i);

			}
		});

	}

}
