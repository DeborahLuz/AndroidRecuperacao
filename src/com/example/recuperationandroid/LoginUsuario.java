package com.example.recuperationandroid;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.ActionBar;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class LoginUsuario extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login_pessoa);
            ActionBar act = getActionBar();
            act.hide();
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

            Button acessar = (Button) findViewById(R.id.acessar);
           
            acessar.setOnClickListener((android.view.View.OnClickListener) this);
           
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		EditText name = (EditText) findViewById(R.id.name);
        EditText senha = (EditText) findViewById(R.id.senha);

       
       	}
	private void logarUsuario(String login, String senha) {
        JSONObject jsonObject = new JSONObject();

        try {
                jsonObject.put("login", login);
                jsonObject.put("senha", senha);

                LoginPessoaAsyncTask LogAsyncTask = new LoginPessoaAsyncTask(this);
                LogAsyncTask.execute(jsonObject);
                
        } catch (JSONException e) {
                Log.e("ERROR", e.getMessage());
             
        }
}
}

