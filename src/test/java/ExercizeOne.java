import citrus.listeners.LogListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
@Listeners(LogListener.class)
public class ExercizeOne {

    @Test
    public void getAllEmployeesPositiveTest() {
        given().log().all()
                .when()
                .get("http://dummy.restapiexample.com/api/v1/employees")
                .then()
                .log().all()
                .statusCode(200)
                .assertThat()
                .body("status", equalTo("success"))
                .body("data.employee_name", hasItems("Sonya Frost"))
                .body("data.employee_age", instanceOf(ArrayList.class));

    }
    @Test
    public void getAllEmployeesNegativeTest() {
        given().log().all()
                .when()
                .get("http://dummy.restapiexample.com/api/v2/employees")
                .then()
                .log().all()
                .statusCode(404);

    }
}
