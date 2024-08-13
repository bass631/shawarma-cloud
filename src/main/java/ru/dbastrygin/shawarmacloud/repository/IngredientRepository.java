package ru.dbastrygin.shawarmacloud.repository;

import ru.dbastrygin.shawarmacloud.model.Ingredient;

import java.util.Optional;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);
}
