package ru.shawarmacloud.repository;

import org.springframework.data.repository.CrudRepository;
import ru.shawarmacloud.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
