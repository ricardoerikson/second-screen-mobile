package br.ufmg.ppgee.secscrmob.listener;

import java.lang.reflect.Method;

import android.annotation.SuppressLint;

@SuppressLint("DefaultLocale")
public class InteractionListenerInstaller {

    @SuppressLint("NewApi")
    public static void processAnnotation(Class<?> klass) {
	Class<?> cl = klass;
	for (Method m : cl.getDeclaredMethods()) {
	    InteractionMapping a = m.getAnnotation(InteractionMapping.class);
	    if (a != null)
		InteractionsController.addAction(m.getName(),
			a.uri(), a.method());
	}
    }

}
