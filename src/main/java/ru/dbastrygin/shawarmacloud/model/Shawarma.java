package ru.dbastrygin.shawarmacloud.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Shawarma {

    private Long id;

    @NotNull
    @Size(min = 2, message = "Ведите название")
    private String name;

    private List<Ingredient> ingredients;
    private Date createAt = new Date();

}
