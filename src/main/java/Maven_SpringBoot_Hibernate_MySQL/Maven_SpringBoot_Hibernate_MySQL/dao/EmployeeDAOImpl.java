package Maven_SpringBoot_Hibernate_MySQL.Maven_SpringBoot_Hibernate_MySQL.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import Maven_SpringBoot_Hibernate_MySQL.Maven_SpringBoot_Hibernate_MySQL.model.Employee;
import Maven_SpringBoot_Hibernate_MySQL.Maven_SpringBoot_Hibernate_MySQL.mapper.EmployeeRowMapper;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addEmployee(Employee employee) {
        jdbcTemplate.update("INSERT INTO emp_tbl(name, email, age) VALUES (?, ?, ?)",
                new Object[]{employee.getName(), employee.getEmail(), employee.getAge()});
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employee = jdbcTemplate.query("SELECT * FROM emp_tbl", new EmployeeRowMapper());
        return employee;
    }

    public void deleteEmployee(Integer employeeId) {
        jdbcTemplate.update("delete from emp_tbl where id = ?", new Object[]{employeeId});
    }

    public Employee getEmployee(int empid) {
        Employee employee = jdbcTemplate.queryForObject("select * from emp_tbl where id = ?", new Object[]{empid},
                new EmployeeRowMapper());
        return employee;
    }

    public void updateEmployee(Employee employee) {
        jdbcTemplate.update("update emp_tbl set name = ?, email = ?, age = ? where id = ?",
                new Object[]{employee.getName(), employee.getEmail(), employee.getAge(), employee.getId()});
    }

}