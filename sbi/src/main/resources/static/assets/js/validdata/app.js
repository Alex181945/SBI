
function soloLetras(e){
	key = e.keyCode || e.which;
	tecla = String.fromCharCode(key).toLowerCase();
	letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
	especiales = "8-37-39-46";

	tecla_especial = false
	for(var i in especiales){
		 if(key == especiales[i]){
			 tecla_especial = true;
			 break;
		 }
	 }

	 if(letras.indexOf(tecla)==-1 && !tecla_especial){
		 alert("Ingrese lo indicado");
		 return false;
	 }
 }//Fin de funcion solo letras

 function soloNumeros(e){
	key = e.keyCode || e.which;
	tecla = String.fromCharCode(key).toLowerCase();
	numeros = " 0123456789.";

	if(numeros.indexOf(tecla)==-1){
		 alert("Ingrese lo indicado");
		 return false;
	 }
 }//Fin de funcion solo numeros
