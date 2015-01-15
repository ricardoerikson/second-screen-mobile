package br.ufmg.ppgee.secscrmob.listener;

public class InteractionListenerModel {

    private String caller;
    private String uri;
    private RequestMethod method;

    public InteractionListenerModel(String caller, String uri,
	    RequestMethod method) {
	this.caller = caller;
	this.uri = uri;
	this.method = method;
    }

    public String getCaller() {
	return caller;
    }

    public String getUri() {
	return uri;
    }

    public RequestMethod getMethod() {
	return method;
    }

}
