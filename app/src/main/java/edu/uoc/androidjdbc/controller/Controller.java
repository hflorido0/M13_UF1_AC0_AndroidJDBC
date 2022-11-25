package edu.uoc.androidjdbc.controller;

import java.sql.SQLException;

import edu.uoc.androidjdbc.dao.Dao;
import edu.uoc.androidjdbc.model.Persona;

public class Controller {

    public void init() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Dao dao = new Dao();
        new Dao().execute();
    }
}
