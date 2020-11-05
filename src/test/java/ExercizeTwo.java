import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;

public class ExercizeTwo {
    @Test
    public void positiveTestGetByID(){
        EmployeeData expectedEmployeeData = new EmployeeData("Airi Satou", 162700, 33, "");
        Employee expectedEmployee = new Employee("success", expectedEmployeeData, "Successfully! Record has been fetched.");
        Employee actualEmployeeResponse = given().log().all()
                .when()
                .get("http://dummy.restapiexample.com/api/v1/employee/5")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(Employee.class);
        assertEquals(actualEmployeeResponse, expectedEmployee);

    }

    @Test
    public void negativeTestGetByID(){
        EmployeeData expectedEmployeeData = new EmployeeData("Airi Satou", 162700, 33, "fail data");
        Employee expectedEmployee = new Employee("success", expectedEmployeeData, "Successfully! Record has been fetched.");
        Employee actualEmployeeResponse = given().log().all()
                .when()
                .get("http://dummy.restapiexample.com/api/v1/employee/5")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(Employee.class);
        assertNotEquals(actualEmployeeResponse, expectedEmployee);
    }

}
