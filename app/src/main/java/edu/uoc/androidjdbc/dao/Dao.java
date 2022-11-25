package edu.uoc.androidjdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.uoc.androidjdbc.model.Persona;

public class Dao {
    private Connection conexion;

    //Constantes. Deberan estar en una clase de constanes en el pck utils
    public static final String SCHEMA_NAME = "edtwiam";
    public static final String CONNECTION = "jdbc:mysql://db4free.net/" +
            SCHEMA_NAME +
            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    public static final String USER_CONNECTION = "edtwiam";
    public static final String PASS_CONNECTION = "2wiamedt";

    public static final String GET_ALL_PERSONAS = "select * from persona";

    public void connectar() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName("org.gjt.mm.mysql.Driver").newInstance();
        String url = CONNECTION;
        String user = USER_CONNECTION;
        String pass = PASS_CONNECTION;
        conexion = DriverManager.getConnection(url, user, pass);
    }

    public void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }

    public ArrayList<Persona> getAll() throws SQLException {
        ArrayList<Persona> personaList = new ArrayList<>();

        try (Statement st = conexion.createStatement()) {
            try (ResultSet rs = st.executeQuery(GET_ALL_PERSONAS)) {
                while (rs.next()) {
                    Persona persona = new Persona(rs.getInt(1), rs.getString(2),
                            rs.getString(3), rs.getString(4), rs.getString(5));
                    personaList.add(persona);
                }
            }
        }
        return personaList;
    }
}
