package ru.dbastrygin.shawarmacloud.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ru.dbastrygin.shawarmacloud.model.Ingredient;
import ru.dbastrygin.shawarmacloud.model.Order;
import ru.dbastrygin.shawarmacloud.model.Shawarma;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignShawarmaController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("RGLV", "Обычный лаваш", Ingredient.Type.WRAP),
                new Ingredient("CELV", "Сырный лаваш", Ingredient.Type.WRAP),
                new Ingredient("CHFL", "Куриное филе", Ingredient.Type.PROTEIN),
                new Ingredient("GRBF", "Говяжья котлета", Ingredient.Type.PROTEIN),
                new Ingredient("JLPN", "Халапеньо", Ingredient.Type.VEGGIES),
                new Ingredient("PTTO", "Картофель", Ingredient.Type.VEGGIES),
                new Ingredient("CHED", "Чеддер", Ingredient.Type.CHEESE),
                new Ingredient("PARM", "Пармезан", Ingredient.Type.CHEESE),
                new Ingredient("SISA", "Фирменный соус", Ingredient.Type.SAUCE),
                new Ingredient("SRCA", "Сметана", Ingredient.Type.SAUCE)
        );

        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .toList();
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "shawarma")
    public Shawarma shawarma() {
        return new Shawarma();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processTaco(
            @Valid Shawarma shawarma, Errors errors,
            @ModelAttribute Order order) {
        if (errors.hasErrors()) {
            return "design";
        }

        order.addShawarma(shawarma);
        log.info("Processing shawarma: {}", shawarma);

        return "redirect:/orders/current";
    }
}

