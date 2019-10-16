package service;
import bl.SessionUtil;
import dao.AddressDAO;
import model.Address;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class AddressService extends SessionUtil implements AddressDAO {
    @Override
    public void add(Address address) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(address);
        closeTransactionSession();
    }

    @Override
    public List<Address> getAll() throws SQLException {
        openTransactionSession();
        String sql = "SELECT * FROM ADDRESS";
        Session session = getSession();
        List<Address> result = session.createNativeQuery(sql).addEntity(Address.class).list();
        closeTransactionSession();
        return result;
    }

    @Override
    public Address getById(Long id) throws SQLException {
        openTransactionSession();
        String sql = "SELECT * FROM ADDRESS WHERE ID = :id";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        query.setParameter("id", id);
        Address result = (Address) query.getSingleResult();
        closeTransactionSession();
        return result;
    }

    @Override
    public void update(Address address) throws SQLException {
        openTransactionSession();
        String sql = "SELECT * FROM ADDRESS WHERE ID = :id";
        Session session = getSession();
        session.update(address);
        closeTransactionSession();
    }

    @Override
    public void delete(Address address) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.remove(address);
        closeTransactionSession();
    }
}
