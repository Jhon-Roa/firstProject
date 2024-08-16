package com.firstproject.laboratorio.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.firstproject.laboratorio.domain.entity.Laboratorio;
import com.firstproject.laboratorio.domain.entity.LaboratorioDto;
import com.firstproject.laboratorio.domain.service.LaboratorioService;

public class LaboratorioRepository implements LaboratorioService {
    private Connection connection;

    public LaboratorioRepository() {
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
    public List<LaboratorioDto> getAllLaboratorioDtos() {
        List<LaboratorioDto> laboratorios = new ArrayList<>();
        try {
            String query = "SELECT l.idLaboratorio, l.nombre, b.nombre " +
                           "FROM laboratorio AS l " +
                           "JOIN barrio AS b USING(idBarrio)";
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    LaboratorioDto laboratorio = new LaboratorioDto(rs.getInt("l.idLaboratorio"), 
                    rs.getString("l.nombre"), 
                    rs.getString("b.nombre"));
                    laboratorios.add(laboratorio);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laboratorios;
    }

    @Override
    public List<Laboratorio> getAllLaboratorios() {
        List<Laboratorio> laboratorios = new ArrayList<>();
        try {
            String query = "SELECT idLaboratorio, nombre, idBarrio " +
                           "FROM laboratorio ";
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    Laboratorio laboratorio = new Laboratorio(rs.getInt("idLaboratorio"), 
                    rs.getString("nombre"), 
                    rs.getInt("idBarrio"));
                    laboratorios.add(laboratorio);
                }
            } catch (SQLException e) {
                e.printStackTrace();    
            }
        } catch (SQLException e) {
            e.printStackTrace();    
        }
        return laboratorios;
    }

    @Override
    public Optional<Laboratorio> getSpecifiedLaboratorio(int idLaboratorio) {
        try {
            String query = "SELECT idLaboratorio, nombre, idBarrio " +
                           "FROM laboratorio " +
                           "WHERE idLaboratorio = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idLaboratorio);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    Laboratorio laboratorioQuery = new Laboratorio(rs.getInt("idLaboratorio"), 
                    rs.getString("nombre"), 
                    rs.getInt("idBarrio"));
                    return Optional.of(laboratorioQuery);
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
    public void borrarLaboratorio(int idLaboratorio) {
        try {
            String query = "DELETE " +
                           "FROM laboratorio " +
                           "WHERE idLaboratorio = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idLaboratorio);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void crearLaboratorio(Laboratorio laboratorio) {
        try {
            String query= "INSERT INTO laboratorio(nombre, idBarrio) " +
                          "VALUES(?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, laboratorio.getNombre());
            ps.setInt(2, laboratorio.getIdBarrio());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
