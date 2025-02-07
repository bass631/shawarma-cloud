package ru.shawarmacloud.util;

import ru.shawarmacloud.model.Ingredient;
import ru.shawarmacloud.udt.IngredientUDT;

public class ShawarmaUDRUtils {

    public static IngredientUDT toIngredientUDT(Ingredient ingredient) {
        return new IngredientUDT(ingredient.getName(), ingredient.getType());
    }
}
