package com.example.nomeubairro_stable;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AddReport_Activity extends Activity {

	 private static int RESULT_LOAD_IMAGE = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_report_);
		
		 Button addimagebutton = (Button) findViewById(R.id.AddImageButton);
		 addimagebutton.setOnClickListener(new View.OnClickListener() {
	             
	            @Override
	            public void onClick(View arg0) {
	                 
	                Intent i = new Intent(
	                        Intent.ACTION_PICK,
	                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
	                 
	                startActivityForResult(i, RESULT_LOAD_IMAGE);
	            }    
	        });
		
		/* Button sendpostbutton = (Button) findViewById(R.id.Enviar_Button);
		 addimagebutton.setOnClickListener(new View.OnClickListener(){
			 
			 public void onClick(View arg0){
				 
				 
				 
			 }
			 
		 });*/
		 
		 
		 
		
		 
	}

	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
         
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
 
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
 
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
             
            ImageView imageView = (ImageView) findViewById(R.id.ImageView);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
         
        }
     
     
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_report_, menu);
		return true;
	}

}
