<!DOCTYPE html>
<html>
<head>
    <title>Nuevo Estudiante </title>
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
    <h1>Crear Estudiante</h1>
    <form action="/procesarInsert" method="POST">
    <div class = "panel panel-default">
        <div class = "panel-body">
            <div class="row">
                <div class ="col-md-3">
                    <div class="form-group">
                        <label for="apellido">Apellido:</label>
                        <input type="text" class="form-control" id="apellido" name="apellido" required >
                    </div>
                </div>
            </div>
            <div class="row">
                <div class ="col-md-3">
                    <div class="form-group">
                        <label for="matricula">Matr&iacute;cula:</label>
                        <input type="text" class="form-control" id="matricula" name="matricula" required>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class ="col-md-3">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" required>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class ="col-md-3">
                    <div class="form-group">
                        <label for="telefono">Tel&eacute;fono</label>
                        <input type="number" class="form-control" id="telefono" name="telefono" required>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <button type="submit" name="action" value="crear" class="btn btn-success">Crear</button>
    </form>

</div>
</div>

</body>
</html>