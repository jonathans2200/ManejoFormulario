<%-- 
    Document   : PaginaPrincipal
    Created on : 10/05/2021, 20:16:21
    Author     : jonat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>                   


    <header>
        <nav class="navbar navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand"></a>
                <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="#" class="nav-link px-2 link-secondary">BIENVENIDO</a></li>
                </ul>
                <div class="col-7 mx-auto p-4">
                    <nav class="navbar navbar-light bg-light">
                        <div class="container-fluid">
                            <form action="/ManejoFormulario/BuscarTelefono" method="post" class="d-flex">
                                <input class="form-control me-2" name="buscar" type="text" placeholder="Search" aria-label="Search">
                                <button class="btn btn-outline-success" type="submit">BUSCAR</button>
                            </form>
                        </div>
                    </nav>
                </div>
            </div>
        </nav>
    </header>

    <body>
        <br><br><br>
        <div class="row">
            <div class="col-md-3">
                <div class="card">
                    <div class="card-tittle"></div>
                    <h3 class="card card-tittle"> DATOS DEL USUARIO</h3>
                    <div class="card-body"></div>
                    <c:set  var="lista" scope="request" value="${usuario}"/>
                    <div class="row">
                        <div class="form-group">
                            <label>CEDULA: </label>
                            <p> ${lista.cedula}</p>

                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group">
                            <label>NOMBRE: </label> 
                            <p> ${lista.nombre}</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group">
                            <label>APELLIDO: </label> 
                            <p> ${lista.apellido}</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group">
                            <label>CORREO: </label> 
                            <p> ${lista.correo}</p>
                        </div>
                    </div>
                    <!-- comment -->
                    <div class="card-footer"></div>

                </div>

            </div>
            <div class="col-md-7">
                <div class="card">
                    <div class="card-tittle"></div>
                    <h2>LISTADO DE TELEFONOS</h2>
                    <div class="card-body"></div>
                    <c:set  var="listas" scope="request" value="${personas}"/>
                    <table class="table">
                        <thead class="table-dark">

                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">TELEFONO</th>
                                <th scope="col">OPERADORA</th>
                                <th scope="col">TIPO</th>
                                <th scope="col">OPCIONES</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach var="t" items="${listas}">
                                <tr>
                                    <td >${t.codigo}</td>
                                    <td>${t.numero}</td>
                                    <td>${t.tipo}</td>
                                    <td>${t.operadora}</td>
                                    <td><a href="/ManejoFormulario/ModificarTelefonoController?codigo=${t.codigo}" type="button" class="btn btn-primary">MODIFICAR</a>
                                        <button type="button" class="btn btn-danger">ELIMINAR</button>
                                </tr>  
                            </c:forEach>



                        </tbody>
                    </table>
                    <div class="card-footer"></div>

                </div>

            </div>
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
