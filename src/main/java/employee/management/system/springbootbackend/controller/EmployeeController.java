package employee.management.system.springbootbackend.controller;

import employee.management.system.springbootbackend.model.Employee;
import employee.management.system.springbootbackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin("*")
//@CrossOrigin(origins = {"http://localhost:3000/"})
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping

    public List<String > getStrings(){
        List<String > a=new ArrayList<>();
        a.add("MAnoj");
        a.add("harsh");
        return a;
    }

//    public List<Employee> getALlEmplpoyees(){
//        return employeeService.getAllEmployes();
//    }


    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){



       return employeeService.addnewEmployee(employee);

    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeId(@PathVariable long id){

           Employee employee= employeeService.getEmployeeId(id);

                return ResponseEntity.ok(employee);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeedetails){

        Employee em=employeeService.updateDetails(id,employeedetails);

        return ResponseEntity.ok(em);
    }

    @DeleteMapping("{id}")

    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){

        employeeService.deleteEmploye(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
