package mk.ukim.finki.wp.lab.model;

import lombok.Data;

@Data
public class Dish {
    private String dishId;
    private String name;
    private String cuisine;
    private int preparationTime;
}
