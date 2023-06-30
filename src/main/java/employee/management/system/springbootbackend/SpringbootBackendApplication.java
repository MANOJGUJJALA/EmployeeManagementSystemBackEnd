package employee.management.system.springbootbackend;

import employee.management.system.springbootbackend.model.Employee;
import employee.management.system.springbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

//	public String PORT=System.getenv("PORT");

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public void run(String... args) throws Exception {

//		Employee e=new Employee();
//		e.setFirstName("Rayudu");
//		e.setLastName("Manoj");
//		e.setEmailId("manoj@gmail.com");
//		employeeRepository.save(e);
//
//		Employee e1=new Employee();
//		e1.setFirstName("Simma");
//		e1.setLastName("Vasavi");
//		e1.setEmailId("vasu@gmail.com");
//		employeeRepository.save(e1);
	}
}
