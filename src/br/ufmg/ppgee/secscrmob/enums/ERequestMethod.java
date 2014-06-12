package br.ufmg.ppgee.secscrmob.enums;

public enum ERequestMethod {

    POST("POST"), GET("GET"), PUT("PUT"), DELETE("DELETE");

    private String mMethodName;

    ERequestMethod(String methodName) {
	this.mMethodName = methodName;
    }

    public String value() {
	return this.mMethodName;
    }

}
