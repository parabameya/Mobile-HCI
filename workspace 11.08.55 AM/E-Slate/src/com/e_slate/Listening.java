package com.e_slate;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Listening extends Activity {
	ImageView a_alpha,b_alpha;
	MediaPlayer sound;
	Button backtolist;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.abcdlisten);
		backtolist=(Button)findViewById(R.id.blist);
		backtolist.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i=new Intent("com.e_slate.AbcdList");
				startActivity(i);
			}
		});
		
		a_alpha=(ImageView)findViewById(R.id.aid);
		a_alpha.setClickable(true);
		a_alpha.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
				// TODO Auto-generated method stub
			sound=MediaPlayer.create(Listening.this, R.raw.aforapple);
			sound.start();
			}
		});
		
		b_alpha=(ImageView)findViewById(R.id.bid);
		b_alpha.setClickable(true);
		b_alpha.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sound=MediaPlayer.create(Listening.this, R.raw.bforball);
				sound.start();
				
			}
		});
	}

}
