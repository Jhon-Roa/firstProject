package com.firstproject.unidadmedida.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.firstproject.unidadmedida.domain.entity.UnidadMedida;
import com.firstproject.unidadmedida.domain.service.UnidadMedidaService;

public class UnidadMedidaRepository implements UnidadMedidaService{
    private Connection connection;

    public UnidadMedidaRepository() {
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
    public List<UnidadMedida> getAllUnidadesMedida() {
        List<UnidadMedida> unidadMedidas = new ArrayList<>();
        try {
            String query = "SELECT idUnidadMedida, nombre " +
                           "FROM unidadMedida";
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()){
                while(rs.next()) {
                    UnidadMedida unidadMedida = new UnidadMedida(rs.getInt("idUnidadMedida"), rs.getString("nombre"));
                    unidadMedidas.add(unidadMedida);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return unidadMedidas;
    }

    @Override
    public void borrarUnidadMedida(UnidadMedida unidadMedida) {
        try {
            String query = "DELETE " +
                           "FROM unidadMedida " +
                           "WHERE idUnidadMedida = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, unidadMedida.getIdUnidadMedida());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<UnidadMedida> getEspecifiedUnidadMedida(int idUnidadMedida) {
        try {
            String query = "SELECT idUnidadMedida, nombre " +
                           "FROM unidadMedida " +
                           "WHERE idUnidadMedida = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idUnidadMedida);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    UnidadMedida unidadMedida = new UnidadMedida(rs.getInt("idUnidadMedida"), rs.getString("nombre"));
                    return Optional.of(unidadMedida);
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
    public void crearUnidadMedida(String nombre) {
        try {
            String query = "INSERT INTO unidadMedida(nombre) " +
                           "VALUES(?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, nombre);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
