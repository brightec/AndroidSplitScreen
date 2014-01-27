package com.example.splitscreen;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Hiding Alpha pane only applies on portrait
		int screenOrientation = getResources().getConfiguration().orientation;
		if (screenOrientation == Configuration.ORIENTATION_PORTRAIT) {
			hideAlphaPane();
			
			View omegaPane = findViewById(R.id.omega); 
			omegaPane.setOnTouchListener(new OnSwipeTouchListener(this) {
				@Override
				public void onSwipeLeft(){
					hideAlphaPane();
					super.onSwipeLeft();
				}
				
				public void onSwipeRight(){
					showAlphaPane();
					super.onSwipeRight();
				}
				
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					hideAlphaPane();
					return super.onTouch(v, event);
				}
			});
		}
	}
		

	
	/**
	 * Method to hide the Alpha pane
	 */
	private void hideAlphaPane() {
		View alphaPane = findViewById(R.id.alpha);
    	if (alphaPane.getVisibility() == View.VISIBLE) {
    		alphaPane.setVisibility(View.GONE);
		}		
	}
	
	/**
	 * Method to show the Alpha pane
	 */
	private void showAlphaPane() {
		View alphaPane = findViewById(R.id.alpha);
		if (alphaPane.getVisibility() == View.GONE) {
			alphaPane.setVisibility(View.VISIBLE);
		}
	}
}
