import dao.AddressDAO;
import dao.EmplProjDAO;
import dao.EmployeeDAO;
import dao.ProjectDAO;
import dao.impl.AddressDAOImpl;
import dao.impl.EmplProjDAOImpl;
import dao.impl.EmployeeDAOImpl;
import dao.impl.ProjectDAOImpl;
import model.Address;
import model.EmplProj;
import model.Employee;
import model.Project;
import java.sql.Date;
import java.sql.SQLException;

public class Domain {
    public static void main(String[] args) throws SQLException {
        Address address = new Address((long) 12,"RUSSIA","MOSCOV","FFFFF", "1234");
        Employee employee = new Employee((long)13, "Alina", "Borodina", new Date(1111-11-11), (long)1444);
        EmplProj emplProj = new EmplProj((long)11, (long)18);
        Project project = new Project((long)15, "Project01");
        AddressDAO addressDAO = new AddressDAOImpl();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        EmplProjDAO emplProjDAO = new EmplProjDAOImpl();
        ProjectDAO projectDAO = new ProjectDAOImpl();

        addressDAO.add(address);
        System.out.println(addressDAO.getAll());
        System.out.println(addressDAO.getById((long) 12));
        addressDAO.delete(address);
        ////////////
        employeeDAO.add(employee);
        System.out.println(employeeDAO.getAll());
        System.out.println(employeeDAO.getById((long)13));
        employeeDAO.delete(employee);
        ///////////
        emplProjDAO.add(emplProj);
        System.out.println(emplProjDAO.getAll());
        System.out.println(emplProjDAO.getById((long) 11));
        emplProjDAO.delete(emplProj);
        ///////////
        projectDAO.add(project);
        System.out.println(projectDAO.getAll());
        System.out.println(projectDAO.getById((long)15));
        projectDAO.delete(project);
    }
}
