<%-- 
    Document   : buscarPersona
    Created on : 16/05/2021, 17:53:58
    Author     : jonat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>

        <div class="row">
            <div class="col-md-3">
                <div class="card">
                    <div class="card-tittle"></div>
                    <h3 class="card card-tittle"> PERSONA ENTONTRADA</h3>
                    <div class="card-body"></div>
                    <c:set  var="lista" scope="request" value="${datos}"/>
                    <div class="row">
                        <div class="form-group">
                            <label>CEDULA: </label>
                            <p> ${lista.cedula}</p>

                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group">
                            <label>NOMBRE COMPLETO: </label> 
                            <p> ${lista.nombre} ${lista.apellido}</p>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group">
                            <label>CORREO ELECTRONICO: </label> 
                            <p> ${lista.correo}</p>
                            <a href="mailto:${lista.correo}" type="button" class="btn btn-danger">ENVIAR CORREO</a>
                        </div>
                    </div>
                    <!-- comment -->


                </div>

            </div>
                         <div class="col-md-7">
                <div class="card">
                    <div class="card-tittle"></div>
                    <h2>TELEFONOS DE LA PERSONA </h2>
                    <div class="card-body"></div>
                    <c:set  var="lista" scope="request" value="${personas}"/>
                    <table class="table">
                        <thead class="table-dark">

                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">TELEFONO</th>
                                <th scope="col">OPERADORA</th>
                                <th scope="col">TIPO</th>
                                <th scope="col"> </th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="t" items="${telefono}">
                                <tr>
                                    <td >${t.codigo}</td>
                                    <td>${t.numero}</td>
                                    <td>${t.operadora}</td>
                                    <td>${t.tipo}</td>
                                    <td><a href="tel:+593${t.numero} type="button" class="btn btn-primary">CONTACTAR</a>
                                        
                                </tr>  
                            </c:forEach>
                        </tbody>
                    </table>
                 

            </div>
        </div>

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
