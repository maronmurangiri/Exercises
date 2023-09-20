package onlineExercises.springBoot.ControllerServiceDaoStructureMVCAutowiring.controller;

import onlineExercises.springBoot.ControllerServiceDaoStructureMVCAutowiring.service.MealService;
import onlineExercises.springBoot.ControllerServiceDaoStructureMVCAutowiring.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MealController {
    private MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping(value = "/get/meals")
    public ResponseEntity<?> getMeals(){
        return ResponseEntity.ok(mealService.getMeals());
    }

    @PutMapping(value = "/put/meal")
    public ResponseEntity<?> putMeal(@RequestBody Meal meal){
        mealService.addMeal(meal);
        return ResponseEntity.ok("Meal Added");
    }

    @DeleteMapping(value = "/delete/meal/{mealName}")
    public ResponseEntity<?>  deleteMeal(@PathVariable String mealName){
        mealService.deleteMeal(mealName);
        return ResponseEntity.ok("Meal Deleted");
    }

    @PostMapping(value = "/post/replace-meal")
    public ResponseEntity<?> postMeal(@RequestBody Meal meal){
        mealService.updateMeal(meal);
        return ResponseEntity.ok("Meal updated successfully");
    }
}
