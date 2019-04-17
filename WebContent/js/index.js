$(document).ready(function() {
	// Evento de botón
	$("#btn_ingresar").click(login);
});

function login() {
	
	// recoge los valores
	var user = $("#user").val();
	var pass = $("#pass").val();
	
	if ( user === '' || pass === '') {
		alert("Ingresar Usuario y/o Contraseña");
	} else {
		
		var body = {
			user: user,
			pass: pass
		};
		
		$.post("LOGIN", body, function(resp) {
			
			if(resp.code == true){
				window.location = "principal";
			} else {
				alert(resp.message);
			}
		
		});
	}
}