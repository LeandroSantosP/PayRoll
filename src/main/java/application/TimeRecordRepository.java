package application;
import domian.EmployeeTimeRecord;
import java.util.ArrayList;
import java.util.UUID;

public interface TimeRecordRepository {
    ArrayList<EmployeeTimeRecord> getTimeRecordByEmployeeId(UUID id);

}
