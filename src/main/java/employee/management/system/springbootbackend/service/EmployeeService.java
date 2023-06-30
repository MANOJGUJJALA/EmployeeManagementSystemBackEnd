package employee.management.system.springbootbackend.service;

import employee.management.system.springbootbackend.exception.ResourceNotFoundException;
import employee.management.system.springbootbackend.model.Employee;
import employee.management.system.springbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployes(){

        return employeeRepository.findAll();
    }

    public Employee addnewEmployee(Employee employee){

       return employeeRepository.save(employee);
    }

    public Employee getEmployeeId(long id){
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(
                "Employee not exists "+id
        ));
                return employee;
    }

    public Employee updateDetails(long id,Employee employeeDetails){
       Employee employee= employeeRepository.findById(id).orElseThrow(()->
               new ResourceNotFoundException("Employee not exists with id"+id)
       );
       employee.setFirstName(employeeDetails.getFirstName());
       employee.setLastName(employeeDetails.getLastName());
       employee.setEmailId(employeeDetails.getEmailId());

       employeeRepository.save(employee);
       return  employee;
    }

    public Employee deleteEmploye(long id){

       Employee employee= employeeRepository.findById(id).orElseThrow( ()->
                new ResourceNotFoundException("Employee id not exists "+id));

        employeeRepository.delete(employee);
        return  employee;

    }
}
