package com.yahoo.jgc.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onButtonClicked(View v) {
		String input;
		double total,
			   multiplier = 0.10; //10%
		TextView tvResult = (TextView)findViewById(R.id.tvResult);
				
		if (v.getId() == R.id.btn15){
			multiplier = 0.15;
		} else if (v.getId() == R.id.btn20) {
			multiplier = 0.20;
		}
		
		EditText et = (EditText)findViewById(R.id.etTotal);
		input = et.getText().toString();
		if (input.isEmpty()) {
			Toast.makeText(this, "Enter the total check!", Toast.LENGTH_SHORT).show();
			tvResult.setText("");
			return;  
		}
		
		total = Double.parseDouble(input);
		tvResult.setText(String.format("Total:    $%.2f", (multiplier * total)));
	}	

}
