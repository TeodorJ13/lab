package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import org.springframework.stereotype.Component;
import lombok.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component @Data
public class DataHolder {
    public static List<Chef> chefs = new ArrayList<>();
    public static List<Dish> dishes = new ArrayList<>();

    @PostConstruct
    public void init() {
        dishes.add(new Dish("1", "Pasta Carbonara", "Italian", 20));
        dishes.add(new Dish("2", "Beef Wellington", "British", 45));
        dishes.add(new Dish("3", "Sushi", "Japanese", 30));
        dishes.add(new Dish("4", "Beans", "Macedonian", 40));
        dishes.add(new Dish("5", "Gyros", "Greek", 20));

        chefs.add(new Chef(1L, "Gordon", "Ramsay", "Famous British chef with 16 Michelin stars", new ArrayList<>()));
        chefs.add(new Chef(2L, "Jamie", "Oliver", "Healthy food advocate", new ArrayList<>()));
        chefs.add(new Chef(3L, "Massimo", "Bottura", "Italian chef, owner of Osteria Francescana", new ArrayList<>()));
        chefs.add(new Chef(4L, "Heston", "Blumenthal", "Chef known for molecular gastronomy", new ArrayList<>()));
        chefs.add(new Chef(5L, "Alice", "Waters", "American chef and food activist", new ArrayList<>()));

    }

}
