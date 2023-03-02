package proj1;

import org.junit.jupiter.api.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.get;


public class SchemaTest {
    @Test void schema_testing(){
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            String path = classLoader.getResource("products-schema").getPath();
            get("https://jsonplaceholder.typicode.com/users").then().body(matchesJsonSchemaInClasspath(path));
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        //        get("https://jsonplaceholder.typicode.com/users").then().assertThat().body(matchesJsonSchemaInClasspath(path));
    }
}
