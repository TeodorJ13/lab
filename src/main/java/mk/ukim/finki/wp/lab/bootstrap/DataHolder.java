package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
@Data
public class DataHolder {
    public static List<Chef> chefs = new ArrayList<>(5);
    public static List<Dish> dishes = new ArrayList<>(5);

    @PostConstruct
    public void init() {
        // Иницијализација на 5 Dishes
        dishes.addAll(Arrays.asList(
                createDish("D1", "Pasta Carbonara", "Italian", 20),
                createDish("D2", "Beef Wellington", "British", 30),
                createDish("D3", "Chicken Tikka Masala", "Indian", 15),
                createDish("D4", "Pepperoni Pizza", "Italian", 25),
                createDish("D5", "Quiche Lorraine", "French", 20)
        ));

        // Иницијализација на 5 Chefs
        chefs.addAll(Arrays.asList(
                createChef(1L, "Gordon", "Ramsay", "Famous British chef", Arrays.asList(dishes.get(0), dishes.get(1))),
                createChef(2L, "Jamie", "Oliver", "Healthy food advocate", Arrays.asList(dishes.get(2))),
                createChef(3L, "Nigella", "Lawson", "Famous for desserts", Arrays.asList(dishes.get(3))),
                createChef(4L, "Thomas", "Keller", "Michelin star chef", Arrays.asList(dishes.get(4))),
                createChef(5L, "Wolfgang", "Puck", "Fusion cuisine expert", Arrays.asList(dishes.get(0), dishes.get(4)))
        ));
    }

    private static Dish createDish(String id, String name, String cuisine, int prepTime) {
        Dish dish = new Dish();
        dish.setDishId(id);
        dish.setName(name);
        dish.setCuisine(cuisine);
        dish.setPreparationTime(prepTime);
        return dish;
    }

    private static Chef createChef(Long id, String firstName, String lastName, String bio, List<Dish> dishes) {
        Chef chef = new Chef();
        chef.setId(id);
        chef.setFirstName(firstName);
        chef.setLastName(lastName);
        chef.setBio(bio);
        chef.setDishes(dishes);
        return chef;
    }
}