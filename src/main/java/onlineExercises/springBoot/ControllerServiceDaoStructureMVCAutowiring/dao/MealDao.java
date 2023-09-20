package onlineExercises.springBoot.ControllerServiceDaoStructureMVCAutowiring.dao;

import org.springframework.stereotype.Repository;
import onlineExercises.springBoot.ControllerServiceDaoStructureMVCAutowiring.model.Meal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MealDao {
    private List<Meal> mealList = new ArrayList<>();

    public void addMeal(Meal meal){
        this.mealList.add(meal);
    }

    public void deleteMeal(String mealName){
        this.mealList.removeIf(meal -> meal.getName().equals(mealName));
    }
    public void updateMeal(Meal meals){
        this.mealList.removeIf(meal -> meal.getName().equals(meals.getName()));
        this.mealList.add(meals);
    }

    public List<Meal> getMeals(){
        return this.mealList;
    }
}
