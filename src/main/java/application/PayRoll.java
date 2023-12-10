package application;
import domian.Employee;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class PayRoll {
    final private TimeRecordRepository timeRecordRepository;
    final private EmployeeRepository employeeRepository;

    PayRoll(TimeRecordRepository timeRecord, EmployeeRepository employeeRepository) {
        this.timeRecordRepository = timeRecord;
        this.employeeRepository = employeeRepository;
    }

    record PayRollInput(UUID employeeId, int month, int year) {
    }

    record PayRollOutput(String name, double salary) {
    }

    PayRollOutput execute(PayRollInput input) throws ExecutionException, InterruptedException {
        CompletableFuture<Employee> employee = this.employeeRepository.getEmployeeById(input.employeeId);
        var records = this.timeRecordRepository.getTimeRecordByEmployeeId(input.employeeId);
        var EmployeeData = employee.get();

        double salaryTotal = EmployeeData.getSalary(EmployeeData, records);

        return new PayRollOutput(EmployeeData.getName(), salaryTotal);
    }

}
