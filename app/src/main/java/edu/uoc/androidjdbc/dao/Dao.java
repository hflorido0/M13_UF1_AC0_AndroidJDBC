package edu.uoc.androidjdbc.dao;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.uoc.androidjdbc.model.Persona;

public class Dao extends AsyncTask<Void, Void, Map<String, String>> {

    //Constantes. Deberan estar en una clase de constanes en el pck utils
    public static final String SCHEMA_NAME = "edtwiam";
    public static final String CONNECTION = "jdbc:mysql://db4free.net/" +
            SCHEMA_NAME +
            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    public static final String USER_CONNECTION = "edtwiam";
    public static final String PASS_CONNECTION = "2wiamedt";

    public static final String GET_ALL_PERSONAS = "select * from persona";

    List<Persona> people = new ArrayList<>();

    @Override
    protected Map<String, String> doInBackground(Void... voids) {
        Map<String, String> info = new HashMap<>();

        Statement statement = null;
        try (Connection connection = DriverManager.getConnection(CONNECTION, USER_CONNECTION, PASS_CONNECTION)) {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_PERSONAS);

            while (resultSet.next()) {

                info.put("id", resultSet.getString("id"));
                info.put("DNI", resultSet.getString("DNI"));
                info.put("nom", resultSet.getString("nom"));
                info.put("cognoms", resultSet.getString("cognoms"));
                info.put("direccio", resultSet.getString("direccio"));

                System.out.println("DATA2: " + resultSet.getInt(1) +
                        resultSet.getString(2) +
                        resultSet.getString(3) +
                        resultSet.getString(4) +
                        resultSet.getString(5));

                people.add(new Persona(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return info;
    }
}
