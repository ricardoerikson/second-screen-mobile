package br.ufmg.ppgee.secscrmob.enums;

public enum EServiceUris {

    BASE_URI("http://dev-adapter-481.appspot.com"), LOGIN("/login"), VIEWERS_JSON(
	    "/viewers"), PROGRAMS_JSON("/programs");

    private String mUri;

    EServiceUris(String uri) {
	this.mUri = uri;
    }

    public String value() {
	return this.mUri;
    }

}
