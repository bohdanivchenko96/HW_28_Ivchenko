import java.util.Objects;

public class Employee {
    String status;
    EmployeeData data;
    String message;

    public Employee(String status, EmployeeData data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(status, employee.status) &&
                data.equals(employee.data) &&
                Objects.equals(message, employee.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, data, message);
    }
}
