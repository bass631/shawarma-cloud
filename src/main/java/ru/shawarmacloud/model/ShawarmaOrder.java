package ru.shawarmacloud.model;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import ru.shawarmacloud.udt.ShawarmaUDT;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Table("orders")
public class ShawarmaOrder {

    private static final long serialVersionUID = 1L;

    @PrimaryKey
    private UUID id = Uuids.timeBased();

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

    @Column("shawarmas")
    private List<ShawarmaUDT> shawarmas = new ArrayList<>();

    public void addShawarma(ShawarmaUDT shawarma) {
        this.shawarmas.add(shawarma);
    }
}
