package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.repository.ChefRepository;
import mk.ukim.finki.wp.lab.repository.DishRepository;
import mk.ukim.finki.wp.lab.service.ChefService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChefServiceImpl implements ChefService {

    private final ChefRepository chefRepository;
    private final DishRepository dishRepository;

    public ChefServiceImpl(ChefRepository chefRepository, DishRepository dishRepository) {
        this.chefRepository = chefRepository;
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Chef> listChefs() {
        return chefRepository.findAll();
    }

    @Override
    public Chef findById(Long id) {
        return chefRepository.findById(id).orElse(null);
    }

    @Override
    public Chef addDishToChef(Long chefId, String dishId) {

        Chef chef1 = chefRepository.findById(chefId).orElse(null);
        Dish dish1 = dishRepository.findByDishId(dishId);
        chef1.getDishes().add(dish1);
        return chefRepository.save(chef1);
    }

    @Override
    public Chef create(Long id, String firstName, String lastName, String bio, List<Dish> dishes) {
        Chef chef1 = new Chef(id, firstName, lastName, bio,dishes);
        chefRepository.save(chef1);
        return chef1;
    }

    @Override
    public Chef update(Long id, String firstName, String lastName, String bio, List<Dish> dishes) {
        Chef chef1 = chefRepository.findById(id).orElse(null);
        if (chef1 == null) {
            return null;
        }
        chef1.setId(id);
        chef1.setFirstName(firstName);
        chef1.setLastName(lastName);
        chef1.setBio(bio);
        chef1.setDishes(dishes);
        chefRepository.save(chef1);
        return chef1;
    }

    @Override
    public void delete(Long id) {
        chefRepository.deleteById(id);
    }
}