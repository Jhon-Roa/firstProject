package com.firstproject.principioActivo.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.firstproject.principioActivo.domain.entity.PrincipioActivo;
import com.firstproject.principioActivo.domain.service.PrincipioActivoService;

public class PrincipioActivoRepository implements PrincipioActivoService {
    private Connection connection;

    public PrincipioActivoRepository() {
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
    public List<PrincipioActivo> getAllPrincipiosActivos() {
        List<PrincipioActivo> principioActivos = new ArrayList<>();
        try {
            String query = "SELECT idPrincipioActivo, nombre " +
                           "FROM principioActivo";
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    PrincipioActivo principioActivo = new PrincipioActivo(rs.getInt("idPrincipioActivo"), rs.getString("nombre"));
                    principioActivos.add(principioActivo);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return principioActivos;
    }

    @Override
    public void borrarPrincipioActivo(PrincipioActivo principioActivo) {
        try {
            String query = "DELETE " +
                           "FROM principioActivo " +
                           "WHERE idPrincipioActivo = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, principioActivo.getIdPrincipioActivo());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<PrincipioActivo> getEspecifiedPrincipioActivo(int idPrincipioActivo) {
        try {
            String query = "SELECT idPrincipioActivo, nombre " +
                           "FROM principioActivo " +
                           "WHERE idprincipioActivo = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idPrincipioActivo);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    PrincipioActivo principioActivo = new PrincipioActivo(rs.getInt("idPrincipioActivo"), rs.getString("nombre"));
                    return Optional .of(principioActivo);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void crearPrincipioActivo(String nombre) {
        try {
            String query = "INSERT INTO principioActivo(nombre) " +
                           "VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, nombre);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
