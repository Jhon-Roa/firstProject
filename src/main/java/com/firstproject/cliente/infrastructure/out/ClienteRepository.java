package com.firstproject.cliente.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.firstproject.cliente.domain.entity.Cliente;
import com.firstproject.cliente.domain.entity.ClienteDto;
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
            ps.setDate(6, cliente.getFechaNacimiento());
            ps.setDate(7, cliente.getFechaNacimiento());
            ps.setInt(8, cliente.getIdBarrio());
            ps.setInt(9, cliente.getIdTipoDocumento());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCliente(Cliente cliente, String idCliente) {
        try {
            String query = "UPDATE cliente " +
                        "SET primerNombre= ?, segundoNombre= ?, primerApellido= ?, segundoApellido= ?, edad= calcular_edad(?), fechaNacimiento= ?, idBarrio= ?, idTipoDocumento= ? " +
                        "WHERE idCliente = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, cliente.getPrimerNombre());
            ps.setString(2, cliente.getSegundoNombre());
            ps.setString(3, cliente.getPrimerApellido());
            ps.setString(4, cliente.getSegundoApellido());
            ps.setDate(5, cliente.getFechaNacimiento());
            ps.setDate(6, cliente.getFechaNacimiento());
            ps.setInt(7, cliente.getIdBarrio());
            ps.setInt(8, cliente.getIdTipoDocumento());
            ps.setString(9, cliente.getIdCliente());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCliente(String idCliente) {
        try {
            String query = "DELETE" +
                           "FROM cliente" +
                           "WHERE idCliente = ?";
            PreparedStatement ps= connection.prepareStatement(query);
            ps.setString(1, idCliente);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<ClienteDto> findClienteById(String idCliente) {
        try {
            String query = "SELECT c.idCliente, c.primerNombre, c.segundoNombre, c.primerAperllido, c.segundoApellido, c.edad, c.fechaNacimiento, b.nombre, td.nombre " +
                           "FROM cliente " +
                           "JOIN tipoDocumento AS tp USING(idTipoDocumento) " +
                           "JOIN barrio AS b USING(idBarrio) " +
                           "WHERE idCliente = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idCliente);
            try (ResultSet rs = ps.executeQuery()) {
                if(rs.next()) {
                    ClienteDto cliente = new ClienteDto(rs.getString("primerNombre"), rs.getString("segundoNombre"), rs.getString("primerApellido"), rs.getString("segundoApellido"), rs.getInt("edad"), idCliente, null, idCliente, query);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cliente> SeeAllClients() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'SeeAllClients'");
    }

}
