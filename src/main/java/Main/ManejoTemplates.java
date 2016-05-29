package Main;

import freemarker.template.Configuration;
import modelos.Estudiante;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class ManejoTemplates {


    public void manejarTemplates() {

        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(ManejoTemplates.class, "/templates");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);


        get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("estudiantes", Estudiante.getEstudiantes());
            return new ModelAndView(attributes, "listadoEstudiantes.ftl");
        }, freeMarkerEngine);

        get("/estudiante/crear", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "crearEstudiante.ftl");

        }, freeMarkerEngine);

        get("/estudiante/:matricula", (request, response) -> {
            Estudiante estudiante = new Estudiante();
            estudiante.cargar(request.params("matricula"));
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("estudiante", estudiante);
            return new ModelAndView(attributes, "perfilEstudiante.ftl");

        }, freeMarkerEngine);

        get("/estudiante/editar/:matricula", (request, response) -> {
            Estudiante estudiante = new Estudiante();
            estudiante.cargar(request.params("matricula"));
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("estudiante", estudiante);
            return new ModelAndView(attributes, "editarEstudiante.ftl");

        }, freeMarkerEngine);

        post("/procesarEdicion", (request, response) -> {
            Estudiante estudiante = new Estudiante();
            estudiante.cargar(request.queryParams("matricula"));
            System.out.println(request.queryParams("matricula"));
            if(request.queryParams("action").equals("editar")){
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("estudiante", estudiante);
                estudiante.setNombre(request.queryParams("nombre"));
                estudiante.setApellido(request.queryParams("apellido"));
                estudiante.setTelefono(request.queryParams("telefono"));
                estudiante.guardar();
                response.redirect("/estudiante/" + estudiante.getMatricula());
                return "success";
            }
            else{
                estudiante.borrar();
                response.redirect("/");
                return "success";
            }

        });

        post("/procesarInsert", (request, response) -> {
            Estudiante estudiante = new Estudiante(request.queryParams("matricula"),request.queryParams("nombre"),
                                                    request.queryParams("apellido"),request.queryParams("telefono"));
            if(estudiante.existe())
                return "Ya hay un estudiante con esta matrícula.";
            estudiante.guardar();
            Map<String, Object> attributes = new HashMap<>();
            response.redirect("/");
            return "success";

        });


    }
}
