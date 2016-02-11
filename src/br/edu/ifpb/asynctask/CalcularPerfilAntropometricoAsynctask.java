package br.edu.ifpb.asynctask;

import java.io.IOException;

import org.apache.http.protocol.HttpService;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class CalcularPerfilAntropometricoAsynctask  extends Asynctask <JSONObject, Void, HttpResponse>{
	protected void onPreExecute(){
		System.out.println("Inicializando...");
	}
	
	@Override
	protected Response doInBackground(JSONObject... valores) {
		
Response response = null;
		
		try {

            response = HttpService.sendJSONPostResquest("calcularPerfilAntropometrico", valores[0]); // Esse método esta recebendo dois parametros: o nome do serviço e o json.

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
			    Context context;
				Toast.makeText(context, valor, Toast.LENGTH_LONG).show();
			}
}
}