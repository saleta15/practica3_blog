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
                <a class="nav-link" href="">Estudiantes</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/estudiante/crear">Crear Estudiante</a>
            </li>


        </ul>
    </nav>
    <h1>Estudiantes</h1>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Apellido</th>
            <th>Matr&iacute;cula</th>
            <th>Nombre</th>
            <th>Tel&eacute;fono</th>
        </tr>
        </thead>
        <tbody>
        <#list estudiantes as estudiante>
            <tr>
                <td>${estudiante.apellido}</td>
                <td>${estudiante.matricula}</td>
                <td>${estudiante.nombre}</td>
                <td>${estudiante.telefono}</td>
                <td style="width: 7%"><a href="estudiante/${estudiante.matricula}"><button type="button" class="btn btn-primary">Ver Perfil</button></a>
                    </td>
            </tr>
        </#list>

        </tbody>
    </table>
</div>
</div>

</body>
</html>