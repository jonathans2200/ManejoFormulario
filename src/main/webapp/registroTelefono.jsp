<%-- 
    Document   : ModificarTelefono
    Created on : 14/05/2021, 18:37:21
    Author     : jonat
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>REGISTRAR TELEFONO</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/f90d3bf50d.js" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="recursos/estilos.css" type="text/css"/>


    </head>
    <body>
        <h1>REGISTRAR TELEFONO</h1>
        <form  action="/ManejoFormulario/NuevoTelefonoController" method="post">



            <section id="actions" class="py-4 mb-4 bg-light">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3">
                            <a href="index.jsp" class="btn btn-ligth btn-block">
                                <i class="fas fa-arrow-left"></i> Regresar al inicio
                            </a>
                        </div>
                        <div class="col-md-3">
                            <button type="submit" class="btn btn-success btn-block">
                                <i class="fas fa-check"></i> GUARDAR TELEFONO
                            </button>
                        </div>

                    </div>
                </div>
            </section>
            <section id="detalles">

                <div class="container align-items-center">
                    <div class="row col-md-8">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>INGRESAR LOS DATOS</h4>
                                </div>

                                <c:set  var="t" scope="request" value="${total}"/>


                                <div class="card-body">
                                    <div class="form-group">
                                        

                                        <input type="hidden"  class="form-control" name="codigo" value="${t}" >

                                    </div> 
                                    <div class="form-group">
                                        <label for="numero">NUMERO</label>
                                        <input type="text" class="form-control" name="numero"  >
                                    </div> 
                                    <div class="form-group">
                                        <label for="tipo">TIPO</label>
                                        <input type="text" class="form-control" name="tipo"  >
                                    </div> 
                                    <div class="form-group">
                                        <label for="operadora">OPERADORA</label>
                                        <input type="text" class="form-control" name="operadora" >
                                    </div> 
                                    <c:set  var="usuario" scope="request" value="${usuario}"/>
                                    <div class="form-group">

                                        <input type="hidden" class="form-control" name="cedula"  value="${usuario.cedula}">
                                    </div>



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
