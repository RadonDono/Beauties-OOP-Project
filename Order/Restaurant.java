package Order;

import GetID.GetRandomID;
import LocationAndMap.ras;

import java.util.ArrayList;

public class Restaurant
{
    static ArrayList<Restaurant> restaurants=new ArrayList<>();
//////////////////////////////////////////////////////////////////////
//
    private final int restaurantID;
    private final int ownerID;
    private String name;
    private String foodType;
    private ArrayList<Food> activeFoods =new ArrayList<>();
    private ArrayList<Food> deActiveFoods =new ArrayList<>();
    private ArrayList<Comment> receivedComments =new ArrayList<>();
    private ArrayList<Order> receivedOrders=new ArrayList<>();
    private ArrayList<Order> currentOrders=new ArrayList<>();
    private ArrayList<Order> finishedOrders=new ArrayList<>();
    private ras location;

//////////////////////////////////////////////////////////////////////
//constructors
    Restaurant(String Name,int OwnerID,String FoodType,ras Location)
    {
        name=Name;
        ownerID=OwnerID;
        foodType=FoodType;
        restaurantID= GetRandomID.getID();
        location=Location;
        restaurants.add(this);
    }

//////////////////////////////////////////////////////////////////////
//functions
    int getRestaurantID(){return restaurantID;}

    ras getLocation(){return location;}
    String getName(){return name;}

    String getFoodType(){return foodType;}

    void changeFoodType(String FoodType)
    {
        foodType=FoodType;
        activeFoods =new ArrayList<>();
    }

    void receiveAnOrder(int orderID) //look at the name
    {
           receivedOrders.add(Order.getOrder(orderID));
    }
    void acceptAnOrder(int orderID) // :) 8--->
    {
        receivedOrders.remove(Order.getOrder(orderID));
        currentOrders.add(Order.getOrder(orderID));
    }
    void declineAnOrder(int orderID) //how mean!
    {
        receivedOrders.remove(Order.getOrder(orderID));
    }
    void orderFinished(int orderID) //let a restaurant know that their order is finished
    {
        currentOrders.remove(Order.getOrder(orderID));
        finishedOrders.add(Order.getOrder(orderID));
    }

    void addFood(String name,int price) //add food to restaurant
    {
        Food food=new Food(name,this.restaurantID,price);
        activeFoods.add(food);
    }
    void deleteAFood(int FoodID) //how to deleteAFood
    {
        activeFoods.remove(Food.getFood(FoodID));
        Food.deleteFood(FoodID);
    }
    void deActiveAFood(int foodID)  //you can deactive an active food
    {
        Food food=Food.getFood(foodID);
        food.deactivateFood();
        deActiveFoods.add(food);
        activeFoods.remove(food);
    }
    void activeAFood(int foodID) //active a deactive food
    {
        Food food=Food.getFood(foodID);
        food.activateFood();
        deActiveFoods.remove(food);
        activeFoods.add(food);
    }
//////////////////////////////////////////////////////////////////////
//static functions
    static Restaurant getRestaurant(int restaurantID) //search restaurants using their IDs
    {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.restaurantID == restaurantID) {
                return restaurant;
            }
        }
        return null;
    }
}

