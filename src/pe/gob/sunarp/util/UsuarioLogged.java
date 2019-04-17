package pe.gob.sunarp.util;

public class UsuarioLogged {
	
	private String c_t_nombre; //nombre completo de empleado
	private String ap_pate_empl; //apellido paterno
	private String ap_mate_empl; //apellido materno
	private String no_empl; //nombre
	private String no_area; //nombre de area
		
	public UsuarioLogged() {
		super();
	}

	public String getC_t_nombre() {
		return c_t_nombre;
	}

	public void setC_t_nombre(String c_t_nombre) {
		this.c_t_nombre = c_t_nombre;
	}

	public String getAp_pate_empl() {
		return ap_pate_empl;
	}

	public void setAp_pate_empl(String ap_pate_empl) {
		this.ap_pate_empl = ap_pate_empl;
	}

	public String getAp_mate_empl() {
		return ap_mate_empl;
	}

	public void setAp_mate_empl(String ap_mate_empl) {
		this.ap_mate_empl = ap_mate_empl;
	}

	public String getNo_empl() {
		return no_empl;
	}

	public void setNo_empl(String no_empl) {
		this.no_empl = no_empl;
	}

	public String getNo_area() {
		return no_area;
	}

	public void setNo_area(String no_area) {
		this.no_area = no_area;
	}
	
}
