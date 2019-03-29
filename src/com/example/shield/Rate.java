package com.example.shield;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.TextView;

public class Rate extends Activity {
RatingBar rb;
TextView value;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rate);
		rb= (RatingBar)findViewById(R.id.ratingBar);
		value=(TextView)findViewById(R.id.txtRatingValue);
		rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
			
			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating,	boolean fromUser) {
				// TODO Auto-generated method stub
				value.setText("Value is"+rating); 
			}
		});
	}
}
	


