package br.ufmg.ppgee.secscrmob.service.login;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;

import android.os.AsyncTask;
import android.util.Log;
import br.ufmg.ppgee.secscrmob.utils.WebServiceManager;

public class GetViewersAsyncTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... args) {
	String uri = args[0];
	Log.i("login", uri);
	try {
	    return WebServiceManager.getInstance().doGet(uri);
	} catch (ClientProtocolException e) {
	    e.printStackTrace();
	} catch (URISyntaxException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return null;
    }

    @Override
    protected void onPostExecute(String result) {
	Log.i("login", result);
    }

}
