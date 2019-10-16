package service;

import bl.SessionUtil;
import dao.ProjectDAO;
import model.Project;
import org.hibernate.Session;
import org.hibernate.query.Query;


import java.sql.SQLException;
import java.util.List;

public class ProjectService extends SessionUtil implements ProjectDAO {
    @Override
    public void add(Project project) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(project);
        closeTransactionSession();
    }

    @Override
    public List<Project> getAll() throws SQLException {
        openTransactionSession();
        String sql = "SELECT * FROM PROJECT";
        Session session = getSession();
        List <Project> result = session.createNativeQuery(sql).addEntity(Project.class).list();
        closeTransactionSession();
        return result;
    }

    @Override
    public Project getById(Long id) throws SQLException {
        openTransactionSession();
        String sql = "SELECT * FROM PROJJECT WHERE ID = :id";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Project.class);
        query.setParameter("id", id);
        Project result = (Project) query.getSingleResult();
        closeTransactionSession();
        return result;
    }

    @Override
    public void update(Project address) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.update(address);
        closeTransactionSession();
    }

    @Override
    public void delete(Project address) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.remove(address);
        closeTransactionSession();
    }
}
