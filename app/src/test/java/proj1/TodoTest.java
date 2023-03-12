package proj1;

import org.junit.jupiter.api.Test;
import java.io.InputStream;

import static io.restassured.RestAssured.get;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class TodoTest {
    @Test void test_todo_json_schema(){
        InputStream todo = getClass().getClassLoader().getResourceAsStream("todo-schema.json");
        get("https://jsonplaceholder.typicode.com/todos").then().assertThat().body(matchesJsonSchema(todo));
    }
}
