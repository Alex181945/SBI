<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
 <title>Index</title>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
</head>
<style>
    body
    {
        background:url(3.png) #2b2b2a;
        background-position: left;
        width:30;
        height: 30;
        

    }

    form
    {
        background: #gray;
        width:360px;
        border:1px solid #4e4d4d; 
        border-radius:3px;
        -moz-border-radius:3px;
        -webkit-border-radius:3px;
        box-shadow:insert 0 0 10px #blue;
        margin:100px auto; 
    }
    form h1
    {
        text-align:center;
        color: black;
        font-weight:normal;
        font-size:40pt;
        margin:30px 0px;
        font-family: 'Minion Pro', sans-serif; /*Google fonts*/
    }
    form input
    {
        width:280px;
        height:35px;
        padding:0px 10px;
        margin:10px 30px;
        color:#512C1D;
        text-align:center;
    }
    form button
    {
             
        width:130px;
        margin:20px 0px 30px 30px;
        height: 50px;
        background: #512C1D; /* Old browsers */
background: -moz-linear-gradient(top, #512C1D 0%, #512C1D 50%, #512C1D 51%, #512C1D 100%); /* FF3.6-15 */
background: -webkit-linear-gradient(top, #512C1D 0%,#512C1D 50%,#512C1D 51%,#512C1D 100%); /* Chrome10-25,Safari5.1-6 */
background: linear-gradient(to bottom, #512C1D 0%,#512C1D 50%,#512C1D 51%,#512C1D 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#512C1D', endColorstr='#512C1D',GradientType=0 ); /* IE6-9 */ /*Google colorsize*/
        border:1px solid#232323;
        color:white;
        box-shadow: 0px 2px 0px #000;
        -moz-box-shadow: 0px 2px 0px #000;
        -webkit-box-shadow: 0px 2px 0px #000;
        border-radius:3px;
        -moz-border-radius:3px;
        -webkit-border-radius:3px;
        
    }
    form button:hover
    {
        align: center; 
        background:#512C1D;
        
    }

    form button:active
    {
        background: white; /* Old browsers */
background: -moz-linear-gradient(top, #512C1D 0%, #512C1D 49%, #512C1D 50%, #512C1D 100%); /* FF3.6-15 */
background: -webkit-linear-gradient(top, #512C1D 0%,#512C1D 49%,#512C1D 50%,#512C1D 100%); /* Chrome10-25,Safari5.1-6 */
background: linear-gradient(to bottom, #512C1D 0%,#512C1D 49%,#512C1D 50%,#512C1D 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#512C1D', endColorstr='#512C1D',GradientType=0 ); /* IE6-9 */
    }
    pre
    {
      width: "5px";
      height:"5px";
    }
</style>

<pre style="background-color:#646569">
    <left><img src="image1.jpg" alt="image" width="450px" height="110px">
        </left>
        
        </pre>

      <body>   
            
    <!--nav class="navbar navbar-default" >
            <div class="container-fluid">
              <div class="navbar-header">
                <a class="navbar-brand" href="#">Tickets</a>
              </div>
              <ul class="nav navbar-nav">
                <li class="active"><a href="#">Index</a></li>
                <li><a href="#">Resguardantes</a></li>
                <li><a href="#">Notificaciones</a></li>
                <li><a href="#">Estadísticas</a></li>
                <br>
                 </ul>
              
            </div>
                                
          </nav-->
         
          <!--input type="text" id="searchterm" placeholder="Buscar" />
                        <button type="button" id="search">Buscar</button-->
        <fieldset>
          <div class="container text-center">
              <center><h1>"SISTEMA DE ADMINISTRACIÓN DE BIENES INFORMÁTICOS DEL SENADO 
                            DE LA REPÚBLICA"</h1></center>
              <form action="menu.html" method = "post">
        <h1>Ingresa al Sistema</h1>
        <input type="text" max-lenght= "20" placeholder= "Ingrese el nombre de usuario: " name = "user" autocomplete="off" required> 
        <input type="password" max-lenght= "20" placeholder= "Ingrese la contraseña: " name = "pw" autocomplete="off" required>
        <button type ="submit" max-lenght= "18" name="login" value="Entrar"> Acceder
        <button type="submit" max-lenght= "18"  name="Salir" value="Salir">  Salir
    </form>  
     
    </fieldset>   
               
</body>
<footer class="container-fluid text-center">
             
                    <b><p>Dirección de Soporte Técnico 
                    <br> 2018</p></b>
                  </footer>
</html>