package Semana_9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Dba {
    private final String base_datos;
    private Connection dbcon;
    public Statement query;

    public Dba(String base_datos) {
        this.base_datos = base_datos;
    }


    public void conectar() {
        try {
            //Conexión
            String driver = "jdbc:ucanaccess://";
            dbcon = DriverManager.getConnection(driver + base_datos, "", "");
            query = dbcon.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void desconectar() {
        try {
            query.close();
            dbcon.close();
        } catch (Exception ignored) {
        }
    }

    public void commit() {
        try {
            dbcon.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
