<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: APRENDIZ
  Date: 18/5/2023
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <!-- Caracteres especiales -->
    <meta charset="utf-8">
    <!-- author -->
    <meta name="author" content="Andres Sarmiento">
    <!-- Description -->
    <meta name="description" content="jajaja">
    <!-- Keywords -->
    <meta name="Keywords" content="Registro de categoria, formulario de categoria, crear categoria, registrar en linea categoria" >
    <!-- miimum responsive viewport -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Title -->
    <title>Register category .:. SARMIREPUESTOS</title>
    <!-- favicon -->
    <link rel="shortcut icon" href="./img/logo.png" type="image/x-icon">
    <!-- ESTILOS -->
    <!-- bootstrap  -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <!-- incons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <!-- css -->
    <link rel="stylesheet" href="./css/category.css">
</head>
<body>
<div class="wrapper">
    <div class="d-flex justify-content-around" >
        <img src="./img/logo.png" alt="" height="150px">
    </div>
    <div class="title">
        Register Category
    </div>
    <form action="registerCategory"  method="post" class="form">
        <div >
            <div class="inputfield">
                <label>Category Name</label>
                <input type="text" class="input" name="category_name" required pattern="[A-Za-z]{2,40}">
            </div>

            <div class="inputfield">
                <input type="submit" value="Register" class="btn">
            </div>
            <p class="mt-3 mb-3 text-mutrd">Todos los derechos reservados SARMIREPUESTOS ©<%=displayDate()%>
            </p>

</div>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<%!
    public String displayDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY");
        Date date= Calendar.getInstance().getTime();
        return dateFormat.format(date);
    }
%>
</body>
</html>
