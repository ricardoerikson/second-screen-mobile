package br.ufmg.ppgee.secscrmob.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

public class WebServiceManager {

    private final CookieStore mCookieStore = new BasicCookieStore();
    private final HttpContext mHttpContext = new BasicHttpContext();
    private final HttpClient mHttpClient;
    private static WebServiceManager mInstance;

    private WebServiceManager() {
	mHttpClient = new DefaultHttpClient();
	mHttpContext.setAttribute(ClientContext.COOKIE_STORE, mCookieStore);
    }

    public static WebServiceManager getInstance() {
	if (mInstance == null)
	    mInstance = new WebServiceManager();
	return mInstance;
    }

    public String doPost(String uri, Map<String, String> attributes)
	    throws ClientProtocolException, IOException {
	URL url = new URL(uri);
	HttpPost httpPost = new HttpPost(url.toString());
	List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(
		attributes.size());
	for (Map.Entry<String, String> pair : attributes.entrySet()) {
	    nameValuePairs.add(new BasicNameValuePair(pair.getKey(), pair
		    .getValue()));
	}
	httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	HttpResponse response = mHttpClient.execute(httpPost, mHttpContext);
	return EntityUtils.toString(response.getEntity());
    }

    public String doGet(String uri) throws URISyntaxException,
	    ClientProtocolException, IOException {
	HttpGet httpGet = new HttpGet(uri);
	httpGet.setHeader("Content-Type", "application/json");

	HttpResponse response = mHttpClient.execute(httpGet, mHttpContext);
	return EntityUtils.toString(response.getEntity());
    }

}
