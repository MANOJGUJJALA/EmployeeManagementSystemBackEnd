package employee.management.system.springbootbackend.service;

import employee.management.system.springbootbackend.Dto.UserValidate;
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

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class RegisterService {

    @Autowired
    private RegisterRepository registerRepository ;


    @Transactional
    public Register validateUser(String  userName,String password){

        List<Register>userData= registerRepository.findByUsernameAndPassword(userName,password);
         if(!userData.isEmpty() && userData!=null){
//             int valid=0;
                Register user=userData.get(0);
//                        if(user.getUsername().equals(userName)&&user.getPassword().equals(password)){
//                            valid=1;
//                                }
//                if(valid==1){
                    return user;
//                }
//               return "not Valid User";
         }
         return null;
    }
    @Transactional
    public List<Register> getAllUsers(){

        return registerRepository.findAll();
    }

    @Transactional
    public Register addnewRegister(Register register){
//        System.out.println("regiter user is "+register.getEmail_id()+register.getUser_name());
        return registerRepository.save(register);
    }

    @Transactional
    public Register addnewEmployee(Employee employee,long registerId){
        System.out.println(employee.getPhoneNo()+"-"+employee.getFirstName()
                +" "+employee.getLastName()+"-"+employee.getId());
        Register r=employee.getRegister();
        System.out.println("++++++++");
        Register register=registerRepository.findById(registerId).orElseThrow(()->new ResourceNotFoundException(
                "Register not exists "+id
        ));
        employee.setRegister(register);
        register.getEmployees().add(employee);

        return registerRepository.save(register);
    }


    @Transactional
    public Register getRegisterId(long id){
        Register register=registerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(
                "Register not exists "+id
        ));
        return register;
    }

//    public Register updateDetails(long id,Employee employeeDetails){
//        Register register= registerRepository.findById(id).orElseThrow(()->
//                new ResourceNotFoundException("Employee not exists with id"+id)
//        );
//        register.setFirstName(employeeDetails.getFirstName());
//        register.setLastName(employeeDetails.getLastName());
//        register.setEmailId(employeeDetails.getEmailId());
//
//        registerRepository.save(register);
//        return  register;
//    }

//    public Register deleteEmploye(long id){
//
//        Register register= registerRepository.findById(id).orElseThrow( ()->
//                new ResourceNotFoundException("Employee id not exists "+id));
//
//        registerRepository.delete(register);
//        return  register;
//
//    }
}
