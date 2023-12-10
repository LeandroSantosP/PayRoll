package domian;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Employee {

    public Employee(UUID id, String name, int age, String paymentType, double fixSalary, double hourlySalary) {
        this.id = Objects.requireNonNullElseGet(id, UUID::randomUUID);
        this.name = name;
        this.age = age;
        this.PaymentType = paymentType;
        this.fixSalary = fixSalary;
        this.hourlySalary = hourlySalary;
    }

    public double getSalary(Employee employee, ArrayList<EmployeeTimeRecord> records) {
        var Factory = SalaryCalculatorFactory.create(employee);
        return Factory.calculate(employee, records);
    }

    private final UUID id;

    public double getFixSalary() {
        return fixSalary;
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    private final double fixSalary;
    private final double hourlySalary;

    public String getPaymentType() {
        return this.PaymentType;
    }

    private final String name;

    private final int age;

    private final String PaymentType;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
