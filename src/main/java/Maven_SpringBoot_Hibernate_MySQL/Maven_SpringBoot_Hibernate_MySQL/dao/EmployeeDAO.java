package Maven_SpringBoot_Hibernate_MySQL.Maven_SpringBoot_Hibernate_MySQL.dao;

import java.util.List;

import Maven_SpringBoot_Hibernate_MySQL.Maven_SpringBoot_Hibernate_MySQL.model.Employee;

public interface EmployeeDAO {

    void addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    void deleteEmployee(Integer employeeId);

    void updateEmployee(Employee employee);

    Employee getEmployee(int employeeId);
}
