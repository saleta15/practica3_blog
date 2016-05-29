package Main;

import java.sql.Connection;
import org.h2.jdbcx.JdbcDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by saleta on 5/26/2016.
 */

public class Conexion {
    private static Conexion instance = null;
    private static Connection con;

    public static Conexion getInstance() {
        if(instance == null) {
            instance = new Conexion();
            JdbcDataSource ds = new JdbcDataSource();
            ds.setURL("jdbc:h2:~/practica5");
            ds.setUser("sa");
            ds.setPassword("");
            con = null;
            try {
                con = ds.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    protected Conexion() {

    }
    public static Connection getConexion() {
        return con;
    }
}