package com.firstproject.viaadministracion.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.firstproject.viaadministracion.domain.entity.ViaAdministracion;
import com.firstproject.viaadministracion.domain.services.ViaAdministracionServices;

public class ViaAdministracionRepository implements ViaAdministracionServices {
    private Connection connection;

    public ViaAdministracionRepository() {
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
    public List<ViaAdministracion> getAllViasAdministracion() {
        List<ViaAdministracion> viasDeAdministracions = new ArrayList<>();
        try {
            String query = "SELECT idViaAdministracion, nombre " +
                           "FROM viaAdministracion";
            PreparedStatement ps = connection.prepareStatement(query);
          try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ViaAdministracion viaAdministracion = new ViaAdministracion(rs.getInt("idViaAdministracion"), rs.getString("nombre"));
                viasDeAdministracions.add(viaAdministracion);
            }
          } catch (SQLException e) {
            e.printStackTrace();
          }         
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return viasDeAdministracions;
    }

    @Override
    public void borrarViaAdministracion(ViaAdministracion viaAdministracion) {
        try {
            String query = "DELETE " +
                           "FROM viaAdministracion " +
                           "WHERE idViaAdministracion = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, viaAdministracion.getIdViaAdministracion());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ViaAdministracion getEspecifiedViaAdministracion(int idViaAdministracion) {
        try {
            String query = "SELECT idViaAdministracion, nombre " +
                           "FROM viaAdministracion " +
                           "WHERE idViaAdministracion = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idViaAdministracion);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    ViaAdministracion viaAdministracion = new ViaAdministracion(rs.getInt("idViaAdministracion"), rs.getString("nombre"));
                    return viaAdministracion;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void crearviaAdministracion(String nombre) {
        try {
            String query = "INSERT INTO viaAdministracion(nombre) " +
                           "VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, nombre);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
