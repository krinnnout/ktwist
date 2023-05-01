package sia.ktwist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sia.ktwist.Ingredient;
import sia.ktwist.Ingredient.Type;
import sia.ktwist.Kebab;

import lombok.extern.slf4j.Slf4j;
import sia.ktwist.KebabOrder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequestMapping("/design")
@SessionAttributes("kebabOrder")
public class DesignKebabController {
    @ModelAttribute
    public void addIngredientToModel(Model model){
        List<Ingredient> ingredientList = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
        );

        Type[] types = Ingredient.Type.values();
        for(Ingredient.Type type : types){
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredientList, type));
        }
    }

    @ModelAttribute(name = "kebabOrder")
    public KebabOrder order(){
        return new KebabOrder();
    }

    @ModelAttribute(name = "kebab")
    public Kebab kebab(){
        return new Kebab();
    }

    @GetMapping
    public String showDesignForm(){
        return "design";
    }

    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredientList, Type type){
        return ingredientList
                .stream()
                .filter(x ->x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping
    public String processKebab(Kebab kebab, @ModelAttribute KebabOrder kebabOrder){
        kebabOrder.addKebab(kebab);
        log.info("Processing Kebab: {}", kebab);

        return "redirect:/orders/current";
    }

}
