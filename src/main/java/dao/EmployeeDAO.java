package dao;
import model.Employee;

import java.util.List;

public interface EmployeeDAO {
    //create
    void add(Employee employee);
    //read all
    List<Employee> getAll();
    Employee getById(Long id);
    //update
    void update(Employee employee);
    //delete
    void delete(Employee employee);
}
