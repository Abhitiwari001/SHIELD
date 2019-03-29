package com.example.shield;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;


public class Splash extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
	
		
	 
	    Thread td = new Thread(){
	    public void run(){
	        try{
	            sleep(4000);
	        }
	    catch (Exception ex){
	            ex.printStackTrace();
	    }
	    finally {
	            Intent it = new Intent(Splash.this,MainActivity.class);
	            startActivity(it);
	        }
	    }



	    };td.start();

	    }
}

