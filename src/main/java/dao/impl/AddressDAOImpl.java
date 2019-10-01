package dao.impl;
import bl.Util;
import dao.AddressDAO;
import model.Address;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDAOImpl extends Util implements AddressDAO {

    Connection connection;

    @Override
    public void add(Address address) {
        connection = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO ADDRESS (ID, COUNTRY, CITY, STREET, POST_CODE) VALUES(?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, address.getId());
            preparedStatement.setString(2, address.getCountry());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setString(4, address.getStreet());
            preparedStatement.setString(5, address.getPostCode());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeConnection(connection, preparedStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Address> getAll(){
        connection = getConnection();
        List<Address> addressList = new ArrayList<>();
        Statement statement = null;
        String sql = "SELECT id, country, city, street, post_code FROM ADDRESS";
        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Address address = new Address();
                address.setId(resultSet.getLong("ID"));
                address.setCity(resultSet.getString("CITY"));
                address.setCountry(resultSet.getString("COUNTRY"));
                address.setStreet(resultSet.getString("STREET"));
                address.setPostCode(resultSet.getString("POST_CODE"));
                addressList.add(address);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                closeConnection(connection, statement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return addressList;
    }

    @Override
    public Address getById(Long id) {
        connection = getConnection();
        Address address = new Address();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT id, country, city, street, post_code FROM ADDRESS WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            address.setId(resultSet.getLong("ID"));
            address.setCountry(resultSet.getString("COUNTRY"));
            address.setCountry(resultSet.getString("CITY"));
            address.setCountry(resultSet.getString("STREET"));
            address.setCountry(resultSet.getString("POST_CODE"));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try{
                closeConnection(connection, preparedStatement);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return address;
    }

    @Override
    public void update(Address address) {
        connection = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE ADDRESS SET CITY = ?, COUNTRY = ?, STREET = ?, POST_CODE = ?, WHERE ID = ?";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setString(4, address.getPostCode());
            preparedStatement.setLong(5, address.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                closeConnection(connection, preparedStatement);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Address address) {
        connection = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM ADDRESS WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, address.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                closeConnection(connection, preparedStatement);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
