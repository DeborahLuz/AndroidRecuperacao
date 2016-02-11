package br.edu.ifpb.asynctask;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class CalcularVctAsynctask extends Asynctask <JSONObject, Void, HttpResponse>{
	public static double vct = 0;
	private Activity activity;

	public void VCTAsyncTask(Activity activity) {
		this.activity = activity;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
	}

	@Override
	protected HttpResponse doInBackground(JSONObject... jsonObjects) {

		HTTPService httpService = new HTTPService();
		HttpResponse response = httpService.sendJsonPostRequest("/calcularVCT",
				jsonObjects[0]);
		return response;
	}

	@Override
	protected void onPostExecute(HttpResponse response) {

		int httpCode = response.getStatusLine().getStatusCode();

		try {
			
			String json = HttpUtil.entityToString(response);
			Log.i("VCT", "Resquest - GET: " + json);

			JSONObject jsonObject = new JSONObject();

			if (httpCode == 200) {
                String vcts = jsonObject.getString("valor");
                vct = Double.parseDouble(vcts);
				Intent intent = new Intent(activity, ResultadoVCTActivity.class);
				activity.startActivity(intent);
				activity.finish();

			} else {
				Toast.makeText(activity.getApplicationContext(),
						"Erro no calculo", Toast.LENGTH_SHORT)
						.show();
			}

		} 
	}
	

}

