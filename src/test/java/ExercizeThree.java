import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ExercizeThree {
    @Test
    public void positivePostTest() {
        EmployeeData expectedEmployeeData = new EmployeeData("Airi Satou", 162700, 33, "fail data");
        Employee expectedEmployee = new Employee("success", expectedEmployeeData, "Successfully! Record has been fetched.");

        given().log().all()
                .body(expectedEmployee)
                .post("http://dummy.restapiexample.com/api/v1/create")
                .then()
                .log().all()
                .statusCode(200)
                .assertThat()
                .body("status", equalTo("success"))
                .body("message", equalTo("Successfully! Record has been added."));

    }
    @Test
    public void negativePostTest() {
        int i = 10;
        EmployeeData expectedEmployeeData = new EmployeeData("Airi Satou", 162700, 33, "fail data");
        Employee expectedEmployee = new Employee("success", expectedEmployeeData, "Successfully! Record has been fetched.");
        while(i > 0){
            i--;
            given()
                    .param("message", "Good ")
                    .post("http://dummy.restapiexample.com/api/v1/create")
                    .then();

        }
        given().log().all()
                .body(expectedEmployee)
                .post("http://dummy.restapiexample.com/api/v1/create")
                .then()
                .log().all()
                .statusCode(429);
    }

}
