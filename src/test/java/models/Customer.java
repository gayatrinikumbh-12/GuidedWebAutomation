package models;

import com.github.javafaker.Faker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder(toBuilder = true)
@NoArgsConstructor @AllArgsConstructor
public class Customer {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
   // private Address shippingAddress;
   private PaymentMode paymentMode;
   // private Card cardDetails;
    //private Address billingAddress;

    public Customer init() {

        Faker faker = new Faker();

        return this.toBuilder()
            .email(faker.internet().emailAddress())
            .firstName(faker.name().firstName())
            .lastName(faker.name().lastName())
            .password(faker.random().hex(6))
            .build();
    }
}
