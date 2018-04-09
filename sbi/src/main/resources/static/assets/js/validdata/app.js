
var getData = function(){

	var name = document.getElementById("name").value;
	var edad = document.getElementById("edad").value;
	var sex = document.getElementById("sex").value;
	var level = document.getElementById("level").value;	

	
	if (name == "" ) {
		alert("Escriba un nombre correcto");
				
	}else if (edad == "") {
		//document.getElementById("ape").focus();
		alert("Escriba su edad");
		
	}else if(level == ""){
		alert("Seleccione nivel");
	}else{
		decision();
	}

	
} //Fin de funcion getData

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

 var decision = function(){

	var name = document.getElementById("name").value;
	var edad = document.getElementById("edad").value;
	var sex = document.getElementById("sex").value;
	var level = document.getElementById("level").value;	

	
	 if (edad > 1 && edad <= 5 ) {
		 if (level > 11.5 && level <= 15 ) {
			good();
		 }else if(level < 11.5){
			badluck();
		 } else{
			diferent();
		 }
	 }else if(edad > 5 && edad <= 10){
		 if (level > 12.6 && level <= 15.6) {
			good();
		 }
		 else if (level < 12.6){
			badluck();
		 }else{
			 diferent();
		 }
		
	 }else if (edad >10 && edad <= 15) {
		 if (level > 13 && level <= 15.5) {
			good();
		 }
		 else if (level < 13) {
			badluck();
		 }else{
			 diferent();
		 }
		 
	 }else if(edad > 15 && sex == "Femenino"){
		 if (level >= 12 && level <= 16) {
			 good();		 
		 }
		 else if (level < 12){
			 badluck();		 
		 }else{
		 	diferent();
		 }

	 }else if (edad > 15 && sex == "Masculino") {
			if (level >= 14 && level <= 18 ) {
				good();
			}
			else if(level < 14) {
				badluck();
			} else{
				diferent();
			}
	 }
	 
 }//Termino de funcion decision

 var good = function(){

	var name = document.getElementById("name").value;
	var edad = document.getElementById("edad").value;
	var sex = document.getElementById("sex").value;
	var level = document.getElementById("level").value;

	var lis = [ "Nombre del Paciente: " + name + '\n' + "Edad: "+ edad + '\n' + "Sexo: " + 
	sex + '\n' + "Nivel de homoglobina: " + level + '\n' + "Diagnostico: Nivel estable"];

	alert(lis);
 }

 var badluck = function(){
	var name = document.getElementById("name").value;
	var edad = document.getElementById("edad").value;
	var sex = document.getElementById("sex").value;
	var level = document.getElementById("level").value;

	var lis = [ "Nombre del Paciente: " + name + '\n' + "Edad: "+ edad + '\n' + "Sexo: " + 
	sex + '\n' + "Nivel de homoglobina: " + level + '\n' + "Diagnostico : Positivo con Anemia :("];
	alert(lis);
 }

 var diferent = function(){
	var name = document.getElementById("name").value;
	var edad = document.getElementById("edad").value;
	var sex = document.getElementById("sex").value;
	var level = document.getElementById("level").value;

	var lis = [ "Nombre del Paciente: " + name + '\n' + "Edad: "+ edad + '\n' + "Sexo: " + 
	sex + '\n' + "Nivel de homoglobina: " + level + '\n' + "Diagnostico : Negativo"];
	alert(lis);
 }