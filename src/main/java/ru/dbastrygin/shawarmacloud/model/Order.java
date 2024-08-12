package ru.dbastrygin.shawarmacloud.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.ArrayList;
import java.util.List;

@Data
public class Order {

    @NotBlank(message = "Введите имя получателя")
    private String deliveryName;

    @NotBlank(message = "Введите улицу")
    private String deliveryStreet;

    @NotBlank(message = "Введите город")
    private String deliveryCity;

    @CreditCardNumber(message = "Введите номер карты")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([2-9][0-9])$", message = "Введите срок действия карты")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Введите CVV код")
    private String ccCVV;

    private List<Shawarma> shawarmas = new ArrayList<>();

    public void addShawarma(Shawarma shawarma) {
        this.shawarmas.add(shawarma);
    }
}
