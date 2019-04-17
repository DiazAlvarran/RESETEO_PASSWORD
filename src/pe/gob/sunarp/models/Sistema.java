package pe.gob.sunarp.models;

public class Sistema {
	
	private String co_empl;
	private String id_user;
	private String in_estd;
	private String sistema;
	private String valor;
	private String tabla_dbl;
	private String tabla;
	private String dbl;
	
	public Sistema() {
		
	}
	
	public Sistema(String co_empl, String id_user, String in_estd, String sistema, String valor, String tabla_dbl,
			String tabla, String dbl) {
		super();
		this.co_empl = co_empl;
		this.id_user = id_user;
		this.in_estd = in_estd;
		this.sistema = sistema;
		this.valor = valor;
		this.tabla_dbl = tabla_dbl;
		this.tabla = tabla;
		this.dbl = dbl;
	}

	public String getCo_empl() {
		return co_empl;
	}

	public void setCo_empl(String co_empl) {
		this.co_empl = co_empl;
	}

	public String getId_user() {
		return id_user;
	}

	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

	public String getIn_estd() {
		return in_estd;
	}

	public void setIn_estd(String in_estd) {
		this.in_estd = in_estd;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getTabla_dbl() {
		return tabla_dbl;
	}

	public void setTabla_dbl(String tabla_dbl) {
		this.tabla_dbl = tabla_dbl;
	}

	public String getTabla() {
		return tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public String getDbl() {
		return dbl;
	}

	public void setDbl(String dbl) {
		this.dbl = dbl;
	}
	
	
}
