package onlineExercises.springBoot.CRUDOperationsExercise1.service;

import onlineExercises.springBoot.CRUDOperationsExercise1.model.Ingredient;
import onlineExercises.springBoot.CRUDOperationsExercise1.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    public Ingredient addMeal(Ingredient ingredient){
        if (ingredientRepository.existsById(ingredient.getId())){
            throw new IllegalArgumentException("The ingredient exist");
        }
          return   ingredientRepository.save(ingredient);
    }
    public Ingredient updateMeal(Long id,Ingredient updatedIngredient){
        if (ingredientRepository.existsById(id)){
            return  ingredientRepository.save(updatedIngredient);
        }
        else {
            throw new IllegalArgumentException("The meal with such id doesn't exist");
        }
    }
    public boolean deleteMeal(Long id){
        if(ingredientRepository.existsById(id)){
            ingredientRepository.deleteById(id);
            return true;
        }
        else {
            throw new IllegalArgumentException("No such ingredient");

        }

    }

    public List<Ingredient> getIngredients(){
        return ingredientRepository.findAll();
    }
}
