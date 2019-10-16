package dao;
import model.Employee;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    //add
    void add (Employee employee) throws SQLException;

    //read
    List<Employee> getAll() throws SQLException;
    Employee getById(Long id) throws SQLException;

    //update
    void update (Employee employee) throws SQLException;

    //delete
    void delete (Employee employee) throws SQLException;
}
