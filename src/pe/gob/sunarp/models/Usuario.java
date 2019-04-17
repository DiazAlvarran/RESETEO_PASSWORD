package pe.gob.sunarp.models;

public class Usuario {
	private String co_empl; //codigo de empleado
	private String c_t_nombre; //nombre completo de empleado
	private String ap_pate_empl; //apellido paterno
	private String ap_mate_empl; //apellido materno
	private String no_empl; //nombre
	private String osuser; //usuario de red
	private String co_usua; //usuario de bd
	private String in_estd; //estado
	private String co_area; //codigo de area
	private String no_area; //nombre de area
	private String DNI; //DNI de empleado
	
	public Usuario() {
		
	}
	
	public Usuario(String co_empl, String c_t_nombre, String ap_pate_empl, String ap_mate_empl, String no_empl, String osuser,
			String co_usua, String in_estd, String co_area, String no_area, String DNI) {
		super();
		this.co_empl = co_empl;
		this.c_t_nombre = c_t_nombre;
		this.ap_pate_empl = ap_pate_empl;
		this.ap_mate_empl = ap_mate_empl;
		this.no_empl = no_empl;
		this.osuser = osuser;
		this.co_usua = co_usua;
		this.in_estd = in_estd;
		this.co_area = co_area;
		this.no_area = no_area;
		this.DNI = DNI;
	}
	
	public String getCo_empl() {
		return co_empl;
	}
	public void setCo_empl(String co_empl) {
		this.co_empl = co_empl;
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
	public String getOsuser() {
		return osuser;
	}
	public void setOsuser(String osuser) {
		this.osuser = osuser;
	}
	public String getCo_usua() {
		return co_usua;
	}
	public void setCo_usua(String co_usua) {
		this.co_usua = co_usua;
	}
	public String getIn_estd() {
		return in_estd;
	}
	public void setIn_estd(String in_estd) {
		this.in_estd = in_estd;
	}
	public String getCo_area() {
		return co_area;
	}
	public void setCo_area(String co_area) {
		this.co_area = co_area;
	}
	public String getNo_area() {
		return no_area;
	}
	public void setNo_area(String no_area) {
		this.no_area = no_area;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String DNI) {
		this.DNI = DNI;
	}
}
