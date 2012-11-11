package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity{
	
	// Global variable to use it in onPause
	MediaPlayer introSong;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		// Set splash.xml as content in the view
		setContentView(R.layout.splash);
		// create a mediaplayer object from global introSong
		introSong = MediaPlayer.create(Splash.this, R.raw.splash);
		introSong.start();
		Thread timer = new Thread(){
			public void run(){
				try{
					// Try something
					sleep(5000);
					// Here we can start a new activity, but we do it in finally
				} catch (InterruptedException e){
					// Debug messages
					e.printStackTrace();
				} finally{
					// After we tried (succeeded or not), do this
					
					// Define an intent with actionname
					Intent openMainScreen = new Intent("com.example.helloworld.MAINACTIVITY");
					// Then we can start an activity
					startActivity(openMainScreen);
					
				}
			}
		};
		timer.start();
	}


	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		introSong.release();
		finish();
	}	
	
}
