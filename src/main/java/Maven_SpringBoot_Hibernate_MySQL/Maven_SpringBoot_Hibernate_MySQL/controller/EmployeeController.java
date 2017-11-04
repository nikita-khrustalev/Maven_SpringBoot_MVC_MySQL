package Maven_SpringBoot_Hibernate_MySQL.Maven_SpringBoot_Hibernate_MySQL.controller;

import java.util.List;

import Maven_SpringBoot_Hibernate_MySQL.Maven_SpringBoot_Hibernate_MySQL.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import Maven_SpringBoot_Hibernate_MySQL.Maven_SpringBoot_Hibernate_MySQL.model.Employee;

import javax.validation.Valid;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    @RequestMapping("/employee/{id}")
//    public String getTeacher(@PathVariable int id, ModelMap employeeModel) {
//        Employee employee = employeeService.getEmployee(id);
//        employeeModel.addAttribute("employee", employee);
//        return "employee";
//    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getTeachers(ModelMap employeeModel) {
        List<Employee> employee = employeeService.getAllEmployees();
        employeeModel.addAttribute("employee", employee);
        return "employee";
    }


    @RequestMapping(value = "addEmployee")
    public String addPage() {
        return "employeeAdd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addEmployee(@RequestParam(value = "name", required = true) String name,
                              @RequestParam(value = "email", required = true) String email,
                              @RequestParam(value = "age", required = true) Integer age,
                              ModelMap employeeModel) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setEmail(email);
        employee.setAge(age);

        if ((employee.getAge() < 18) || (employee.getAge() > 100)) {
            employeeModel.addAttribute("msgErrorAge", "18 < Age < 100");
            if ((employee.getName().length() < 2) || (employee.getName().length() > 16)) {
                employeeModel.addAttribute("msgErrorName", "2 < Name < 16");
            }
            if ((employee.getEmail().length() < 2) || (employee.getEmail().length() > 16)) {
                employeeModel.addAttribute("msgErrorEmail", "2 < Email < 16");
            }
            return "employeeAdd";
        }

        employeeService.addEmployee(employee);
        employeeModel.addAttribute("msg", "Employee added successfully");
        List<Employee> employees = employeeService.getAllEmployees();
        employeeModel.addAttribute("employee", employees);
        return "redirect:/employee";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String updatePage(@PathVariable("id") int id, ModelMap employeeModel) {
        employeeModel.addAttribute("id", id);
        Employee employee = employeeService.getEmployee(id);
        employeeModel.addAttribute("employeeEdit", employee);
        return "employeeEdit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String updateEmployee(@RequestParam int id, @RequestParam(value = "name", required = true) String name,
                                 @RequestParam(value = "email", required = true) String email,
                                 @RequestParam(value = "age", required = true) Integer age,
                                 ModelMap employeeModel) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setEmail(email);
        employee.setAge(age);
        employeeService.updateEmployee(employee);
        List<Employee> employees = employeeService.getAllEmployees();
        employeeModel.addAttribute("employee", employees);
        employeeModel.addAttribute("id", id);
        employeeModel.addAttribute("msg", "Employee updated successfully");
        return "redirect:/employee";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteTeacher(@PathVariable int id, ModelMap employeeModel) {
        employeeService.deleteEmployee(id);
        List<Employee> employees = employeeService.getAllEmployees();
        employeeModel.addAttribute("employee", employees);
        employeeModel.addAttribute("msg", "Employee deleted successfully");
        return "redirect:/employee";
    }


}