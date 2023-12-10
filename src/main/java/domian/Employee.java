package domian;

import java.util.Objects;
import java.util.UUID;

public class Employee {

    public Employee(UUID id, String name, int age, String paymentType) {
        this.id = Objects.requireNonNullElseGet(id, UUID::randomUUID);
        this.name = name;
        this.age = age;
        this.PaymentType = paymentType;
    }

    private UUID id;

    public String getPaymentType() {
        return PaymentType;
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
