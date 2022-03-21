package Semana_9;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class BaseDatos {

    public static void main(String[] args) {
        //Consultar
        int code;
        String name;
        Dba dbl = new Dba("base1.mdb");
        dbl.conectar();
        try {
            // El select indica que permite consultar o extraer la información
            dbl.query.execute("SELECT cuenta,nombre FROM alumnos");
            ResultSet rs = dbl.query.getResultSet();
            System.out.println("Primera Consulta");
            //Imprime los registros que existe en la tabla
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "--->" + rs.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        dbl.desconectar();


        //Agregar Registro
        Dba dba = new Dba("base1.mdb");
        dba.conectar();
        try {

            code = Integer.parseInt(JOptionPane.showInputDialog("Codigo"));
            name = JOptionPane.showInputDialog("Nombre");
            dba.query.execute("INSERT INTO alumnos"
                    + " (cuenta,nombre)"
                    + " VALUES ('" + code + "', '" + name + "')");
            dba.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        dba.desconectar();


        //Modificar
        Dba dbe = new Dba("base1.mdb");
        dbe.conectar();
        try {
            code = Integer.parseInt(JOptionPane.showInputDialog("Codigo a editar:"));
            name = JOptionPane.showInputDialog("Dirección");
            /*
            Update ayuda actualizar la información solicitada
            por la llave primaria con la ayuda
            del where idPrimaria
            el set indica que variable desea cambiar
            su información en conexión con la idPrimaria.
             */
            dbe.query.execute("UPDATE alumnos set direccion='" + name + "' where cuenta=" + code + "");
            dbe.commit();
            // Consultar los cambios
            dbe.query.execute("SELECT cuenta,nombre,direccion FROM alumnos");
            ResultSet rs = dbe.query.getResultSet();
            System.out.println("\nDatos Actualizados, Actualizar un registro");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "--->" + rs.getString(2) + "---->" + rs.getString(3));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        dbe.desconectar();

        //Eliminar
        Dba db = new Dba("base1.mdb");
        db.conectar();
        try {
            code = Integer.parseInt(JOptionPane.showInputDialog("Codigo a eliminar: "));

            db.query.execute("DELETE FROM alumnos where cuenta=" + code + "");
            db.commit();
            /*
            Esto elimina todos los registros
            db.query.execute("DELETE FROM alumnos");
            db.commit();*/
            // Consultar los cambios
            // SELECT * carga todos los campos que contiene la tabla.
            db.query.execute("SELECT * FROM alumnos");
            ResultSet rs = db.query.getResultSet();
            System.out.println("\nEliminar Datos");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "--->" + rs.getString(2) + "---->" + rs.getString(3));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        db.desconectar();


    }
}
