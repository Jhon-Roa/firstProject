package com.firstproject.cliente.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.firstproject.cliente.domain.entity.Cliente;
import com.firstproject.cliente.domain.service.ClienteService;

public class ClienteRepository implements ClienteService {
    private Connection connection;

    public ClienteRepository() {
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
    public void crearCliente(Cliente cliente) {
        try {
            String query = "INSERT INTO cliente (idCliente, primerNombre, segundoNombre, primerAperllido, segundoApellido, edad, fechaNacimiento, idBarrio, idTipoDocumento)" +
            "VALUES(?, ?, ?, ?, ?, calcular_edad(?), ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, cliente.getIdCliente());
            ps.setString(2, cliente.getPrimerNombre());
            ps.setString(3, cliente.getSegundoNombre());
            ps.setString(4, cliente.getSegundoNombre());
            ps.setString(5, cliente.getSegundoApellido());
            ps.setString(6, cliente.getFechaNacimiento());
            ps.setString(7, cliente.getFechaNacimiento());
            ps.setInt(8, cliente.getIdBarrio());
            ps.setInt(9, cliente.getIdTipoDocumento());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCliente(Cliente cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCliente'");
    }

    @Override
    public Cliente deleteCliente(String idCliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCliente'");
    }

    @Override
    public Optional<Cliente> findClienteById(String idCliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findClienteById'");
    }

    @Override
    public List<Cliente> SeeAllClients() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'SeeAllClients'");
    }

}
