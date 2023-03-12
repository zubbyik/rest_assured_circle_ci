package proj1;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import static io.restassured.RestAssured.get;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class AlbumJsonSchemaTest {
    @Test void test_album_json_scema(){
        InputStream album = getClass().getClassLoader().getResourceAsStream("album-schema.json");
        get("https://jsonplaceholder.typicode.com/albums")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body(matchesJsonSchema(album));
    }
}
