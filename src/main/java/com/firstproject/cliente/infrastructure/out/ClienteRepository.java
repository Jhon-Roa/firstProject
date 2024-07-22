package com.firstproject.cliente.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            String query = "INSERT INTO cliente (idCliente, primerNombre, segundoNombre, primerApellido, segundoApellido, edad, fechaNacimiento, idBarrio, idTipoDocumento)" +
            "VALUES(?, ?, ?, ?, ?, calcular_edad(?), ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, cliente.getIdCliente());
            ps.setString(2, cliente.getPrimerNombre());
            ps.setString(3, cliente.getSegundoNombre());
            ps.setString(4, cliente.getPrimerApellido());
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
            String query = "DELETE " +
                           "FROM cliente " +
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
            String query = "SELECT c.idCliente, c.primerNombre, c.segundoNombre, c.primerApellido, c.segundoApellido, c.edad, c.fechaNacimiento, c.fechaRegistro, b.nombre, td.nombre " +
                           "FROM cliente AS c " +
                           "JOIN tipoDocumento AS td USING(idTipoDocumento) " +
                           "JOIN barrio AS b USING(idBarrio) " +
                           "WHERE idCliente = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idCliente);
            try (ResultSet rs = ps.executeQuery()) {
                if(rs.next()) {
                    ClienteDto cliente = new ClienteDto(rs.getString("c.primerNombre"),
                    rs.getString("c.segundoNombre"),
                    rs.getString("c.primerApellido"), 
                    rs.getString("c.segundoApellido"), 
                    rs.getInt("c.edad"), 
                    rs.getDate("c.fechaNacimiento"), 
                    rs.getString("c.idCliente"), 
                    rs.getDate("c.fechaRegistro"), 
                    rs.getString("b.nombre"), 
                    rs.getString("td.nombre"));
                    return Optional.of(cliente);
                }
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<ClienteDto> SeeAllClients() {
        List<ClienteDto> allClients = new ArrayList<>();
        try {
            String query = "SELECT c.idCliente, c.primerNombre, c.segundoNombre, c.primerApellido, c.segundoApellido, c.edad, c.fechaNacimiento, c.fechaRegistro, b.nombre, td.nombre " +
                           "FROM cliente AS c " +
                           "JOIN tipoDocumento AS td USING(idTipoDocumento) " +
                           "JOIN barrio AS b USING(idBarrio) ";
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    ClienteDto cliente = new ClienteDto(rs.getString("c.primerNombre"),
                    rs.getString("c.segundoNombre"),
                    rs.getString("c.primerApellido"), 
                    rs.getString("c.segundoApellido"), 
                    rs.getInt("c.edad"), 
                    rs.getDate("c.fechaNacimiento"), 
                    rs.getString("c.idCliente"), 
                    rs.getDate("c.fechaRegistro"), 
                    rs.getString("b.nombre"), 
                    rs.getString("td.nombre"));
                    allClients.add(cliente);
                } 
                return allClients;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allClients;
    }

    @Override
    public Optional<Cliente> findClienteByIdNoDto(String idCliente) {
        try {
            String query = "SELECT idCliente, primerNombre, segundoNombre, primerApellido, segundoApellido, fechaNacimiento, idBarrio, idTipoDocumento " +
                           "FROM cliente " +
                           "WHERE idCliente = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idCliente);
            try (ResultSet rs = ps.executeQuery()) {
                if(rs.next()) {
                    Cliente cliente = new Cliente(rs.getString("primerNombre"),
                    rs.getString("segundoNombre"),
                    rs.getString("primerApellido"), 
                    rs.getString("segundoApellido"), 
                    rs.getDate("fechaNacimiento"), 
                    rs.getString("idCliente"), 
                    rs.getInt("idBarrio"), 
                    rs.getInt("idTipoDocumento"));
                    return Optional.of(cliente);
                }
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Cliente> SeeAllClientsNoDto() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            String query = "SELECT idCliente, primerNombre, segundoNombre, primerApellido, segundoApellido, fechaNacimiento, idBarrio, idTipoDocumento " +
                           "FROM cliente ";
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    Cliente cliente = new Cliente(rs.getString("primerNombre"),
                    rs.getString("segundoNombre"),
                    rs.getString("primerApellido"), 
                    rs.getString("segundoApellido"), 
                    rs.getDate("fechaNacimiento"), 
                    rs.getString("idCliente"), 
                    rs.getInt("idBarrio"), 
                    rs.getInt("idTipoDocumento"));
                    clientes.add(cliente);
                }
                return clientes;
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

}
