package com.example.recuperationandroid;

import br.edu.ifpb.entidades.Vct;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CalcularVct extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calcular_vct);

		Button button = (Button) findViewById(R.id.calcularvct);
		button.setOnClickListener((android.view.View.OnClickListener) this);
	}

	public void onClick(View arg0) {
		Intent intent = new Intent(this, Vct.class);
		startActivity(intent);
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
