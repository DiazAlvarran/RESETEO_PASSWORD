/*=============================================
 * CUANDO CARGA LA PÁGINA
 * ============================================*/
$(document).ready(function() {
	// Evento de botón
	$("#btn_ingresar").click(login);
	
	// Evento de Enter
	configEnter();
});

/*=============================================
 * COMPROBAR USUARIO Y CONTRASEÑA
 * ============================================*/
function login() {
	$('#btn_ingresar').attr("disabled", true);
	// recoge los valores
	var user = $("#user").val();
	var pass = $("#pass").val();
	
	// validar que campos no estén vacíos
	if ( user === '' || pass === '') {
		alertify.warning('Ingresar Usuario y/o Contraseña');
	} else {
		// cuerpo para la petición
		var body = {
			user: user,
			pass: pass
		};
		// enviar petición post a "/LOGIN"
		$.post("LOGIN", body, function(resp) {
			// si se inició sesión, ubicar en "/principal";
			if(resp.code == true){
				window.location = "principal";
			} else {
				alertify.error(resp.message);
			}
		});
	}
	$('#btn_ingresar').attr("disabled", false);
}

/*==============================================
 * CONFIGURAR "ENTER" PARA QUE SE PRESIONE BOTÓN
 * ============================================*/
function configEnter(){
	// obtener inputs
	var inputUser = document.getElementById("user");
	var inputPass = document.getElementById("pass");

	// configurar click de botón al presionar enter en inputUser
	inputUser.addEventListener("keyup", function(event) {
  		if (event.keyCode === 13) {
   			event.preventDefault();
   			document.getElementById("btn_ingresar").click();
  		}
	});

	// configurar click de botón al presionar enter en inputPass
	inputPass.addEventListener("keyup", function(event) {
  		if (event.keyCode === 13) {
   			event.preventDefault();
   			document.getElementById("btn_ingresar").click();
  		}
	});
}