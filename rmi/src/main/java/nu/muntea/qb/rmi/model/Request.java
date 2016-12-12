package nu.muntea.qb.rmi.model;

import java.io.Serializable;

public class Request implements Serializable {

	private static final long serialVersionUID = -5027259672078528981L;

	private String what;

	public Request(String what) {
		this.what = what;
	}

	public Request() {

	}

	public String getWhat() {
		return what;
	}

	public void setWhat(String what) {
		this.what = what;
	}

}
