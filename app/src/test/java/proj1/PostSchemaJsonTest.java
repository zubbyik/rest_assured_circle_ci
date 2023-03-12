package proj1;

import org.junit.jupiter.api.Test;
import java.io.InputStream;

import static io.restassured.RestAssured.get;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class PostSchemaJsonTest {
    @Test void test_posts_json_schema(){
        InputStream posts = getClass().getClassLoader().getResourceAsStream("posts-schema.json");
        get("https://jsonplaceholder.typicode.com/posts")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body(matchesJsonSchema(posts));
    }
}
