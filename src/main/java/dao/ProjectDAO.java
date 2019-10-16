package dao;

import model.Address;
import model.Project;

import java.sql.SQLException;
import java.util.List;

public interface ProjectDAO {
    //add
    void add (Project project) throws SQLException;

    //read
    List<Project> getAll() throws SQLException;
    Project getById(Long id) throws SQLException;

    //update
    void update (Project address) throws SQLException;

    //delete
    void delete (Project address) throws SQLException;
}
