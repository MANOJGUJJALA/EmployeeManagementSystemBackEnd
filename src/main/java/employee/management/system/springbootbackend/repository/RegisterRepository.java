package employee.management.system.springbootbackend.repository;

import employee.management.system.springbootbackend.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegisterRepository extends JpaRepository<Register,Long> {
    List<Register> findByUsernameAndPassword(String user_name,String password);
}
