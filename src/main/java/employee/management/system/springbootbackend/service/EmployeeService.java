package employee.management.system.springbootbackend.service;

import employee.management.system.springbootbackend.exception.ResourceNotFoundException;
import employee.management.system.springbootbackend.model.Employee;
import employee.management.system.springbootbackend.model.Register;
import employee.management.system.springbootbackend.repository.EmployeeRepository;
import employee.management.system.springbootbackend.repository.RegisterRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RegisterRepository registerRepository;

    @Transactional
    public List<Employee> getAllEmployes(long  register_id){

        Register register = registerRepository.findById(register_id)
                .orElseThrow(() -> new ResourceNotFoundException("Register not found with id: " + register_id));
        return employeeRepository.findAllEmployeesWithRegister(register_id);

//        return employeeRepository.findAll();
    }
    @Transactional

    public Employee addnewEmployee(Employee employee){

       return employeeRepository.save(employee);
    }

    @Transactional
    public Employee getEmployeeId(long id){
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(
                "Employee not exists "+id
        ));
                return employee;
    }

    @Transactional
    public Employee updateDetails(long id,Employee employeeDetails){
       Employee employee= employeeRepository.findById(id).orElseThrow(()->
               new ResourceNotFoundException("Employee not exists with id"+id)
       );
       employee.setFirstName(employeeDetails.getFirstName());
       employee.setLastName(employeeDetails.getLastName());
       employee.setEmailId(employeeDetails.getEmailId());
       employee.setPhoneNo(employeeDetails.getPhoneNo());
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
