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
        var employeeRepositoryMemory = new EmployeeRepositoryMemory();
        UUID id = UUID.randomUUID();
        var employeeOne = new Employee(id, "John Doe", 25, "Hourly");
        employeeRepositoryMemory.persist(employeeOne);

        var future = employeeRepositoryMemory.getEmployeeById(id);

        System.out.println(future.join());

        System.out.println("Chegou");

//        var payRoll = new PayRoll(new TimeRecordRepositoryMemory(), employeeRepositoryMemory);
//        var StokeEntryIncreaseInput = new PayRoll.PayRollInput(1, 12, 2023);
//        var output = payRoll.execute(StokeEntryIncreaseInput);
//
//        assertEquals(output.name(), "Matheus Silva");
//        assertEquals(output.salary(), 420);
    }

}
