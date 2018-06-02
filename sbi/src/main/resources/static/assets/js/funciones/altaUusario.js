function altaUsuario(text){
      var num= text.value
      var div='';
      for (var i=0;i<num;i++){ 
           var cont=i+1;
           div+="<br> Input text "+cont+"<input maxlength='5' name='inputTextMulti[]' size='6' type='text' />&nbsp;";
      }

      document.getElementById("divMultiInputs").innerHTML=div;
}