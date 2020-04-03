package jsontutorial.k3;

import com.google.gson.Gson;
import java.util.Arrays;
import jsontutorial.k1_1.Employee;

/**
 *
 * @author Simon Klug
 */
public class TestJavaToJson {
    
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("Lokesh");
        employee.setLastName("Gupta");
        employee.setRoles(Arrays.asList("ADMIN", "MANAGER"));
 
        Gson gson = new Gson();
 
        System.out.println(gson.toJson(employee));
    }
}