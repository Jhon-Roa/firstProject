package com.firstproject.barrio.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.firstproject.barrio.domain.entity.Barrio;
import com.firstproject.barrio.domain.service.BarrioService;
import com.firstproject.ciudad.domain.entity.Ciudad;

public class BarrioRepository implements BarrioService  {
    private Connection connection;
    
    public BarrioRepository() {
        try {
            Properties properties = new Properties();
            properties.load(getClass().getClassLoader().getResourceAsStream("configdb.properties"));
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createBarrio(String barrio, Ciudad selectedCiudad) {
        try {
            String query = "INSERT INTO barrio(nombre, idCiudad) " +
                       "VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, barrio);
            ps.setInt(2, selectedCiudad.getIdCiudad());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Barrio> getAllBarrios() {
        List<Barrio> barrios = new ArrayList<>();
        try {
            String query = "SELECT idBarrio, nombre, idCiudad " +
                           "FROM barrio";
            PreparedStatement ps = connection.prepareStatement(query);
            try {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Barrio barrio = new Barrio(rs.getInt("idBarrio"), rs.getString("nombre"), rs.getInt("idCiudad"));
                    barrios.add(barrio);
                }
                return barrios;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return barrios;
    }
}
