var cont = 0;
var sistemas = [];

$(document).ready(function() {
	// Evento de botón
	$("#btn_cerrar_sesion").click(cerrarSesion);
	$("#btn_recuperar").click(recuperar);

	cabecera_configuracion();
	listarSistemas();
});

function cerrarSesion() {
	
	location.href='inicio';
		
}

function cabecera_configuracion(){
	
	var nombre_usuario = $("#nombre_usuario");
	var nombre_area = $("#nombre_area");
	
	$.get("get_datos", {}, function(resp){
		
		nombre_usuario.html("Usuario: " + resp.c_t_nombre);
		nombre_area.html("Área: " + resp.no_area);
		
	});
	
}

function listarSistemas(){
	
	var tabla = $("#tabla");
	
	var contenido = "";
	
	console.log("listarSistemas");
	
	$.get("get_lista", {}, function(resp){
		
		var llenarTabla = "";
		
		llenarTabla += "<tr>"
		llenarTabla += "<th>Sistemas</th>"
		llenarTabla += "<th>Recuperar</th>"
		llenarTabla += "</tr>"

		resp.forEach(function(fila){
			if(fila.in_estd == "A"){
				cont = cont + 1;
				llenarTabla += "<tr id='tr_"+ cont +"'>";
				llenarTabla += "<td id='td_"+ cont +"'>" + fila.sistema + "</td>";
				llenarTabla += "<td><input type='checkbox' class='cb' id='checkbox_"+ cont +"' name="+ fila.valor +" value="+ fila.valor +"></td>";
				llenarTabla += "</tr>";
			}
			console.log("==========" + fila.sistema + "==========");
		});
		
		tabla.html(llenarTabla);
	});
	
}

function recuperar(){
	var opc = confirm("¿Quieres continuar?");
	if (opc == true) {

		//recorrer todas los checkbox
		for(var i = 1; i <= cont; i++)
        {
			var id = "#checkbox_" + i;
			var valor = $(id);
			if( valor.prop('checked') ) { //si el checkbox está seleccionado lo agrego al array
			    sistemas.push(valor.val());
			}
        }
		
		console.log("==================SISTEMAS SELECCIONADOS====================");
		for(var j = 0; j < sistemas.length; j++){
			console.log(sistemas[j]);
		}
		
		$.post("reset_password", {"sistemas[]": sistemas}, function(resp){
			
		});
		
		/*for(var j = 0; j < sistemas.length; j++){
			console.log(sistemas[j]);
		}*/
		alert("EXITO");
	}
}