package infra;


import application.TimeRecordRepository;
import domian.EmployeeTimeRecord;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class TimeRecordRepositoryMemory implements TimeRecordRepository {
    private final SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private ArrayList<EmployeeTimeRecord> arrayList;

    public TimeRecordRepositoryMemory(UUID employeeIdOne) throws ParseException {
        var initialState = new ArrayList<EmployeeTimeRecord>();

        Date dateIn = this.formato.parse("2023-06-21 09:00:00");
        Date dateOut =  this.formato.parse("2023-06-21 12:00:00");

        initialState.add(new EmployeeTimeRecord(UUID.randomUUID(), employeeIdOne, dateIn, dateOut));
        dateIn = this.formato.parse("2023-06-21 09:00:00");
        dateOut = this.formato.parse("2023-06-21 12:00:00");

        initialState.add(new EmployeeTimeRecord(UUID.randomUUID(), employeeIdOne, dateIn, dateOut));
        dateIn = this.formato.parse("2023-06-21 09:00:00");
        dateOut = this.formato.parse("2023-06-21 12:00:00");

        initialState.add(new EmployeeTimeRecord(UUID.randomUUID(), employeeIdOne, dateIn, dateOut));
        dateIn = this.formato.parse("2023-06-21 09:00:00");
        dateOut = this.formato.parse("2023-06-21 14:00:00");

        initialState.add(new EmployeeTimeRecord(UUID.randomUUID(), employeeIdOne, dateIn, dateOut));

        this.arrayList = initialState;
    }

    public ArrayList<EmployeeTimeRecord> getTimeRecordByEmployeeId(UUID id) {
        var response = new ArrayList<EmployeeTimeRecord>();
        for (EmployeeTimeRecord employeeTimeRecord : this.arrayList) {
            if (employeeTimeRecord.employeeId() == id) {
                response.add(employeeTimeRecord);
            }
        }
        return response;
    }
}
