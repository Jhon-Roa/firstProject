package com.firstproject.region.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.firstproject.region.domain.entity.Region;
import com.firstproject.region.domain.service.RegionServices;

public class RegionRepository implements RegionServices{
    private Connection connection;

    public RegionRepository() {
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
    public List<Region> getAllRegiones() {
        List<Region> regiones = new ArrayList<>();
        try {
            String query = "SELECT idRegion, nombre, idPais " +
                    "FROM region";
            PreparedStatement ps = connection.prepareStatement(query);
            try {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Region region = new Region(rs.getInt("idRegion"), rs.getString("nombre"), rs.getInt("idPais"));
                    regiones.add(region);
                }
                return regiones;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return regiones;
    }

    
}
