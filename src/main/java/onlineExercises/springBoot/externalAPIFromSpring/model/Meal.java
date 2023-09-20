package onlineExercises.springBoot.externalAPIFromSpring.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private double price;
    private boolean isWinterMeal;

    @OneToMany(mappedBy = "meal",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Ingredient> ingredients;

    public Meal(String name, String description, double price, boolean isWinterMeal) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.isWinterMeal = isWinterMeal;
    }


    public Meal() {
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", ingredients=" + ingredients +
                '}';
    }
}
