package jsontutorial.k4;

import com.google.gson.Gson;
import jsontutorial.k1_1.Employee;

/**
 *
 * @author Simon Klug
 */
public class TestJsonToJava {
    
    public static void main(String[] args) {
        Gson gson = new Gson();
 
        System.out.println(
        gson.fromJson("{'id':1,'firstName':'Simon','lastName':'Klug','roles':['ADMIN','MANAGER']}", Employee.class));
    }
}