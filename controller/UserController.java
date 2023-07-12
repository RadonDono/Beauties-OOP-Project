package controller;
import Order.Restaurant;
import enums.Message;

import java.util.ArrayList;

public class UserController {
    public Restaurant restaurant_now=null;
    private static UserController instance = null;

    private UserController() {

    }

    private static void setInstance(UserController instance) {
        UserController.instance = instance;
    }

    public static UserController getInstance() {
        if (UserController.instance == null) {
            UserController.setInstance(new UserController());
        }

        return UserController.instance;
    }

    public ArrayList<String> searchrestaurant(String name) {
        ArrayList<String> x=new ArrayList<>();
        for (int i = 0; i < Restaurant.restaurants.size(); i++) {
            if (Restaurant.restaurants.get(i).getName().equals(name)){
                x.add(Restaurant.restaurants.get(i).toString());
            }
        }
        return x;
    }

    public Message selectrestaurant(String ID) {
        restaurant_now=Restaurant.getRestaurant(Integer.parseInt(ID));
        if(Restaurant.getRestaurant(Integer.parseInt(ID))==null){
            return Message.NoRestaurant;
        }
        else{
            return Message.SUCCESS;
        }
    }



    public ArrayList<String> searchfood(String username) {
        ArrayList<String> x=new ArrayList<>();
        for (int i = 0; i < Restaurant.restaurants.size(); i++) {
            if (restaurant_now.activeFoods.get(i).getName().equals(username)){
                x.add(Restaurant.restaurants.get(i).toString());
            }
        }
        return x;
    }

    public Message selectfood(String ID) {
        restaurant_now.addFood(Integer.parseInt(ID));
        if(Restaurant.getRestaurant(Integer.parseInt(ID))==null){
            return Message.NoRestaurant;
        }
        else{
            return Message.SUCCESS;
        }
    }
    }
}
