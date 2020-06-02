<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Aviso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        body{
            background-color: navajowhite;
            width: 600px;
            aling-items: center;
            padding-right: 100px;
            padding-left: 450px;
}    
.contenedor{
        float: right;
        background-color:#F4ABF2;
        border:2px solid #FF0000;
        width: 600px;
        text-align: center;
}     
.cabecera{
        background-color:#E5BC7A;
        height:20%;
        text-align: center;
}
.izquierda{
          text-align: center;
        background-color:#BDD2EF;

}
table{
    text-align: center;
}
.pie{
        height:20%;
        background-color:#D3D1C1;
        clear:both;
         width: auto;

}
    </style>
    <body  >
            <div id="contenedor">
                
    <!-- Cabecera -->
    <div class ="cabecera">
        <h2>Anuncios DAO</h2>
  
    </div>
        <div class ="izquierda">
        
        <h1>Avisos Clasificados!</h1>
        <h2><a href="ServletInicio?action=add" >Nuevo</a></h2>
        <table border="1">
             <tr>
                 <th>ID</th>
                <th>TITULO</th>
                <th>CONTENIDO</th>
                <th> </th>
                <th> </th>   
            </tr>
            <c:forEach var="item" items="${avisos}">
            <tr>
                <td>${item.id}</td>
                <td>${item.titulo}</td>
                <td>${item.contenido}</td>
                <td><a href="ServletInicio?action=edit&id=${item.id}">EDITAR</a></td>
                <td><a href="ServletInicio?action=delete&id=${item.id}" onclick="return(cofirm('ESTA SEGURO DE ELIMINAR'))">ELIMINAR</a></td>
            </tr>
            </c:forEach>
        </table>
       
       
        </div>
        
    <!-- Pie de pagina -->
    <div class ="pie">        <p>&copy Emergentes  LUNA</p>
    
   </div>
            </div>
    </body>
</html>
