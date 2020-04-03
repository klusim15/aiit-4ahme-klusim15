package jsontutorial.k2;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author Simon Klug
 */
public class TestGsonBuilder {
    
    //1. Default constructor
    Gson gson1 = new Gson();
 
    //2. Using GsonBuilder
    Gson gson2 = new GsonBuilder()
             .disableHtmlEscaping()
             .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
             .setPrettyPrinting()
             .serializeNulls()
             .create();
}