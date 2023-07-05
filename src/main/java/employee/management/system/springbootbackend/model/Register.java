package employee.management.system.springbootbackend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="register")
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "email_id")
    private String email_id;
    @Column(name = "password")
    private String   password;

    @Column(name = "confirmPassword")
    private String   confirmPassword;

    @OneToMany(mappedBy = "register", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "i_d",referencedColumnName = "id")
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }
}
