package ru.dbastrygin.shawarmacloud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class ShawarmaOrder {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Введите имя получателя")
    private String deliveryName;

    @NotBlank(message = "Введите улицу")
    private String deliveryStreet;

    @NotBlank(message = "Введите город")
    private String deliveryCity;

    @CreditCardNumber(message = "Введите номер карты")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])\\/(2[0-9]|[3-9][0-9])$", message = "Введите срок действия карты")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Введите CVV код")
    private String ccCVV;

    private Date placeAt = new Date();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Shawarma> shawarmas = new ArrayList<>();

    public void addShawarma(Shawarma shawarma) {
        this.shawarmas.add(shawarma);
    }
}
