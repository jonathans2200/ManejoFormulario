<%-- 
    Document   : ModificarTelefono
    Created on : 14/05/2021, 18:37:21
    Author     : jonat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>REGISTRAR PERSONA</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
        <link rel="stylesheet" href="recursos/estilos.css" type="text/css"/>


    </head>
    <body>
  
        <form  action="/ManejoFormulario/RegistroPersona" method="post">
        </div>


        <section id="actions" class="py-4 mb-4 bg-light">
            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        <a href="index.jsp" class="btn btn-ligth btn-block">
                            <i class="fas fa-arrow-left"></i> REGRESAR
                        </a>
                    </div>
                    <div class="col-md-3">
                        <button type="submit" class="btn btn-success btn-block">
                            <i class="fas fa-check"></i> GUARDAR USUARIO
                        </button>
                    </div>

                </div>
            </div>
        </section>
        <section id="detalles">

            <div class="container">
                <div class="row col-md-7">
                    <div class="col">
                        <div class="card">
                            <div class="card-header">
                                <h4>REGISTRO DE USUARIO</h4>
                            </div>
                            <div class="card-body">
                                <div class="form-group">
                                    <label for="codigo">CEDULA</label>

                                    <input type="number" class="form-control" name="cedula" >
                                </div> 
                                <div class="form-group">
                                    <label for="numero">NOMBRE</label>
                                    <input type="text" class="form-control" name="nombre"  >
                                </div> 
                                <div class="form-group">
                                    <label for="codigo">APELLIDO</label>
                                    <input type="text" class="form-control" name="apellido"  >
                                </div> 
                                <div class="form-group">
                                    <label for="codigo">CORREO</label>
                                    <input type="text" class="form-control" name="correo" >
                                </div> 
                                <div class="form-group">
                                    <label for="codigo">USUARIO</label>
                                    <input type="text" class="form-control" name="usuario" >
                                </div> 
                                <div class="form-group">
                                    <label for="codigo">PASSWORD</label>
                                    <input type="text" class="form-control" name="contrasena" >
                                </div> 
                                </form>

                            </div>
                        </div>
                    </div>

                </div>

            </div>
        </section>
    </form>
</body>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
crossorigin="anonymous"></script>
<script
    src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
    integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
crossorigin="anonymous"></script>
<script
    src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
    integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
crossorigin="anonymous"></script>
</html>
