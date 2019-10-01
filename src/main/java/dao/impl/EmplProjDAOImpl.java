package dao.impl;
import bl.Util;
import dao.EmplProjDAO;
import model.EmplProj;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmplProjDAOImpl extends Util implements EmplProjDAO {

    Connection connection;

    @Override
    public void add(EmplProj emplProj) {
        connection = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO empl_proj (EMPLOYEE_ID, PROJECT_ID) VALUES(?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, emplProj.getEmployeeId());
            preparedStatement.setLong(2, emplProj.getProjectId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                closeConnection(connection, preparedStatement);
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<EmplProj> getAll() {
        connection = getConnection();
        List<EmplProj> emplProjList = new ArrayList<>();
        Statement statement = null;
        String sql = "SELECT EMPLOYEE_ID, PROJECT_ID FROM empl_proj";
        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                EmplProj emplProj = new EmplProj();
                emplProj.setEmployeeId(resultSet.getLong("EMPLOYEE_ID"));
                emplProj.setProjectId(resultSet.getLong("PROJECT_ID"));
                emplProjList.add(emplProj);
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
        return emplProjList;
    }

    @Override
    public EmplProj getById(Long id) {
        connection = getConnection();
        EmplProj emplProj = new EmplProj();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT EMPLOYEE_ID, PROJECT_ID FROM empl_proj WHERE EMPLOYEE_ID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            emplProj.setEmployeeId(resultSet.getLong("EMPLOYEE_ID"));
            emplProj.setProjectId(resultSet.getLong("PROJECT_ID"));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try{
                closeConnection(connection, preparedStatement);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return emplProj;
    }

    @Override
    public void update(EmplProj emplProj) {
        connection = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE empl_proj SET EMPLOYEE_ID = ?, PROJECT_ID = ? WHERE ID = ?";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, emplProj.getEmployeeId());
            preparedStatement.setLong(2, emplProj.getProjectId());
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
    public void delete(EmplProj emplProj) {
        connection = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM empl_proj WHERE EMPLOYEE_ID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, emplProj.getEmployeeId());
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
