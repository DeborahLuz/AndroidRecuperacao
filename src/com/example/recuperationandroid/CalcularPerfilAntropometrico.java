package com.example.recuperationandroid;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Button;

public class CalcularPerfilAntropometrico extends Activity implements OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calcular_perfilAntropometrico);

		Button button = (Button) findViewById(R.id.calcularPerfilAntropometrico);
		button.setOnClickListener((android.view.View.OnClickListener) this);
	}
	
	
	
	
	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
	}

}
