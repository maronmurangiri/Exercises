package onlineExercises.springBoot.ControllerServiceDaoStructureMVCAutowiring.service;

import onlineExercises.springBoot.ControllerServiceDaoStructureMVCAutowiring.dao.MealDao;
import onlineExercises.springBoot.ControllerServiceDaoStructureMVCAutowiring.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    MealDao mealDao;

    @Autowired
    public MealService(MealDao mealDao) {
        this.mealDao = mealDao;
    }

    public void addMeal(Meal meal){
        mealDao.addMeal(meal);
    }

    public void deleteMeal(String mealName){
        mealDao.deleteMeal(mealName);
    }
    public void updateMeal(Meal meal){
        mealDao.updateMeal(meal);
    }
    public List<Meal> getMeals(){
        return  mealDao.getMeals();
    }
}
