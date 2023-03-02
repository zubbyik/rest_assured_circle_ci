package proj1;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.post;
import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.put;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ApiTest {
    @Test void testapi(){
        get("https://jsonplaceholder.typicode.com/users/1").then().body("address.street", equalTo("Kulas Light"));
        get("https://jsonplaceholder.typicode.com/users/1").then().body("address.suite", equalTo("Apt. 556"));
        get("https://jsonplaceholder.typicode.com/users/1").then().body("address.city", equalTo("Gwenborough"));
        get("https://jsonplaceholder.typicode.com/users/1").then().body("address.zipcode", equalTo("92998-3874"));
        get("https://jsonplaceholder.typicode.com/users/1").then().body("address.geo.lat", equalTo("-37.3159"));
        get("https://jsonplaceholder.typicode.com/users/1").then().body("address.geo.lng", equalTo("81.1496"));
        get("https://jsonplaceholder.typicode.com/users/1").then().body("id", equalTo(1));
        get("https://jsonplaceholder.typicode.com/users/1").then().body("name", equalTo("Leanne Graham"));
    }
}
