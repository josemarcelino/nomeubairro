package com.example.nomeubairro_stable;

import com.example.nomeubairro_stable.GPSTracker;
import com.example.nomeubairro_stable.R;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Main_Activity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		GPSTracker gps = new GPSTracker(this);

		setContentView(R.layout.activity_main_);

		if(gps.canGetLocation()){

			/* GoogleMap map =((MapFragment) getFragmentManager()
                     .findFragmentById(R.id.)).getMap();

             LatLng Local = new LatLng(-33.867, 151.206);

             map.setMyLocationEnabled(true);
             map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));

             map.addMarker(new MarkerOptions()
                     .title("Sydney")
                     .snippet("The most populous city in Australia.")
                     .position(sydney));
			 */
			/*	Log.i("gps", "enable");
        	double lat = gps.getLatitude();
        	double lon = gps.getLongitude();
        	Log.d("lat",String.valueOf(lat));
        	Log.d("lon", String.valueOf(lon));
			 */	
		}
		else{
			/*Log.i("gps", "disable");*/
			gps.showSettingsAlert();
		}


		final Button reportar_novo = (Button) findViewById(R.id.Reportar_Novo);
		reportar_novo.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(Main_Activity.this,AddReport_Activity.class);	
				startActivity(intent);
				// Perform action on click
			}
		});
	}

	}