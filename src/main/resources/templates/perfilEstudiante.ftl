<!DOCTYPE html>
<html>
<head>
    <title>Información Estudiante </title>
    <link href="/css/bootstrap.css" rel="stylesheet" >
</head>
<body>
<div class="container">
    <nav class="navbar navbar-default">

        <ul class="nav navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/../../">Estudiantes</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Crear Estudiante</a>
            </li>


        </ul>
    </nav>
    <h1>Datos del Estudiante</h1>


    <form action="/procesarEdicion" method="POST">
    <div class = "panel panel-default">
        <div class = "panel-body">
            <div class="row">
                <div class="col-md-1">
                    <label>Apellido:</label>
                </div>
                <div class="col-md-3">
                    <p>${estudiante.apellido}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-1">
                    <label>Matr&iacute;cula:</label>
                </div>
                <div class="col-md-3">
                    <p>${estudiante.matricula}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-1">
                    <label>Nombre:</label>
                </div>
                <div class="col-md-3">
                    <p>${estudiante.nombre}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-1">
                    <label>Tel&eacute;fono:</label>
                </div>
                <div class="col-md-3">
                    <p>${estudiante.telefono}</p>
                </div>
            </div>

        </div>
    </div>
    <a href="editar/${estudiante.matricula}"><button type="button" class="btn btn-primary">Editar</button></a>

        <button type="submit" name="action" value="borrar" class="btn btn-danger">Borrar</button>
        <input type="hidden" value="${estudiante.matricula}" name="matricula"/>
    </form>


</div>
</div>

</body>
</html>