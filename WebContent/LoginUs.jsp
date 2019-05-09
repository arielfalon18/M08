<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TIENDA</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid" style="background: cadetblue;">
        <h1 class="text-center">FORM Products Available</h1>
        <form action="TiendaR" method="POST">
                <div class="row">
                        <div class="col-3 text-center">
                            <p class="p-3 mb-2 bg-primary text-white pb-3 text-center">IMG1</p>
                            <input  type="checkbox" name="IMG" value="IMG1" >
                        </div>
                        <div class="col-2 text-center">
                            <p class="p-3 mb-2 bg-primary text-white pb-3 text-center">IMG2</p>
                            <input  type="checkbox" name="IMG" value="IMG2">
                        </div>
                        <div class="col-2 text-center">
                            <p class="p-3 mb-2 bg-primary text-white pb-3 text-center">IMG3</p>
                            <input type="checkbox" name="IMG" value="IMG3">
                        </div>
                        <div class="col-2 text-center">
                            <p class="p-3 mb-2 bg-primary text-white pb-3 text-center">IMG4</p>
                            <input  type="checkbox" name="IMG" value="IMG4">
                        </div>
                        <div class="col-3 text-center">
                            <p class="p-3 mb-2 bg-primary text-white pb-3 text-center">IMG5</p>
                            <input  type="checkbox" name="IMG" value="IMG5">
                        </div>
                </div>
                
                <div class="border border-dark mt-4 bg-warning text-center">
                    <h2 >Payment Mode:</h2>
                    <div >
                        <div class="row mb-4">
                            <div class="col-4"> Cash <input type="radio" name="pago" checked value="cash"></div>
                            <div class="col-4">Credito Card <input type="radio" name="pago" value="credito_card"></div>
                            <div class="col-4">Pay pal <input type="radio" name="pago" value="pay_pal"></div>
                        </div>
                    </div>
                </div>
                
                <div class="mt-4">
                    <div class="row">
                        <div class="col-6">
                            <div class="form-group">
                                <label >Nick</label> 
                                <input type="text" class="form-control" name="nick">
                            </div> 
                            <div class="form-group">
                                <label >Quantity</label> 
                                <input type="text" class="form-control" name="cantidad">
                            </div> 
                            
                        </div>
                        <div class="col-6">
                            <div class="form-group"> 
                                <label> Comment</label> 
                                <textarea class="form-control" name="comentario"></textarea>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-6 text-right">
                        <input class="btn btn-primary"  type="submit" value="SEND">
                    </div>
                    <div class="col-6 text-left">
                        <input class="btn btn-danger" type="submit" value="DEL">
                    </div>
                </div>
                <div class="row text-center mt-4">
                    <div class="col-12">
                        <input class="btn btn-info btn-lg btn-block" type="submit" value="Credits">
                    </div>
                </div>
        </form>
    </div>
</body>
</html>