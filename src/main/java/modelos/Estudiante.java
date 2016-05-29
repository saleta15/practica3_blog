package modelos;


import Main.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by saleta on 5/23/2016.
 */
public class Estudiante {
    private String matricula;
    private String nombre;
    private String apellido;
    private String telefono;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Estudiante(String matricula, String nombre, String apellido, String telefono) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public Estudiante() {
    }

    public void cargar(String matricula){
        try {

            Connection con = Conexion.getInstance().getConexion();
            Statement statement = con.createStatement();
            String consulta = "SELECT * FROM ESTUDIANTES WHERE MATRICULA='" + matricula + "'";
            ResultSet rs = statement.executeQuery(consulta);
            while (rs.next()){
                this.matricula = rs.getString("MATRICULA");
                this.nombre = rs.getString("NOMBRE");
                this.apellido = rs.getString("APELLIDOS");
                this.telefono = rs.getString("TELEFONO");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void guardar(){
        try {
            Connection con  = Conexion.getInstance().getConexion();
            Statement statement = con.createStatement();
            String consulta = "SELECT COUNT(*) AS TOTAL FROM ESTUDIANTES WHERE MATRICULA=" + matricula;
            ResultSet rs = statement.executeQuery(consulta);
            String sentencia;
            rs.next();
            if(rs.getInt("TOTAL") > 0 ) {
                sentencia = "UPDATE ESTUDIANTES SET NOMBRE='"+ this.nombre + "',APELLIDOS='" +
                            this.apellido + "',TELEFONO='" + this.telefono + "' WHERE MATRICULA='" + this.matricula + "'";
            }
            else
                sentencia = "INSERT INTO ESTUDIANTES VALUES('" + this.matricula + "','" + this.nombre + "','" + this.apellido + "','" +
                             this.telefono + "')";
            statement.executeUpdate(sentencia);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void borrar(){

        try {
            Connection con  = Conexion.getInstance().getConexion();
            Statement statement = con.createStatement();
            String sentencia = "DELETE FROM ESTUDIANTES WHERE MATRICULA='" + this.matricula + "'";
            statement.executeUpdate(sentencia);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean existe(){
        try {
            Connection con  = Conexion.getInstance().getConexion();
            Statement statement = con.createStatement();
            String consulta = "SELECT COUNT(*) AS TOTAL FROM ESTUDIANTES WHERE MATRICULA=" + matricula;
            ResultSet rs = statement.executeQuery(consulta);
            String sentencia;
            rs.next();
            if(rs.getInt("TOTAL") > 0 ) {
               return true;
            }
            else
                return false;


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String toString(){
        return this.nombre + " " + this.apellido + ": " + this.matricula + ", " +this.telefono;
    }


    public static ArrayList<Estudiante> getEstudiantes(){
        ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
        try {
            Connection con  = Conexion.getInstance().getConexion();
            Statement statement = con.createStatement();
            String consulta = "SELECT * FROM ESTUDIANTES";
            ResultSet rs = statement.executeQuery(consulta);

            while (rs.next()){
                String nombre = rs.getString("NOMBRE");
                String apellido = rs.getString("APELLIDOS");
                String matricula = rs.getString("MATRICULA");
                String telefono = rs.getString("TELEFONO");

                Estudiante estudiante = new Estudiante(matricula, nombre, apellido, telefono);
                estudiantes.add(estudiante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudiantes;
    }

}
