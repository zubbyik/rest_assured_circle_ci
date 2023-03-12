package proj1;

import org.junit.jupiter.api.Test;

import java.io.*;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.get;


public class SchemaTest {
    @Test void schema_testing() {
        //get(path).then().body(matchesJsonSchemaInClasspath(path));
        InputStream path = getClass().getClassLoader().getResourceAsStream("users-schema.json");
        assert path != null;
        get("https://jsonplaceholder.typicode.com/users")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body(matchesJsonSchema(path));

    }
}
