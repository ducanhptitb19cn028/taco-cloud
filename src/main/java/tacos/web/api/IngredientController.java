package tacos.web.api;

import org.springframework.hateoas.server.EntityLinks;
import org.springframework.web.bind.annotation.*;
import tacos.data.IngredientRepository;
import tacos.models.Ingredient;

import java.util.Optional;
@RestController
@RequestMapping(path = "/ingredients", produces = "application/json")
@CrossOrigin(origins = "*")
public class IngredientController {
    private final IngredientRepository ingredientRepo;
    final
    EntityLinks entityLinks;
    public IngredientController(IngredientRepository ingredientRepo, EntityLinks entityLinks) {
        this.ingredientRepo = ingredientRepo;
        this.entityLinks = entityLinks;
    }
    @GetMapping
    public Iterable<Ingredient> getAllIngredients() {
        return ingredientRepo.findAll();
    }

    @GetMapping("/{id}")
    public Ingredient ingredientById(@PathVariable("id") String id) {
        Optional<Ingredient> optIngredient = ingredientRepo.findById(id);
        return optIngredient.orElse(null);
    }
}