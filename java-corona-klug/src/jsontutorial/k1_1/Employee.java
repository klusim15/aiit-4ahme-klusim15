package jsontutorial.k1_1;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Simon Klug
 */
public class Employee {
    
    private Integer id;
    private String firstName;
    private String lastName;
    private List<String> roles;
    
    public Employee(){      
    }
    
    public Employee(Integer id, String firstName, String lastName, Date birthDate){
        if (id <= 0) {
            throw new IllegalArgumentException("ungueltiger Wert für ID");
        }
        if (firstName.isEmpty() || firstName == null) {
            throw new IllegalArgumentException("ungueltiger Wert für firstName");
        }
        if (lastName.isEmpty() || lastName == null) {
            throw new IllegalArgumentException("ungueltiger Wert für lastName");
        }
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public int getId () {
        return id;
    }
    
    public void setId(int i) {
        if (id <= 0) {
            throw new IllegalArgumentException("ungueltiger Wert fuer ID");
        }
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.isEmpty() || firstName == null) {
            throw new IllegalArgumentException("ungueltiger Wert fuer firstName");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.isEmpty() || lastName == null) {
            throw new IllegalArgumentException("ungueltiger Wert fuer firstName");
        }
        this.lastName = lastName;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
    
    @Override
    public String toString()
    {
        return "Employee [id=" + id + ", firstName=" + firstName + ", " +
               "lastName=" + lastName + ", roles=" + roles + "]";
    }
}