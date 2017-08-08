import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by grodrigu on 31/05/17.
 */
public class googleApiTest {


    @Test
    public void shouldReturnPlaceWithSuccessfully() {

        RestAssured.baseURI = "https://maps.googleapis.com";

       given()
               .param("location", "-33.8670522,151.1957362")
               .param("radius", "500")
               .param("key", "AIzaSyDFKw77x3vr4uWkcFZHJNcFquo9BKbEcrk")
               .when()
               .get("/maps/api/place/nearbysearch/json")
               .then().assertThat().statusCode(200)
               .and().contentType(ContentType.JSON).and()
               .body("results[0].name" ,equalTo("Sydney"))
               .body("results[0].place_id" ,equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM"))
               .header("Server", "pablo");

          /* header("ahsdui","asgidh").
                cookie("ushusa","anduhu").
                body() */


    }

    @Test
    public void shouldReturnStatus200WithSuccessful(){

        RestAssured.baseURI = "https://maps.googleapis.com";
        get(RestAssured.baseURI).then().statusCode(200);
    }
}