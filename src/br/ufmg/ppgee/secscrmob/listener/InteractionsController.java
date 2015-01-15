package br.ufmg.ppgee.secscrmob.listener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;
import android.util.Log;

@SuppressLint("DefaultLocale")
public class InteractionsController {

    private static Map<String, InteractionListenerModel> ilm = new HashMap<String, InteractionListenerModel>();

    @InteractionListener(uri = "/users/evaluation", method = RequestMethod.POST)
    public static void captureUserEvaluation(Map<String, Object> payload,
	    InteractionListenerModel model) {
	Log.i("interaction", "Caller: " + model.getCaller());
	Log.i("interaction", "URI: " + model.getUri());
    }

    public static void sendInteraction(String method,
	    Map<String, Object> payload) {

	InteractionListenerModel model = ilm.get(method.toLowerCase());
	String caller = model.getCaller();

	Method m;
	try {
	    m = InteractionsController.class.getMethod(caller, Map.class,
		    InteractionListenerModel.class);
	    m.setAccessible(true);
	    m.invoke(null, payload, model);
	} catch (NoSuchMethodException e) {
	    e.printStackTrace();
	} catch (IllegalAccessException e) {
	    e.printStackTrace();
	} catch (IllegalArgumentException e) {
	    e.printStackTrace();
	} catch (InvocationTargetException e) {
	    e.printStackTrace();
	}
    }

    @SuppressLint("DefaultLocale")
    public static void addAction(String method, String uri,
	    RequestMethod httpMethod) {
	ilm.put(method.toLowerCase(), new InteractionListenerModel(method, uri,
		httpMethod));
    }

}
