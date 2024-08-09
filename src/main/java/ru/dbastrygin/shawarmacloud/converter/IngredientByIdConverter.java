package ru.dbastrygin.shawarmacloud.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.dbastrygin.shawarmacloud.model.Ingredient;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter() {
        ingredientMap.put("RGLV",
                new Ingredient("RGLV", "Обычный лаваш", Ingredient.Type.WRAP));
        ingredientMap.put("CELV",
                new Ingredient("CELV", "Сырный лаваш", Ingredient.Type.WRAP));
        ingredientMap.put("CHFL",
                new Ingredient("CHFL", "Куриное филе", Ingredient.Type.PROTEIN));
        ingredientMap.put("GRBF",
                new Ingredient("GRBF", "Говяжья котлета", Ingredient.Type.PROTEIN));
        ingredientMap.put("JLPN",
                new Ingredient("JLPN", "Халапеньо", Ingredient.Type.VEGGIES));
        ingredientMap.put("PTTO",
                new Ingredient("PTTO", "Картофель", Ingredient.Type.VEGGIES));
        ingredientMap.put("CHED",
                new Ingredient("CHED", "Чеддер", Ingredient.Type.CHEESE));
        ingredientMap.put("PARM",
                new Ingredient("PARM", "Пармезан", Ingredient.Type.CHEESE));
        ingredientMap.put("SISA",
                new Ingredient("SISA", "Фирменный соус", Ingredient.Type.SAUCE));
        ingredientMap.put("SRCA",
                new Ingredient("SRCA", "Сметана", Ingredient.Type.SAUCE));
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }
}
