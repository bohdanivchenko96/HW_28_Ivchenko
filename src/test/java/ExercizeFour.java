import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ExercizeFour {

    @Test
    public void positivePutTest() {
        EmployeeData expectedEmployeeData = new EmployeeData("Airi Satou", 162700, 33, "fail data");
        Employee expectedEmployee = new Employee("success", expectedEmployeeData, "Successfully! Record has been fetched.");

        given().log().all()
                .body(expectedEmployee)
                .put("http://dummy.restapiexample.com/api/v1/update/21")
                .then()
                .log().all()
                .statusCode(200)
                .body("status", equalTo("success"))
                .body("message", equalTo("Successfully! Record has been updated."));

    }
    @Test
    public void negativePostTest() {
        int i = 10;
        EmployeeData expectedEmployeeData = new EmployeeData("Airi Satou", 162700, 33, "fail data");
        Employee expectedEmployee = new Employee("success", expectedEmployeeData, "Successfully! Record has been fetched.");
        while(i > 0){
            i--;
            given().log().all()
                    .body(expectedEmployee)
                    .put("http://dummy.restapiexample.com/api/v1/update/?id=1")
                    .then();

        }
        given().log().all()
                .body(expectedEmployee)
                .put("http://dummy.restapiexample.com/api/v1/update/?id=2")
                .then()
                .log().all()
                .statusCode(301);
    }
}
