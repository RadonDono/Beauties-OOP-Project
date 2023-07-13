package controller;
import GetID.GetRandomID;
import Order.Food;
import Order.Order;
import Order.Restaurant;
import Order.Comment;
import enums.Message;
import Persons.User;

import java.util.ArrayList;

public class UserController {
    public User usercon=null;
    public int orderidres;
    public Restaurant restaurant_now=null;

    public UserController(User us) {
        usercon=us;
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

        if(Food.getFood(Integer.parseInt(ID))==null){
            return Message.Nofood;
        }
        else{
            usercon.addFoodToOrder(Integer.parseInt(ID),usercon.getOrderIDbyRestaurant(orderidres));
            return Message.SUCCESS;
        }
    }

    public String showorder(int Id) {
        if (Order.getOrder(Id)==null){
            return "ID is incorrect";
        }
        else {
            return Order.getOrder(Id).toString();
        }
    }

    public Message charge(int money) {
        usercon.chargeAccount(money);
        return Message.SUCCESS;
    }

    public ArrayList<String> confirmorder() {
        ArrayList<String> s=new ArrayList<>();
        for (int i = 0; i < usercon.cart.size(); i++) {
            s.add(Order.getOrder(usercon.cart.get(i)).toString());
            usercon.sendAnOrderToTheRestaurant(usercon.cart.get(i));
        }
        
        return s;
    }

    public void showtime() {
    }

    public Message addrestaurantcomment(String com) {
        Comment comment=new Comment(usercon.getID(),com, GetRandomID.getID(),restaurant_now.getRestaurantID());
        return Message.commentadded;
    }

    public Message editrestaurantcomment(String username) {
    }
}
