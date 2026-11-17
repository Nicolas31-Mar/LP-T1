<%@ page import="java.util.List,entidades.Proyectos" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registrar Proyectos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f5f6f7;
        }
        .card {
            border-radius: 10px;
        }
        .btn-group-custom button {
            margin-right: 5px;
            margin-bottom: 5px;
        }
    </style>
</head>
<body>

<div class="container mt-5">
    <div class="row">

        <!-- FORMULARIO -->
        <div class="col-md-4">
            <div class="card p-4 shadow-sm">
                <h4 class="mb-3">Registrar Proyectos</h4>

                <%
                String error = (String) request.getAttribute("error");
                String mensaje = (String) request.getAttribute("mensaje");
                if (error != null) {
                %>
                    <p class="text-danger"><%= error %></p>
                <%
                }
                if (mensaje != null) {
                %>
                    <p class="text-success"><%= mensaje %></p>
                <%
                }
                %>

                <form method="post" action="ProyectoServlet">
                    <div class="mb-3">
                        <label for="nombre" class="form-label">Nombre del Proyecto</label>
                        <input id="nombre" name="nombre" type="text" class="form-control" minlength="4" maxlength="60" required>
                    </div>

                    <div class="mb-3">
                        <label for="descripcion" class="form-label">Descripción técnica (Opcional)</label>
                        <textarea id="descripcion" name="descripcion" class="form-control" rows="3"></textarea>
                    </div>

                    <div class="mb-3">
                        <label for="fecInicio" class="form-label">Fecha de inicio</label>
                        <input id="fecInicio" name="fecInicio" type="date" class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label for="fecCulminacion" class="form-label">Fecha de culminación</label>
                        <input id="fecCulminacion" name="fecCulminacion" type="date" class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label for="asesor" class="form-label">Asesor Técnico (Nombres y Apellidos)</label>
                        <input id="asesor" name="asesor" type="text" class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label for="presupuesto" class="form-label">Presupuesto Asignado</label>
                        <input id="presupuesto" name="presupuesto" type="number" class="form-control" min="0.01" step="0.01" required>
                    </div>

                    <div class="btn-group-custom">
                        <button type="submit" class="btn btn-primary">Registrar</button>
                        <button type="submit" name="accion" value="listar" formnovalidate class="btn btn-warning">Listar</button>
                        <button type="reset" class="btn btn-secondary">Limpiar</button>
                    </div>
                </form>
            </div>
        </div>

        <!-- TABLA -->
        <div class="col-md-8">
            <div class="card p-4 shadow-sm">
                <h4 class="mb-3">Proyectos Disponibles</h4>

                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead class="table-light">
                            <tr>
                                <th>Id</th>
                                <th>Nombre del Proyecto</th>
                                <th>Descripción</th>
                                <th>Inicio</th>
                                <th>Fin</th>
                                <th>Asesor Técnico</th>
                                <th>Presupuesto</th>
                            </tr>
                        </thead>
                        <tbody>
                        <%
                        List<Proyectos> lista = (List<Proyectos>) request.getAttribute("proyectos");
                        if (lista != null && !lista.isEmpty()) {
                            for (Proyectos proyecto : lista) {
                        %>
                            <tr>
                                <td><%= proyecto.getId() %></td>
                                <td><%= proyecto.getNombre() %></td>
                                <td><%= proyecto.getDescripcion() %></td>
                                <td><%= proyecto.getFecInicio() %></td>
                                <td><%= proyecto.getFecCulminacion() %></td>
                                <td><%= proyecto.getAsesor() %></td>
                                <td>S/ <%= proyecto.getPresupuesto() %></td>
                            </tr>
                        <%
                            }
                        }
                        %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </div>
</div>

</body>
</html>
