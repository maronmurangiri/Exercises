package onlineExercises.springBoot.externalAPIFromSpring.dao;

import onlineExercises.springBoot.externalAPIFromSpring.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealDao extends JpaRepository<Meal,Long> {
    List<Meal> findByName(String name);
    List<Meal> findByPriceGreaterThanAndName(double price, String name);
    List<Meal> findByIsWinterMeal(boolean isWinterMeal);
}
