package com.firstproject.farmaciamedicina.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;

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
    public boolean createFarmaciaMedicina(FarmaciaMedicina farmaciaMedicina) {
        try {
            String query= "INSERT INTO farmaciaMedicina(idFarmacia, idMedicina, precio) " +
                          "VALUES(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, farmaciaMedicina.getIdFarmacia());
            ps.setInt(2, farmaciaMedicina.getIdMedicina());
            ps.setFloat(3, farmaciaMedicina.getPrecio());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "este registro ya existe", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    @Override
    public List<FarmaciaMedicinaDto> getAllMedicinasFromFarmacia(int idFarmacia) {
        List<FarmaciaMedicinaDto> medicinasFarmacias = new ArrayList<>();
        try {
            String query= "SELECT f.nombre, m.nombre, fm.precio " +
                          "FROM farmaciaMedicina AS fm " +
                          "JOIN farmacia AS f USING(idFarmacia) " +
                          "JOIN medicina AS m USING(idMedicina) " +
                          "WHERE f.idFarmacia = ?";
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
    public boolean deleteMedicinaFromFarmacia(FarmaciaMedicina farmaciaMedicina) {
        try {
            String query = "DELETE " +
                           "FROM farmaciaMedicina " +
                           "WHERE idFarmacia = ? AND idMedicina = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, farmaciaMedicina.getIdFarmacia());
            ps.setInt(2, farmaciaMedicina.getIdMedicina());
            int rowCount = ps.executeUpdate();
            System.out.println(rowCount);
            if (rowCount > 0) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "este registro no existe", "error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
