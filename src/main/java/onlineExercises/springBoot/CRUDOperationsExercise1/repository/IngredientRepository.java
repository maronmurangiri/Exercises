package onlineExercises.springBoot.CRUDOperationsExercise1.repository;

import onlineExercises.springBoot.CRUDOperationsExercise1.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient,Long> {
}
