package application;

import domian.EmployeeTimeRecord;

import java.util.ArrayList;

public interface TimeRecordRepository {
    ArrayList<EmployeeTimeRecord> getTimeRecordByEmployeeId(int id);

}
