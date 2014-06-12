package br.ufmg.ppgee.secscrmob.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.util.Log;

public class WebServiceManager {

    private final HttpClient mHttpClient;

    private static WebServiceManager mInstance;

    private WebServiceManager() {
	mHttpClient = new DefaultHttpClient();
    }

    public static WebServiceManager getInstance() {
	if (mInstance == null)
	    mInstance = new WebServiceManager();
	return mInstance;
    }

    public String doPost(String uri, Map<String, String> attributes)
	    throws ClientProtocolException, IOException {
	HttpPost httpPost = new HttpPost(uri);
	Log.i("login", uri);
	List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(attributes.size());
	for (Map.Entry<String, String> pair : attributes.entrySet()) {
	    nameValuePairs.add(new BasicNameValuePair(pair.getKey(), pair.getValue()));
	}
	httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	HttpResponse response = mHttpClient.execute(httpPost);
	return EntityUtils.toString(response.getEntity());
    }

    public String doGet(String uri) throws URISyntaxException, ClientProtocolException, IOException {
	HttpGet httpGet = new HttpGet(uri);
	URI website = new URI(uri);
	httpGet.setURI(website);

	HttpResponse response = mHttpClient.execute(httpGet);
	return EntityUtils.toString(response.getEntity());
    }

}
