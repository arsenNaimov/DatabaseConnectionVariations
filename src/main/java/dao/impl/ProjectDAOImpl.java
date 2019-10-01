package dao.impl;

import bl.Util;
import dao.ProjectDAO;
import model.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAOImpl extends Util implements ProjectDAO {

    Connection connection;

    @Override
    public void add(Project project) {
        connection = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO project (ID, TITLE) VALUES(?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, project.getId());
            preparedStatement.setString(2, project.getTitle());
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
    public List<Project> getAll() {
        connection = getConnection();
        List<Project> projectList = new ArrayList<>();
        Statement statement = null;
        String sql = "SELECT id, title FROM project";
        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Project project = new Project();
               project.setId(resultSet.getLong("ID"));
               project.setTitle(resultSet.getString("TITLE"));
               projectList.add(project);
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
        return projectList;
    }

    @Override
    public Project getById(Long id) {
        connection = getConnection();
        Project project = new Project();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT id, title FROM project WHERE ID = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            project.setId(resultSet.getLong("ID"));
            project.setTitle(resultSet.getString("TITLE"));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try{
                closeConnection(connection, preparedStatement);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return project;
    }

    @Override
    public void update(Project project) {
        connection = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE project SET ID = ?, TITLE = ? WHERE ID = ?";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, project.getId());
            preparedStatement.setString(2, project.getTitle());
            preparedStatement.setLong(3, project.getId());
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
    public void delete(Project project) {
        connection = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM PROJECT WHERE ID = ?";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, project.getId());
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
