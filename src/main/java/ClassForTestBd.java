import bl.HibernateUtil;
import model.Address;
import model.Employee;
import model.Project;
import service.AddressService;
import service.EmployeeService;
import service.ProjectService;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ClassForTestBd {

    public static void main(String[] args) throws SQLException {
        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();

        Address address = new Address();
        address.setCountry("Russia");
        address.setCity("Moscow");
        address.setStreet("Korjjj");
        address.setPostCode("234325");


        Employee employee = new Employee();
        employee.setFirstName("Alina");
        employee.setLastName("kkkkk");
        employee.setBirthday(new Date(11-11-111));
        employee.setAddress(address);

        Project project = new Project();
        project.setTitle("Title");

        Set<Employee> employees = new HashSet<>();
        employees.add(employee);
        project.setEmployees(employees);

        Set<Project> projects = new HashSet<>();
        projects.add(project);
        employee.setProjects(projects);

        addressService.add(address);
        employeeService.add(employee);
        projectService.add(project);

        HibernateUtil.shutdown();
    }

}