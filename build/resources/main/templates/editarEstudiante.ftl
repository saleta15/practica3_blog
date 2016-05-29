<!DOCTYPE html>
<html>
<head>
    <title>Editar Estudiante </title>
    <link href="/css/bootstrap.css" rel="stylesheet" >
</head>
<body>
<div class="container">
    <nav class="navbar navbar-default">

        <ul class="nav navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="../../">Estudiantes</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Crear Estudiante</a>
            </li>

        </ul>
    </nav>
    <h1>Editar Estudiante</h1>
    <form action="/procesarEdicion" method="POST">
    <div class = "panel panel-default">
        <div class = "panel-body">
            <div class="row">
                <div class ="col-md-3">
                    <div class="form-group">
                        <label for="apellido">Apellido:</label>
                        <input type="text" class="form-control" id="apellido" name="apellido" value="${estudiante.apellido}" required>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class ="col-md-3">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" value="${estudiante.nombre}" required>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class ="col-md-3">
                    <div class="form-group">
                        <label for="telefono">Tel&eacute;fono</label>
                        <input type="number" class="form-control" id="telefono" name="telefono" value="${estudiante.telefono}" required>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <input type="hidden" value="${estudiante.matricula}" name = "matricula"/>
    <button type="submit" name="action" value="editar" class="btn btn-primary">Editar</button>
    <button type="submit" name="action" value="borrar" class="btn btn-danger">Borrar</button>
    </form>

</div>
</div>

</body>
</html>