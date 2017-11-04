package Maven_SpringBoot_Hibernate_MySQL.Maven_SpringBoot_Hibernate_MySQL.service;

import java.util.List;

import Maven_SpringBoot_Hibernate_MySQL.Maven_SpringBoot_Hibernate_MySQL.model.Employee;

public interface EmployeeService {

    void addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    void deleteEmployee(Integer employeeId);

    void updateEmployee(Employee employee);

    Employee getEmployee(int employeeId);


}
