package br.ufmg.ppgee.secscrmob.listener;

import java.lang.reflect.Proxy;

public class InteractionListener {

    public static ListenerProxy getProxy() {
	return ProxyHolder.instance;
    }

    static class ProxyHolder {
	static ListenerProxy instance = (ListenerProxy) Proxy.newProxyInstance(
		RequestsHandler.class.getClassLoader(),
		new Class[] { ListenerProxy.class },
		RequestsHandlerHolder.instance);
    }

    static class RequestsHandlerHolder {
	static RequestsHandler instance = new RequestsHandler();
    }

}
