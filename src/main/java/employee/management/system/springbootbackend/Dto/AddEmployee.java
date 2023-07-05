package employee.management.system.springbootbackend.Dto;

public class AddEmployee {
    String phoneNo;

    Long id;

    String firstName;
    String lastName;
    String emailId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
}
