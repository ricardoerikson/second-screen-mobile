package br.ufmg.ppgee.secscrmob.enums;

public enum EServiceUris {

    BASE_URI("http://dev-adapter-481.appspot.com/", null), LOGIN("/login",
	    ERequestMethod.POST), VIEWERS_JSON("/viewers", ERequestMethod.GET), PROGRAMS_JSON(
	    "/programs", ERequestMethod.GET);

    private String mUri;
    private ERequestMethod mMethod;

    EServiceUris(String uri, ERequestMethod methodName) {
	this.mUri = uri;
	this.mMethod = methodName;
    }

    public String getUri() {
	return this.mUri;
    }

    public ERequestMethod getMethodName() {
	return this.mMethod;
    }
}
