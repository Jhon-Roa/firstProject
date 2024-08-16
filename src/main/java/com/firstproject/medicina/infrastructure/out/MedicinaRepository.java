package com.firstproject.medicina.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.firstproject.medicina.domain.entity.Medicina;
import com.firstproject.medicina.domain.entity.MedicinaDto;
import com.firstproject.medicina.domain.service.MedicinaService;

public class MedicinaRepository implements MedicinaService {
    private Connection connection;

    public MedicinaRepository() {
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
    public List<Medicina> getAllMedicinas() {
        List<Medicina> medicinas = new ArrayList<>();
        try {
            String query = "SELECT idMedicina, acta, nombre, registroSalud, descripcion, idViaAdministracion, idPrincipioActivo, idUnidadMedida, idLaboratorio " +
                           "FROM medicina";
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    Medicina medicina = new Medicina(rs.getInt("idMedicina"),
                    rs.getString("acta"), 
                    rs.getString("nombre"), 
                    rs.getString("registroSalud"), 
                    rs.getString("descripcion"), 
                    rs.getInt("idViaAdministracion"), 
                    rs.getInt("idPrincipioActivo"),
                    rs.getInt("idUnidadMedida"), 
                    rs.getInt("idLaboratorio"));
                    medicinas.add(medicina);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicinas;
    }

    @Override
    public List<MedicinaDto> getAllMedicinasDto() {
        List<MedicinaDto> medicinas = new ArrayList<>();
        try {
            String query = "SELECT m.idMedicina, m.acta, m.nombre, m.registroSalud, m.descripcion, va.nombre, pa.nombre, um.nombre, l.nombre " +
                           "FROM medicina AS m " +
                           "JOIN viaAdministracion AS va USING(idViaAdministracion )" +
                           "JOIN principioActivo AS pa USING(idPrincipioActivo) " +
                           "JOIN unidadMedida AS um USING(idUnidadMedida) " +
                           "JOIN laboratorio AS l USING(idLaboratorio) ";
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    MedicinaDto medicinaDto = new MedicinaDto(rs.getInt("idMedicina"), 
                    rs.getString("m.acta"), 
                    rs.getString("m.nombre"), 
                    rs.getString("m.registroSalud"), 
                    rs.getString("m.descripcion"), 
                    rs.getString("va.nombre"), 
                    rs.getString("pa.nombre"), 
                    rs.getString("um.nombre"), 
                    rs.getString("l.nombre"));
                    medicinas.add(medicinaDto);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicinas;
    }

    @Override
    public Optional<Medicina> getEspecifiedMedicina(int idMedicina) {
        try {
            String query= "SELECT idMedicina, acta, nombre, registroSalud, descripcion, idViaAdministracion, idPrincipioActivo, idUnidadMedida, idLaboratorio " +
                          "FROM medicina " +
                          "WHERE idMedicina = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idMedicina);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    Medicina medicina = new Medicina(rs.getInt("idMedicina"),
                    rs.getString("acta"), 
                    rs.getString("nombre"), 
                    rs.getString("registroSalud"), 
                    rs.getString("descripcion"), 
                    rs.getInt("idViaAdministracion"), 
                    rs.getInt("idPrincipioActivo"),
                    rs.getInt("idUnidadMedida"), 
                    rs.getInt("idLaboratorio"));
                    return Optional.of(medicina);
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
    public Optional<MedicinaDto> findMedicina(int idMedicina) {
        try {
            String query = "SELECT m.idMedicina, m.acta, m.nombre, m.registroSalud, m.descripcion, va.nombre, pa.nombre, um.nombre, l.nombre " +
                           "FROM medicina AS m " +
                           "JOIN viaAdministracion AS va USING(idViaAdministracion )" +
                           "JOIN principioActivo AS pa USING(idPrincipioActivo) " +
                           "JOIN unidadMedida AS um USING(idUnidadMedida) " +
                           "JOIN laboratorio AS l USING(idLaboratorio) " +
                           "WHERE idMedicina = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idMedicina);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    MedicinaDto medicinaDto = new MedicinaDto(rs.getInt("idMedicina"), 
                    rs.getString("m.acta"), 
                    rs.getString("m.nombre"), 
                    rs.getString("m.registroSalud"), 
                    rs.getString("m.descripcion"), 
                    rs.getString("va.nombre"), 
                    rs.getString("pa.nombre"), 
                    rs.getString("um.nombre"), 
                    rs.getString("l.nombre"));
                    return Optional.of(medicinaDto);
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
    public void creatMedicina(Medicina medicina) {
        try {
            String query = "INSERT INTO medicina(acta, nombre, registroSalud, descripcion, idViaAdministracion, idPrincipioActivo, idUnidadMedida, idLaboratorio) " +
                           "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, medicina.getActa());
            ps.setString(2, medicina.getNombre());
            ps.setString(3, medicina.getRegistroSalud());
            ps.setString(4, medicina.getDescripcion());
            ps.setInt(5, medicina.getIdViaAdministracion());
            ps.setInt(6, medicina.getIdPrincipioActivo());
            ps.setInt(7, medicina.getIdUnidadMedida());
            ps.setInt(8, medicina.getIdLaboratorio());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarMedicina(int idMedicina) {
        try {
            String query = "DELETE " +
                           "FROM medicina " +
                           "WHERE idMedicina = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idMedicina);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMedicina(Medicina medicina) {
        try {
            String query = "UPDATE medicina " +
                           "SET acta = ?, nombre = ?, registroSalud = ?, descripcion = ?, idViaAdministracion = ?, idPrincipioActivo = ?, idUnidadMedida = ?, idLaboratorio = ?" +
                           "WHERE idMedicina = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, medicina.getActa());
            ps.setString(2, medicina.getNombre());
            ps.setString(3, medicina.getRegistroSalud());
            ps.setString(4, medicina.getDescripcion());
            ps.setInt(5, medicina.getIdViaAdministracion());
            ps.setInt(6, medicina.getIdPrincipioActivo());
            ps.setInt(7, medicina.getIdUnidadMedida());
            ps.setInt(8, medicina.getIdLaboratorio());
            ps.setInt(9, medicina.getIdMedicina());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
