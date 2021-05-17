<%-- 
    Document   : login
    Created on : 06/05/2021, 21:24:34
    Author     : jonat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div class="card " style="width: 18rem;">

            <div class="card-body">
                <form action="LoginServlet" method="get">
                    <div class=" form-group  col-sm-12">
                        <label for="usuario">USUARIO</label> <input type="text"
                                                                    class="form-control" id="usuario" name="usuario"
                                                                    aria-describedby="emailHelp">
                    </div>
                    <div class=" form-group col-12">
                        <label for="pass">Password</label> <input type="password"
                                                                  class="form-control" id="pass" name="pass">
                    </div>


            </div>
            <div class="card-footer">

                <button type="submit" class="btn btn-primary ">INGRESAR</button>
                <div class="col-md-3">
                    <a href="/ManejoFormulario/registroUsuario.jsp" class="btn btn-ligth btn-block">
                        <i class="fas fa-arrow-left"></i> CREAR USUARIO
                    </a>
                </div>
            </div>
        </form>
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
