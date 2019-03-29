package com.example.shield;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackActivity extends Activity {
	EditText   e1 ;
    EditText    e2; 
   Button b ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feedback);
	    
		  b=(Button)findViewById(R.id.sendMail);
	        e1=(EditText)findViewById(R.id.editText1);
	        e2=(EditText)findViewById(R.id.editText2);
	        b.setOnClickListener(new View.OnClickListener() {
	            @Override            public void onClick(View v) {
	                Intent i = new Intent(Intent.ACTION_SEND);
	                i.setType("message/html");
	                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"abhitiwari299@gmail.com"});
	                i.putExtra(Intent.EXTRA_SUBJECT, "Feedback from App");
	                i.putExtra(Intent.EXTRA_TEXT, "Name : "+e1.getText()+"\nMessage : "+e2.getText());
	                try {
	                    startActivity(Intent.createChooser(i, "Send feedback..."));
	                } catch (android.content.ActivityNotFoundException ex) {
	                    Toast.makeText(getApplicationContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
	                }

	            }
	        });

	    }
		
	            

	        

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_feedback, menu);
		return true;
	}

}
