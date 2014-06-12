package br.ufmg.ppgee.secscrmob.service.login;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;

import android.os.AsyncTask;
import android.util.Log;
import br.ufmg.ppgee.secscrmob.enums.EServiceUris;
import br.ufmg.ppgee.secscrmob.utils.WebServiceManager;

public class LoginAsyncTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {
	String username = params[0];
	String password = params[1];

	Map<String, String> nameValuePairs = new HashMap<String, String>();
	nameValuePairs.put("username", username);
	nameValuePairs.put("password", password);

	String uri = EServiceUris.BASE_URI.value().concat(EServiceUris.LOGIN.value());
	try {
	    return WebServiceManager.getInstance().doPost(uri, nameValuePairs);
	} catch (ClientProtocolException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return null;
    }

    @Override
    protected void onPostExecute(String result) {
	String uri = EServiceUris.BASE_URI.value().concat(EServiceUris.VIEWERS_JSON.value());
	Log.i("login", uri);
	new GetViewersAsyncTask().execute(uri);
    }

}
