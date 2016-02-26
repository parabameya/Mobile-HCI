package com.e_slate;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Alphabet_songs extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alphavideo);
	showVideo();
	}
	 private void showVideo()
	    {
	        VideoView vd = (VideoView)findViewById(R.id.videoview1);
	        Uri uri = Uri.parse("android.resource://com.e_slate/"+R.raw.alphason2);
	        vd.setVideoURI(uri);
	        MediaController mc = new MediaController(this);
	        vd.setMediaController(mc);
	        
	        vd.requestFocus();
	    }
	 
	

}
