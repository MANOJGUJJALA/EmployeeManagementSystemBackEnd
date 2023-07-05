package employee.management.system.springbootbackend.repository;

import employee.management.system.springbootbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query("SELECT e FROM Employee e JOIN FETCH e.register r WHERE r.id = :registerId")
    List<Employee> findAllEmployeesWithRegister(@Param("registerId") long registerId);
}
