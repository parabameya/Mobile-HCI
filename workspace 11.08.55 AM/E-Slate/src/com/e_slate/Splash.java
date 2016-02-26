package com.e_slate;

import android.R.anim;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;

public class Splash extends Activity {
	
	//Splashanim sp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//sp=new Splashanim(this); 
		setContentView(R.layout.splash);
		ImageView imagee=(ImageView)findViewById(R.id.ive);
		
		Animation anime=AnimationUtils.loadAnimation(this,R.anim.transe );
		findViewById(R.id.ive).startAnimation(anime);
		
		
		Thread timer =new Thread()
		{public void run()
		{
			try{
				sleep(4500);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
				}
			finally
			{
				Intent i=new Intent("com.e_slate.Start");
				startActivity(i);
				
			}
		}
			
		};
		timer.start();
	}

}
