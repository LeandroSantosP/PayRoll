package domian;
import java.util.ArrayList;

public abstract class SalaryCalculator {
    double calculate(Employee employee, ArrayList<EmployeeTimeRecord> records) {
        int hours = 0;
        for (EmployeeTimeRecord employeeTimeRecord : records) {
            hours += (int) (employeeTimeRecord.checkOutDate().getTime() - employeeTimeRecord.checkingDate().getTime()) / (1000 * 60 * 60);
        }
        return this.getFinal(hours, employee);
    };
    abstract double getFinal(int hours, Employee employee);
}
