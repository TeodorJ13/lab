package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import java.util.List;

@Data
public class Chef {
    private Long id;
    private String FirstName;
    private String LastName;
    private String bio;
    private List<Dish> dishes;
}
