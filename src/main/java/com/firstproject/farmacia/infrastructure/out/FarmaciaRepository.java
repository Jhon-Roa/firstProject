package com.firstproject.farmacia.infrastructure.out;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.firstproject.farmacia.domain.entity.Farmacia;
import com.firstproject.farmacia.domain.entity.FarmaciaDto;
import com.firstproject.farmacia.domain.service.FarmaciaService;

public class FarmaciaRepository implements FarmaciaService {
    private Connection connection;

    public FarmaciaRepository() {
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
    public List<FarmaciaDto> getAllFarmaciasDto() {
        List<FarmaciaDto> farmacias = new ArrayList<>();
        try {
            String query = "SELECT f.idFarmacia, f.nombre, b.nombre, f.direccion, f.logoFarmacia " +
                           "FROM farmacia AS f " +
                           "JOIN barrios AS b USING(idBarrio)";
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    FarmaciaDto farmacia = new FarmaciaDto(rs.getInt("f.idFarmacia"), 
                    rs.getString("f.nombre"), 
                    rs.getString("b.nombre"), 
                    rs.getString("f.direccion"), 
                    rs.getBytes("f.logoFarmacia"));
                    farmacias.add(farmacia);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return farmacias;
    }

    @Override
    public List<Farmacia> getAllFarmacias() {
        List<Farmacia> farmacias = new ArrayList<>();
        try {
            String query = "SELECT idFarmacia, nombre, idBarrio, direccion, logoFarmacia " +
                           "FROM farmacia";
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    Farmacia farmacia = new Farmacia(rs.getInt("idFarmacia"),
                    rs.getString("nombre"), 
                    rs.getInt("idBarrio"), 
                    rs.getString("direccion"), 
                    rs.getBytes("logoFarmacia"));
                    farmacias.add(farmacia);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return farmacias;
    }

    @Override
    public Farmacia getEspecifiedFarmacia(int idFarmacia) {
        try {
            String query = "SELECT idFarmacia, nombre, idBarrio, direccion, logoFarmacia " +
                           "FROM farmacia " +
                           "WHERE idFarmacia = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idFarmacia);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    Farmacia farmacia = new Farmacia(rs.getInt("idFarmacia"),
                    rs.getString("nombre"), 
                    rs.getInt("idBarrio"), 
                    rs.getString("direccion"), 
                    rs.getBytes("logoFarmacia"));
                    return farmacia;
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
    public Optional<FarmaciaDto> findFarmacia(int idFarmacia) {
        try {
            String query = "SELECT f.idFarmacia, f.nombre, b.nombre, f.direccion, f.logoFarmacia " +
                           "FROM farmacia AS f " +
                           "JOIN barrio AS b USING(idBarrio) " +
                           "WHERE idFarmacia = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idFarmacia);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    FarmaciaDto farmacia = new FarmaciaDto(rs.getInt("f.idFarmacia"), 
                    rs.getString("f.nombre"), 
                    rs.getString("b.nombre"), 
                    rs.getString("f.direccion"), 
                    rs.getBytes("f.logoFarmacia"));
                    return Optional.of(farmacia);
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
    public void crearFarmacia(Farmacia farmacia) {
        try {
            String query = "INSERT INTO farmacia(nombre, idBarrio, direccion, logoFarmacia) " +
                           "VALUES(?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, farmacia.getNombre());
            ps.setInt(2, farmacia.getIdBarrio());
            ps.setString(3, farmacia.getDireccion());
            ps.setBytes(4, farmacia.getLogoFarmacia());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFarmacia(int idFarmacia) {
        try {
            String query = "DELETE " +
                           "FROM farmacia" +
                           "WHERE idFarmacia = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idFarmacia);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateFarmacia(Farmacia farmacia) {
        try {
            String query = "UPDATE farmacia " +
                       "SET nombre= ?, idBarrio= ?, direccion= ?, logoFarmacia= ?" +
                       "WHERE idFarmacia = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, farmacia.getNombre());
            ps.setInt(2, farmacia.getIdBarrio());
            ps.setString(3, farmacia.getDireccion());
            ps.setBytes(4, farmacia.getLogoFarmacia());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
