package com.example.fooddelivery.config;

import com.example.fooddelivery.model.Food;
import com.example.fooddelivery.model.OrderStatus;
import com.example.fooddelivery.model.Restaurant;
import com.example.fooddelivery.model.User;
import com.example.fooddelivery.repository.FoodRepository;
import com.example.fooddelivery.repository.OrderStatusRepository;
import com.example.fooddelivery.repository.RestaurantRepository;
import com.example.fooddelivery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
//Uncomment to load initial test data
//@Component
public class DemoData {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    //Uncomment to add test data.
//    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        persistRestaurants();

        persistUsers();

        persistFoods();

        persistOrderStatuses();


    }


    /**
     * Method to insert order statuses - master data.
     */
    private void persistOrderStatuses() {
        Arrays.asList("Order picked up","On the way","Delivered","Cancelled")
                .forEach(orderStatus->orderStatusRepository.save(new OrderStatus(orderStatus)));
    }

    /**
     * Method to insert sample foods for each restaurant.
     */
    private void persistFoods() {
        List<String> foods = Arrays.asList("pizza", "Tacos", "burger");
        List<String> restaurantNames = Arrays.asList("subway", "dominos", "pizza hut");
        restaurantNames.forEach(restaurantName->{
            Optional<Restaurant> restaurant=restaurantRepository.findByName(restaurantName);
            if(restaurant.isPresent())
                foods.forEach(food-> foodRepository.save(new Food(food,restaurant.get())));

        });
    }

    /**
     * Method to persist test users.
     */
    private void persistUsers() {
        List<String> userNames = Arrays.asList("jon doe", "Alice", "Bob");
        userNames.forEach(userName->userRepository.save(new User(userName,"Bengaluru")));
    }

    /**
     * Method to insert sample test restaurants.
     */
    private void persistRestaurants() {
        //Persist restaurants dummy data
        List<String> restaurantNames = Arrays.asList("subway", "dominos", "pizza hut");
        restaurantNames.forEach(restaurantName->restaurantRepository.save(new Restaurant(restaurantName)));
    }
}