/*=============================================
 * VARIABLES GLOBALES
 * ============================================*/
var sistemasActivos = [];

/*=============================================
 * CUANDO CARGA LA PÁGINA
 * ============================================*/
$(document).ready(function() {
	alertify.success("¡BIENVENIDO!");
	
	// Eventos de botones
	$("#btn_cerrar_sesion").click(cerrarSesion);
	$("#btn_recuperar").click(resetear);
	
	// Cargar datos para la página principal
	cabecera_configuracion();
	listarSistemas();
});

/*=============================================
 * LLAMAR A "/inicio"
 * ============================================*/
function cerrarSesion() {
	location.href='inicio';
}

/*=============================================
 * CARGAR DATOS DE USUARIO EN LA CABECERA
 * ============================================*/
function cabecera_configuracion(){
	// obtener elementos
	var nombre_usuario = $("#nombre_usuario");
	var nombre_area = $("#nombre_area");
	
	// obtener los datos y ponerlos en los elementos
	$.get("get_datos", {}, function(resp){
		if(resp.c_t_nombre != null && resp.no_area != null){
			nombre_usuario.html("<i class='fas fa-user fa'></i> " + resp.c_t_nombre);
			nombre_area.html("<i class='fas fa-sitemap fa'></i> " + resp.no_area);
		} else {
			nombre_usuario.html("<i class='fas fa-user fa'></i> No encontrado");
			nombre_area.html("<i class='fas fa-sitemap fa'></i> No encontrado");
		}
	});
}

/*=============================================
 * CARGAR SISTEMAS DEL USUARIO Y MOSTRARLOS
 * ============================================*/
function listarSistemas(){
	var tabla = $("#contenido_tabla"); // obtener elemento tabla
	var contenido =  ""; // creará el contenido que se mostrará en tabla
	
	// obtener sistemas del usuario
	$.get("get_lista", {}, function(resp){
		// obtener los sistemas con estado Activo en un array
		resp.forEach(function(fila){
			if(fila.in_estd == "A"){
				sistemasActivos.push(fila);
			}
		});
		
		// si hay al menos un sistema en estado activo
		if(sistemasActivos.length > 0){
			contenido += "<thead>";
			contenido += "<tr>";
			contenido += "<th scope='col' id='head1'>Sistema</th>";
			contenido += "<th scope='col' id='head2'>Resetear</th>";
			contenido += "</tr>";
			contenido += "</thead>";
			contenido += "<tbody>";
			// añadir los sistemas activos a la tabla
			for(var i = 0; i < arregloSistema.length; i++){
				contenido += "<tr>";
				contenido += "<td>" + arregloSistema[i].sistema + "</td>";
				contenido += "<td>";
				contenido += "<div class='custom-control custom-checkbox mr-sm-2'>";
				contenido += "<input type='checkbox' class='custom-control-input' id='checkbox_" + i + "' name='" + arregloSistema[i].valor + "' value='" + arregloSistema[i].valor + "'>";
				contenido += "<label class='custom-control-label' for='checkbox_" + i + "'></label>";
				contenido += "</div>";
				contenido += "</td>";
				contenido += "</tr>";
			}
			contenido += "</tbody>";
		} else { // si no hay sistemas en estado activo
			contenido += "<thead>";
			contenido += "<tr>";
			contenido += "<th scope='col' id='head1'>No hay sistemas</th>";
			contenido += "</tr>";
			contenido += "</thead>";
			$('#btn_recuperar').hide();
		}
		// mostrar contenido en elemento tabla
		tabla.html(contenido);
	});
}

/*=============================================
 * EVENTO DE BOTÓN PARA RESETEAR LAS CONTRASEÑAS
 * ============================================*/
function resetear(){
	// deshabilitar botones momentáneamente
	$('#btn_recuperar').attr("disabled", true);
	$('#btn_cerrar_sesion').attr("disabled", true);
	
	// verificar que si se ha seleccionado al menos un sistema
	if(noHayCheckSeleccionado()){
		alertify.warning("No ha seleccionado ningún sistema");
	} else {
		alertify.confirm("Se va resetear los sistemas seleccionados. \n¿Quieres continuar?",
			function(){ // Si confirma que va continuar
				// recorrer todos los checkbox
				for(var i = 0; i < sistemasActivos.length; i++){
					var id = "#checkbox_" + i;
					var valor = $(id);
					if( valor.prop('checked') ) { // si el checkbox está seleccionado -> reseteo
					    console.log(sistemasActivos[i]);
					    // enviamos el sistema seleccionado a resetear contraseña
						$.post("reset_password", sistemasActivos[i], function(resp){
							
						});
					}
		        }
				desmarcarTodosLosSistemas(); // desmarcar todos los checkbox
				alertify.success("¡ÉXITO!");
		  	},
		  	function(){ // Si cancela la operación
		    	alertify.error('Ha cancelado la operación');
			}
		);
	}
	// habilitar botones al finalizar el reseteo
	$('#btn_recuperar').attr("disabled", false);
	$('#btn_cerrar_sesion').attr("disabled", false);
}

/*=============================================
 * DEVuELVE TRUE SI NO HAY NI UN SISTEMA SELECCIONADO
 * ============================================*/
function noHayCheckSeleccionado(){
	// recorrer todos los checkbox
	for(var i = 0; i < sistemasActivos.length; i++){
		var id = "#checkbox_" + i;
		var valor = $(id);
		if( valor.prop('checked') ) { // si el checkbox está seleccionado
		    return false;
		}
    }
	return true;
}

/*=============================================
 * DESMARCAR TODOS LOS CHECKBOX
 * ============================================*/
function desmarcarTodosLosSistemas(){
	// recorrer todos los checkbox
	for(var i = 0; i < sistemasActivos.length; i++){
		var id = "#checkbox_" + i;
		var valor = $(id);
		valor.prop('checked', false);
    }
}