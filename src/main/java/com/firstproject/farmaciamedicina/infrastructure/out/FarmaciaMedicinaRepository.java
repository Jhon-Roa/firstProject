package com.firstproject.farmaciamedicina.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.firstproject.farmaciamedicina.domain.entity.FarmaciaMedicina;
import com.firstproject.farmaciamedicina.domain.entity.FarmaciaMedicinaDto;
import com.firstproject.farmaciamedicina.domain.service.FarmaciaMedicinaService;

public class FarmaciaMedicinaRepository implements FarmaciaMedicinaService {
    private Connection connection;

    public FarmaciaMedicinaRepository() {
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
    public void createFarmaciaMedicina(FarmaciaMedicina farmaciaMedicina) {
        try {
            String query= "INSERT INTO farmaciaMedicina(idFarmacia, idMedicina, precio) " +
                          "VALUES(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, farmaciaMedicina.getIdFarmacia());
            ps.setInt(2, farmaciaMedicina.getIdMedicina());
            ps.setFloat(3, farmaciaMedicina.getPrecio());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<FarmaciaMedicinaDto> getAllMedicinasFromFarmacia(int idFarmacia) {
        List<FarmaciaMedicinaDto> medicinasFarmacias = new ArrayList<>();
        try {
            String query= "SELECT f.nombre, m.nombre, fm.precio " +
                          "FROM farmaciaMedicia AS fm " +
                          "JOIN farmacia AS f USING(idFarmacia) " +
                          "JOIN medicina AS m USING(idMedicina) " +
                          "WHERE f.id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idFarmacia);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    FarmaciaMedicinaDto fm = new FarmaciaMedicinaDto(rs.getString("f.nombre"), 
                    rs.getString("m.nombre"),
                    rs.getFloat("fm.precio"));
                    medicinasFarmacias.add(fm);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicinasFarmacias;
    }

    @Override
    public void deleteMedicinaFromFarmacia(FarmaciaMedicina farmaciaMedicina) {
        try {
            String query = "DELETE " +
                           "FROM farmaciaMedicina " +
                           "WHERE idFarmacia = ? AND idMedicina = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, farmaciaMedicina.getIdFarmacia());
            ps.setInt(2, farmaciaMedicina.getIdMedicina());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
