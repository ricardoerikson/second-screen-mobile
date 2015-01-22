package br.ufmg.ppgee.secscrmob.listener;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import android.util.Log;

public class RequestsHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
	    throws Throwable {
	InteractionMapping a = method.getAnnotation(InteractionMapping.class);
	if (a == null)
	    return null;

	Log.i("interaction", Integer.toString(args.length));
	Log.i("interaction", "Caller:" + method.getName());
	return null;
    }

}
