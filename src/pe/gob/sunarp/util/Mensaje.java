package pe.gob.sunarp.util;

public class Mensaje {
	private boolean code;
	private String message;

	public Mensaje() {
	}

	public Mensaje(boolean code, String message) {
		this.code = code;
		this.message = message;
	}

	public boolean getCode() {
		return code;
	}

	public void setCode(boolean code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
