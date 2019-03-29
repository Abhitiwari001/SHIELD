package com.example.shield;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.telephony.SmsManager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements SensorEventListener 
  {
	Message o=new Message();
	LocationManager lm;
	RelativeLayout ll;
	MediaPlayer m;
	double ln;
	double lt;
	SensorManager sm;
	String sublocality;
	String locality;
	String country;
	String a;
	String geoUri ;
	int x=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ll=(RelativeLayout)findViewById(R.id.ll);
		 m=new MediaPlayer();
		m=MediaPlayer.create(this,R.drawable.sirentone);
		m.setLooping(true);
		sm=(SensorManager)getSystemService("sensor");
		sm.registerListener(this,sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),sm.SENSOR_DELAY_NORMAL);
lm=(LocationManager)getSystemService("location");
TextView lat=(TextView)findViewById(R.id.lat);
TextView lng=(TextView)findViewById(R.id.lng);
Criteria criteria=new Criteria();
String provider=lm.getBestProvider(criteria,false);
Location loc=lm.getLastKnownLocation(provider);
if(loc!=null){
	 ln=loc.getLongitude();
	 lt=loc.getLatitude();
	lat.setText(""+lt);
	lng.setText(""+ln);

	Geocoder gc=new Geocoder(MainActivity.this,Locale.getDefault());
	List<Address>addressList;
	try{
		addressList = gc.getFromLocation(lt, ln,2);
		if(addressList !=null && addressList.size()>0){
			Address adr =addressList.get(0);
			 sublocality= adr.getSubLocality();
			 locality = adr.getLocality();
			country= adr.getCountryName();
		a=adr.getPostalCode();
		
		
		}
	}catch(IOException e){
		
	}
}


}
	public void call(View v){
		Intent i;
		switch(v.getId()){
		case R.id.police:
		i=new Intent(Intent.ACTION_CALL,Uri.parse("tel:100"));
			startActivity(i);  
			break;
		case R.id.ambulance:
			i  =new Intent(Intent.ACTION_CALL,Uri.parse("tel:102"));
			startActivity(i);
			break;
		case R.id.women:
	i =new Intent(Intent.ACTION_CALL,Uri.parse("tel:1091"));
			startActivity(i);
			break;
		
		
		}	
	}
	
public boolean onKeyDown(int keyCode, KeyEvent event)
{
	
	if(event.getKeyCode()==KeyEvent.KEYCODE_VOLUME_UP)
	{
		ll.setBackgroundColor(Color.CYAN);
		SmsManager sms=SmsManager.getDefault();
		sms.sendTextMessage("9654644984", null, "I am in Danger Please Help!!!My location is  "+"latitude"+lt+"  longitude"+ln +" "+ sublocality  +  locality +  country + a  , null ,null);
	}
	
	return true;
	

}
public void play(View v)
{
if(m.isPlaying()){	
	m.pause();
}
else
	{
		m.start();
	
	}
}
public void message(View v){
	
	Intent i=new Intent (this,Message.class);
	startActivity(i);
}

  
  
public void contact(View v){
	
	Intent i=new Intent (this,Contacts.class);
	startActivity(i);
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.activity_main, menu);
	return true;
} 
 public boolean  onOptionsItemSelected(MenuItem item){
	 switch(item.getItemId()){
	 case R.id.About:
		 Intent i=new Intent(this,MenuActivity.class);
		 startActivity(i);
		 break;
	 case R.id.Safety:
		 Intent j=new Intent(this,SafetyActivity.class);
		 startActivity(j);
		 break;
	 case R.id.Rate:
		 Intent k=new Intent(this,Rate.class);
		 startActivity(k);
		 break;
	 case R.id.Feedback:
		 Intent l=new Intent(this,FeedbackActivity.class);
		 startActivity(l);
		 break;
	 case R.id.Fir:
		 Intent m=new Intent(Intent.ACTION_VIEW,Uri.parse("http://205.147.111.155:84/"));
		 startActivity(m);
		 break;
	 }
	 
	 return true;
 }
@Override
public void onAccuracyChanged(Sensor arg0, int arg1) {
	// TODO Auto-generated method stub
	
}
@Override
public void onSensorChanged(SensorEvent event) {
	
	float value[]=event.values;
	float x=value[0];
	float y=value[1];
	float z= value[2];
	float asr = (x*x+y*y+z*z)/(sm.GRAVITY_EARTH*sm.GRAVITY_EARTH);
	if(asr>=6){
		Intent i=new Intent(Intent.ACTION_CALL,Uri.parse("tel:100"));
		startActivity(i);
		
	}
}
}
  
  
  
  