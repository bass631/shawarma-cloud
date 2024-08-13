package ru.dbastrygin.shawarmacloud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Shawarma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, message = "Ведите название")
    private String name;

    @ManyToMany
    private List<Ingredient> ingredients;

    private Date createAt = new Date();
}
