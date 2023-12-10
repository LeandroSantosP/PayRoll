package domian;
class SalaryCalculatorHourly extends SalaryCalculator {
    @Override
    double getFinal(int hours, Employee employee) {
        double salaryPerHourly = employee.getHourlySalary();
        return hours * salaryPerHourly;
    }
}

class SalaryCalculatorMountly extends SalaryCalculator {
    @Override
    double getFinal(int hours, Employee employee) {
        double hourlyRate = employee.getFixSalary() / 160;
        var diff = (hours - 160) * hourlyRate;
        return (employee.getFixSalary() + diff);
    }
}

class SalaryCalculatorVolunteer extends SalaryCalculator {
    @Override
    double getFinal(int hours, Employee employee) {
        return 0;
    }
}

public class SalaryCalculatorFactory {
    static public SalaryCalculator create(Employee employee) {
        if (employee.getPaymentType().equals("hourly")) return new SalaryCalculatorHourly();
        if (employee.getPaymentType().equals("mountly")) return new SalaryCalculatorMountly();
        if (employee.getPaymentType().equals("volunteer")) return new SalaryCalculatorVolunteer();
        throw new RuntimeException("Invalid employee type");
    }

}