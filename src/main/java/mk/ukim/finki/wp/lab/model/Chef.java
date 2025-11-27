//package mk.ukim.finki.wp.lab.model;
//
//import lombok.Data;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Data
//public class Chef {
//    Long id;
//    String firstName;
//    String lastName;
//    String bio;
//    List<Dish> dishes;
//
//    public Chef(Long id, String firstName, String lastName, String bio, List<Dish> dishes) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.bio = bio;
//        this.dishes = dishes;
//    }
//}

package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Chef {
    Long id;
    String firstName;
    String lastName;
    String bio;
    List<Dish> dishes;

    public Chef() {
        this.dishes = new ArrayList<>();
    }

    public Chef(Long id, String firstName, String lastName, String bio, List<Dish> dishes) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.dishes = dishes;
    }
}