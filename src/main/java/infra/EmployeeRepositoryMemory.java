package infra;

import application.EmployeeRepository;
import domian.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class EmployeeRepositoryMemory implements EmployeeRepository {
    private final Map<UUID, Employee> employees = new HashMap<UUID, Employee>();


    @Override
    public CompletableFuture<Employee> getEmployeeById(UUID id) {
        return CompletableFuture.supplyAsync(() -> {
            Employee Employee = this.employees.get(id);
            if (Employee == null) {
                throw new RuntimeException("Employee not found");
            }
            return Employee;
        });
    }

    @Override
    public void persist(Employee employee) {
        var future = CompletableFuture.runAsync(() -> {
            this.employees.put(employee.getId(), employee);
        });
    }
}
