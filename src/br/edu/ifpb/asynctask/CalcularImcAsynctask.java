package br.edu.ifpb.asynctask;

import java.io.IOException;

import org.apache.http.protocol.HttpService;
import org.json.JSONException;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class CalcularImcAsynctask extends AsyncTask <JSONObject, Void, Response>
{
 
	

	Context context;
	
	public CalcularImcAsynctask(Context context){
		
		this.context = context;
		
		
	}
	protected void onPreExecute(){
		System.out.println("Inicializando...");
	}
	
	@Override
	protected Response doInBackground(JSONObject... valores) {
		
Response response = null;
		
		try {

            response = HttpService.sendJSONPostResquest("calcularIMC", valores[0]); // Esse método esta recebendo dois parametros: o nome do serviço e o json.

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
	}
	 @Override
	    protected void onPostExecute(Response response) {

	        int status = response.getStatusCodeHttp();

			if (status == 202) {

			    JSONObject json = new JSONObject();

			    String valor = json.getString("valor");
			    Log.i("NotificationWearApp", "Nome: " + valor);
			    Toast.makeText(context, valor, Toast.LENGTH_LONG).show();
			}
			
			
	

}
}
