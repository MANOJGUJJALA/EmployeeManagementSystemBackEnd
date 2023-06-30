package employee.management.system.springbootbackend.repository;

import employee.management.system.springbootbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
