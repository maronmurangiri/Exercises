package onlineExercises.springBoot.CRUDOperationsExercise1.controller;

import onlineExercises.springBoot.CRUDOperationsExercise1.model.Ingredient;
import onlineExercises.springBoot.CRUDOperationsExercise1.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IngredientController {
    IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/get/ingredients")
    public ResponseEntity<?> getMeals(){
        try {
            return ResponseEntity.ok(ingredientService.getIngredients());
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/create/ingredient")
    public ResponseEntity<?> createIngredient(@RequestBody Ingredient ingredient){
        try {
            return ResponseEntity.ok(ingredientService.addMeal(ingredient));
        }
        catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update/ingredient/{id}")
    public ResponseEntity<?> updateIngredient(@PathVariable("id")Long id, @RequestBody Ingredient ingredient){
      try {
          return ResponseEntity.ok(ingredientService.updateMeal(id, ingredient));
      }
      catch (IllegalArgumentException e){
          return ResponseEntity.badRequest().body(e.getMessage());
      }
    }

    @DeleteMapping("/delete/ingredient/{id}")
    public ResponseEntity<?> deleteIngredient(@PathVariable("id") Long id){
        try {
            if (ingredientService.deleteMeal(id)){
                ResponseEntity.ok().body("Delete successful");
            }
            else {
                ResponseEntity.badRequest().body("not deleted");
            }

        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.internalServerError().build();
    }
}
