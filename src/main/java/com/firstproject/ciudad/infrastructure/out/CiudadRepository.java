package com.firstproject.ciudad.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.firstproject.barrio.domain.entity.Barrio;
import com.firstproject.ciudad.domain.entity.Ciudad;
import com.firstproject.ciudad.domain.services.CiudadServices;

public class CiudadRepository implements CiudadServices {
    Connection connection;

    public CiudadRepository() {
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
    public List<Ciudad> getAllCiudades() {
        List<Ciudad> ciudades = new ArrayList<>();
        try {
            String query = "SELECT idciudad, nombre, idRegion " +
                    "FROM ciudad";
            PreparedStatement ps = connection.prepareStatement(query);
            try {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Ciudad ciudad = new Ciudad(rs.getInt("idCiudad"), rs.getString("nombre"), rs.getInt("idRegion"));
                    ciudades.add(ciudad);
                }
                return ciudades;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ciudades;
    }

    @Override
    public Ciudad getSpecifiedCiudad(int idCiudad) {
        try {
            String query = "SELECT idCiudad, nombre, idRegion " +
                           "FROM ciudad " +
                           "WHERE idCiudad = ?";
            PreparedStatement ps = connection.prepareStatement(query); 
            ps.setInt(1, idCiudad);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    Ciudad ciudad = new Ciudad(rs.getInt("idCiudad"), 
                    rs.getString("nombre"), 
                    rs.getInt("idRegion"));
                    return ciudad;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
