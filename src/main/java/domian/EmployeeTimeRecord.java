package domian;

import java.util.Date;
import java.util.UUID;

public record EmployeeTimeRecord(UUID id, UUID employeeId, Date checkingDate, Date checkOutDate) {

}
