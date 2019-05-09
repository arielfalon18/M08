<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrarse</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<div class="container-fluid">
	<h1>Introduce porfavor</h1>
    <form action="registroV" method="POST">
	   <div class="form-group">
	    <label >Nick</label>
	    <input type="text"class="form-control"  name="nick" placeholder="Insertar Nick">
	  </div>
	  
	  <div class="form-group">
	    <label >Mail</label>
	    <input type="text" class="form-control" name="mail" placeholder="Insertar Mail">
	  </div>
        
       <div class="form-group">
	    <label >Password</label>
	    <input type="text" class="form-control" name="pass" placeholder="Insertar Password">
	  </div>
        <input class="btn btn-primary" type="submit" value="enviar">
    </form>
</div>
	
</body>
</html>