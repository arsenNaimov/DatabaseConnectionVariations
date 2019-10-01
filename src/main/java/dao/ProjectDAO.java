package dao;
import model.Project;
import java.util.List;

public interface ProjectDAO {

    //create
    void add(Project project);
    //read all
    List<Project> getAll();
    Project getById(Long id);
    //update
    void update(Project project);
    //delete
    void delete(Project project);

}
