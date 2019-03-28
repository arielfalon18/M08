<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrarse</title>
</head>
<body>
	<h1>Introduce porfavor</h1>
    <form action="registroV" method="POST">
        nick <input type="text" name="nick">
        <br>
        <br>
        
        E-mail <input type="text" name="mail">
        <br>
        <br>
        
        pass <input type="text" name="pass"><br>
        <br>
        <input type="submit" value="enviar">
    </form>
</body>
</html>