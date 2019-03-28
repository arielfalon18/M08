<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TIENDA</title>
<link rel="stylesheet" href="nuevo.css">
</head>
<body>
	<h1 class="centroT">FORM Products Available</h1>
    <form action="TiendaR" method="POST">
            <div class="columnas1">
                    <div>
                        <p class="borde">IMG1</p>
                        <input class="centro" type="checkbox" name="IMG" value="IMG1" >
                    </div>
                    <div>
                        <p class="borde">IMG2</p>
                        <input class="centro" type="checkbox" name="IMG" value="IMG2">
                    </div>
                    <div>
                        <p class="borde">IMG3</p>
                        <input class="centro" type="checkbox" name="IMG" value="IMG3">
                    </div>
                    <div>
                        <p class="borde">IMG4</p>
                        <input class="centro" type="checkbox" name="IMG" value="IMG4">
                    </div>
                    <div>
                        <p class="borde">IMG5</p>
                        <input class="centro" type="checkbox" name="IMG" value="IMG5">
                    </div>
            </div>
            
            <div class="colorB">
                <h2 class="textA">Payment Mode:</h2>
                <div class="centrarfo">
                    <div class="centro"> Cash <input type="radio" name="pago" checked value="cash"></div>
                    <div class="centro">Credito Card <input type="radio" name="pago" value="credito_card"></div>
                    <div class="centro">Pay pal <input type="radio" name="pago" value="pay_pal"></div>
                </div>
            </div>
            <div class="PocisionF">
                <div> <label class="colorY">Nick</label> <input type="text" name="nick"></div> 
                <div> <label class="colorY"> Comment</label> <textarea name="comentario"></textarea></div>
            </div>
            
            <label >Quantity</label> <input type="text" name="cantidad">
            <div class="textA">
                <input  type="submit" value="SEND"><input type="submit" value="DEL">
            </div>
            <br>
            <input class="centro ncredit" type="submit" value="Credits">
    </form>
</body>
</html>