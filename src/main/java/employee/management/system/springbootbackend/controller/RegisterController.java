package employee.management.system.springbootbackend.controller;

import employee.management.system.springbootbackend.Dto.AddEmployee;
import employee.management.system.springbootbackend.Dto.UserValidate;
import employee.management.system.springbootbackend.model.Employee;
import employee.management.system.springbootbackend.model.Register;
import employee.management.system.springbootbackend.service.RegisterService;

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
@RequestMapping("/api/v1/registers")
public class RegisterController {

    @Autowired
   private RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping ("/user")
    public ResponseEntity<Register>validateUser(@RequestBody UserValidate user){

      Register person= registerService.validateUser(user.getUsername(),user.getPassword());
      if(person!=null){

          return new ResponseEntity<>(person,HttpStatus.OK);
      }
        return new ResponseEntity<>(new Register(),HttpStatus.NOT_FOUND);

    }

    @PostMapping("/addemployee/{registerId}")
    public ResponseEntity< Register> addEmployee(@PathVariable long registerId,@RequestBody Employee employee){

        Register register = registerService.addnewEmployee(employee,registerId);
        if (register != null) {
            return new ResponseEntity<>(register, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping
//
//    public List<Register> getALlEmplpoyees(){
//        return registerService.getAllUsers();
//    }
    @PostMapping()
    public Register createRegister(@RequestBody Register register){

        return registerService.addnewRegister(register);
    }
//    @GetMapping("{id}")
//    public ResponseEntity<Register> getRegisterId(@PathVariable long id){
//        Register register= registerService.getRegisterId(id);
//        return ResponseEntity.ok(register);
//    }

//    @PutMapping("{id}")
//    public ResponseEntity<Register> updateRegister(@PathVariable long id,@RequestBody Register registerdetails){
//        Register em=registerService.updateDetails(id,registerdetails);
//        return ResponseEntity.ok(em);
//    }

//    @DeleteMapping("{id}")
//    public ResponseEntity<HttpStatus> deleteRegister(@PathVariable long id){
//        registerService.deleteEmploye(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
