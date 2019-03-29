package com.example.shield;

import android.os.Bundle;
import android.app.Activity;

import android.view.View;
import android.widget.EditText;

public class Message extends Activity {
EditText messg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message);
	 messg= (EditText)findViewById(R.id.messg);
	 
	
	}
void fun(View v){
	String s=messg.getText().toString();
}
	
	}


