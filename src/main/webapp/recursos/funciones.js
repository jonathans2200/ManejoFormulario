function validarForma(forma){
    var usuario =forma.usuario;
    
    if(usuario.value=""){
        alert("INGRESAR EL USUARIO")
        usario.focus();
        usuario.select();
        return false;
    }
    
var pass =forma.password;
    if(pass.value="" ||pass.value.length <3){
        alert("INGRESAR EL USUARIO")
        pass.focus();
        pass.select();
        return false;
    }

var nombre =forma.nommbre;
    if(nombre.value=""){
        alert("INGRESAR EL NOMBRE")
        nombre.focus();
        nombre.select();
        return false;
    }
    
    var nombre =forma.nommbre;
    if(nombre.value=""){
        alert("INGRESAR EL NOMBRE")
        nombre.focus();
        nombre.select();
        return false;
    }
}