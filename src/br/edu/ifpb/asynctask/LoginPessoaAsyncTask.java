package br.edu.ifpb.asynctask;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;

import br.edu.ifpb.entidades.Pessoa;
import android.os.AsyncTask;
import android.widget.Toast;

public class LoginPessoaAsyncTask extends AsyncTask<String, Integer, Integer>{

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		System.out.println("Iniciando.....");
	}

	
	@Override
	protected Integer doInBackground(String... params) {
		HTTPService httpService = new HTTPService();
		HttpResponse response = httpService.sendJsonPostRequest(
				"/verificarLogin", jsonObjects[0]);
		return response;
	}
	
	protected void onPostExecute(HttpResponse response) {

		int httpCode = response.getStatusLine().getStatusCode();

		try {
			// Conversão do response ( resposta HTTP) para String.
			String json = HttpUtil.entityToString(response);
			Log.i("Login Aluno", "Resquest - GET: " + json);

			JSONObject jsonObject = new JSONObject(json);
						
			if (httpCode == HttpStatus.SC_ACCEPTED) {

				String nascimento = jsonObject.getString("nascimento");
				String sexo = jsonObject.getString("sexo");
				int idPessoa = Integer.parseInt(jsonObject.getString("ID"));
				String nome = jsonObject.getString("nome");
				
				Pessoa pessoa = new Pessoa();
				pessoa.setName(nome);
				pessoa.setSexo(sexo);
				pessoa.setIdPessoa(idPessoa);
				pessoa.setNascimento(nascimento);
				
				Toast.makeText(activity.getApplicationContext(),
						"Bem vindo, " + nome,
						Toast.LENGTH_SHORT).show(); 
				 //Intent intent = new Intent(activity, TelaPrincipal.class);
				//activity.startActivity(intent);
				//activity.finish();

				//	} else {
				//Toast.makeText(activity.getApplicationContext(),
				//	jsonObject.getString("mensagem"), Toast.LENGTH_SHORT)
				//	.show();
				//	}

				//	} catch (JSONException e) {
				//Log.e("Login Aluno", "Error parsing data " + e.toString());
				//}
	

}  }  }  } 

				