package dao;

import model.Address;

import java.sql.SQLException;
import java.util.List;

public interface AddressDAO {

    //add
    void add (Address address) throws SQLException;

    //read
    List<Address> getAll() throws SQLException;
    Address getById(Long id) throws SQLException;

    //update
    void update (Address address) throws SQLException;

    //delete
    void delete (Address address) throws SQLException;
}
