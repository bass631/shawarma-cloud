package ru.dbastrygin.shawarmacloud.repository;

import org.springframework.data.repository.CrudRepository;
import ru.dbastrygin.shawarmacloud.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
