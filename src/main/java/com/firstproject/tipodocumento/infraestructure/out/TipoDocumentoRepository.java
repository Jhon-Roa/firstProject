package com.firstproject.tipodocumento.infraestructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.firstproject.tipodocumento.domain.entity.TipoDocumento;
import com.firstproject.tipodocumento.domain.services.TipoDocumentoService;

public class TipoDocumentoRepository implements TipoDocumentoService {
    private Connection connection;
    
    public TipoDocumentoRepository() {
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
    public List<TipoDocumento> getAllTipoDocumentos() {
        List<TipoDocumento> tipoDocumentos = new ArrayList<>();
        try {
            String query = "SELECT idTipoDocumento, nombre " +
                           "FROM tipoDocumento";
            PreparedStatement ps = connection.prepareStatement(query);
            try {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    TipoDocumento tipoDocumento = new TipoDocumento(rs.getInt("idTipoDocumento"), rs.getString("nombre"));
                    tipoDocumentos.add(tipoDocumento);
                }
                return tipoDocumentos;
            } catch (Exception e) {
                // TODO: handle exception
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return tipoDocumentos;
    }


}
