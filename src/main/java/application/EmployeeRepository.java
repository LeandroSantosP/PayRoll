package application;
import domian.Employee;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface EmployeeRepository {
    CompletableFuture<Employee> getEmployeeById(UUID id);
    void persist(Employee employee);
}
