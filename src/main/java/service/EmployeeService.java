package service;

import bl.SessionUtil;
import dao.EmployeeDAO;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;


import java.sql.SQLException;
import java.util.List;

public class EmployeeService  extends SessionUtil implements EmployeeDAO {
    @Override
    public void add(Employee employee) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(employee);
        closeTransactionSession();
    }

    @Override
    public List<Employee> getAll() throws SQLException {
        openTransactionSession();
        String sql = "SELECT * FROM EMPLOYEE";
        Session session = getSession();
        List<Employee> result = session.createNativeQuery(sql).addEntity(Employee.class).list();
        closeTransactionSession();
        return result;
    }


    @Override
    public Employee getById(Long id) throws SQLException {
        openTransactionSession();
        String sql = "SELECT * FROM EMPLOYEE WHERE ID = :id";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        query.setParameter("id", id);
        Employee result = (Employee) query.getSingleResult();
        closeTransactionSession();
        return result;
    }

    @Override
    public void update(Employee employee) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.update(employee);
        closeTransactionSession();
    }

    @Override
    public void delete(Employee employee) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.remove(employee);
        closeTransactionSession();
    }
}
