package application;

import domian.Employee;
import infra.EmployeeRepositoryMemory;
import infra.TimeRecordRepositoryMemory;

import java.text.ParseException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PayRollTest {

    @Test
    void shouldCalculatePayRollToEmployeeHourly() throws ParseException, ExecutionException, InterruptedException {
        UUID id = UUID.randomUUID();
        var timeRecordRepositoryMemory = new TimeRecordRepositoryMemory(id);


        var employeeRepositoryMemory = new EmployeeRepositoryMemory();
        var employeeOne = new Employee(id, "John Doe", 25, "hourly", 0, 30);
        employeeRepositoryMemory.persist(employeeOne);

//        var employee1 = employeeRepositoryMemory.getEmployeeById(id);
//        var employee2 = employeeRepositoryMemory.getEmployeeById(id);
//        var employee3 = employeeRepositoryMemory.getEmployeeById(id);
//
//        CompletableFuture<Void> allOf = CompletableFuture.allOf(employee1, employee2, employee3);
//        allOf.join();
//        System.out.println(employee1.get().getName());
//        System.out.println(employee2.get().getName());
//        System.out.println(employee3.get().getName());


        var payRoll = new PayRoll(timeRecordRepositoryMemory, employeeRepositoryMemory);
        var StokeEntryIncreaseInput = new PayRoll.PayRollInput(id, 12, 2023);
        var output = payRoll.execute(StokeEntryIncreaseInput);

        assertEquals(output.name(), "John Doe");
        assertEquals(output.salary(), 420);
    }
    
    @Test
    void shouldCalculatePayRollToEmployeeMountly() throws ParseException, ExecutionException, InterruptedException {
        UUID id = UUID.randomUUID();
        var timeRecordRepositoryMemory = new TimeRecordRepositoryMemory(id);
        var employeeRepositoryMemory = new EmployeeRepositoryMemory();
        var employeeOne = new Employee(id, "Maria Souza", 25, "mountly", 3000, 0);
        employeeRepositoryMemory.persist(employeeOne);
        var payRoll = new PayRoll(timeRecordRepositoryMemory, employeeRepositoryMemory);
        var StokeEntryIncreaseInput = new PayRoll.PayRollInput(id, 12, 2023);
        var output = payRoll.execute(StokeEntryIncreaseInput);
        assertEquals(output.name(), "Maria Souza");
        assertEquals(output.salary(), 262.5);
    }

}
