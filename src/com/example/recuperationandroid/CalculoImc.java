package com.example.recuperationandroid;

import org.json.JSONException;
import org.json.JSONObject;

import br.edu.ifpb.asynctask.CalcularImcAsynctask;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class CalculoImc extends Activity implements OnClikListener{
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calcular_imc);
		 Button calcularIMCButton = (Button) findViewById(R.id.calcularIMCButton);
	     calcularIMCButton.setOnClickListener((OnClickListener) this);
	}

	 @Override
	    public void onClick(View v) {

	        // Calcular o IMC.
	        Log.i("NotificationWearApp", "Clique no botão da AsyncTask");

	        JSONObject geral = new JSONObject();

	        try { //Pegar os valores no formulário e coloca no json
	            // Peso
	            EditText pesoEditText = (EditText) findViewById(R.id.pesoEditText);
	            String peso = pesoEditText.getText().toString();
	            geral.put("peso", peso);

	            // Altura
	            EditText alturaEditText = (EditText) findViewById(R.id.alturaEditText);
	            String altura = alturaEditText.getText().toString();
	            geral.put("altura", altura);

	            CalcularImcAsynctask calcularIMCAsyncTask = new CalcularImcAsynctask(this);
	            calcularIMCAsyncTask.onPostExecute(geral);// Manda para a asyncTask

	        } catch (JSONException e) {
	            e.printStackTrace();
	        }
	    }


	
	
	
	
	
	
}
