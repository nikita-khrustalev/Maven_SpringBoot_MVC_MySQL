package Maven_SpringBoot_Hibernate_MySQL.Maven_SpringBoot_Hibernate_MySQL.mapper;

import Maven_SpringBoot_Hibernate_MySQL.Maven_SpringBoot_Hibernate_MySQL.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int row) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setEmail(rs.getString("email"));
        employee.setAge(rs.getInt("age"));
        employee.setName(rs.getString("name"));
        return employee;
    }


}
