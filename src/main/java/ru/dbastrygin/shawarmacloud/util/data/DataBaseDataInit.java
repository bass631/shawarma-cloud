package ru.dbastrygin.shawarmacloud.util.data;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.dbastrygin.shawarmacloud.model.Ingredient;
import ru.dbastrygin.shawarmacloud.repository.IngredientRepository;

@Component
public class DataBaseDataInit {

    @Bean
    public CommandLineRunner commandLineRunner(IngredientRepository repository) {
        return args -> {
            repository.save(new Ingredient("PTLV", "Пита", Ingredient.Type.WRAP));
            repository.save(new Ingredient("CELV", "Сырный лаваш", Ingredient.Type.WRAP));
            repository.save(new Ingredient("KEBB", "Кебаб", Ingredient.Type.PROTEIN));
            repository.save(new Ingredient("GRBF", "Говяжья котлета", Ingredient.Type.PROTEIN));
            repository.save(new Ingredient("JLPN", "Халапеньо", Ingredient.Type.VEGGIES));
            repository.save(new Ingredient("PTTO", "Картофель", Ingredient.Type.VEGGIES));
        };
    }

    @Bean
    public ApplicationRunner applicationRunner(IngredientRepository repository) {
        return args -> {
            repository.save(new Ingredient("CHED", "Чеддер", Ingredient.Type.CHEESE));
            repository.save(new Ingredient("PARM", "Пармезан", Ingredient.Type.CHEESE));
            repository.save(new Ingredient("SISA", "Фирменный соус", Ingredient.Type.SAUCE));
            repository.save(new Ingredient("SRCA", "Сметана", Ingredient.Type.SAUCE));
        };
    }
}
