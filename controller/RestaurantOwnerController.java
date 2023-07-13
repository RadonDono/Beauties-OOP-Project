package controller;

import LocationAndMap.map;
import LocationAndMap.ras;
import Order.Food;
import Order.Order;
import Order.Restaurant;
import Persons.Person;
import Persons.RestaurantOwner;
import enums.Message;
import Order.Comment;

import java.util.ArrayList;

public class RestaurantOwnerController {
    public RestaurantOwner restaurantOwner=null;
    public Restaurant restaurant=null;

    public RestaurantOwnerController(RestaurantOwner us) {
        restaurantOwner=us;
    }

    public Message chrckid(String id) {
        if (restaurantOwner.isItAnOwnedRestaurant(Integer.parseInt(id))){
            restaurant= Restaurant.getRestaurant(Integer.parseInt(id));
            return Message.SUCCESS;
        }
        else{
            return Message.incorrectid;
        }
    }

    public Message addfood(String name,String price) {
        restaurant.addFood(name,Integer.parseInt(price));
        return Message.SUCCESS;
    }

    public Message deletefood(String Id) {
        restaurantOwner.deleteFoodFromMenu(restaurant.getRestaurantID(), Integer.parseInt(Id));
        return Message.SUCCESS;
    }

    public Message editfoodname(String name,int id) {
        restaurantOwner.editAFoodName(restaurant.getRestaurantID(),id,name);
        return Message.SUCCESS;
    }
    public Message editfoodprice(int price,int id) {
        restaurantOwner.editAFoodPrice(restaurant.getRestaurantID(),id,price);
        return Message.SUCCESS;
    }

    public Message activefood(int parseInt) {
        restaurantOwner.activeFood(restaurant.getRestaurantID(),parseInt);
        return Message.SUCCESS;
    }
    public Message checkprogressfood(int id){
        for (Order order:restaurant.currentOrders) {
            for (int x:order.getFoodIDs()) {
                if (x==id){
                    return Message.progressfood;
                }
            }
        }
        return Message.SUCCESS;
    }

    public Message deactive(String name) {
        restaurantOwner.deActiveFood(restaurant.getRestaurantID(),Integer.parseInt(name));
        return Message.SUCCESS;
    }

    public Message setdiscount(int id, int percent, int time) {
        if (Food.getFood(id).localDiscount==0&&percent<50) {
            restaurantOwner.setADiscountOnAFood(restaurant.getRestaurantID(),id,percent);
            return Message.SUCCESS;
        }
        return Message.discounteror;
    }

    public Double showrate(int id) {
        return Food.getFood(id).getRate();
    }

    public ArrayList<String> showcomment(int id) {
        ArrayList<String> x=new ArrayList<>();
        for (Comment comment:Food.getFood(id).getcomment()) {
            x.add(comment.toString());
        }
        return x;
    }

    public ArrayList<String> showorder() {
        restaurant.
    }

    public void editlocation(int mokh) {
        this.restaurant.editLocation(get_loc(mokh));
    }
    ras get_loc(int s){
        map m=new map();
        return m.get_location(s);
    }

    public int showlocation() {
        return restaurant.getLocation().number;
    }
}
