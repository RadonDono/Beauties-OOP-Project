package Persons;

import GetID.GetRandomID;
import LocationAndMap.ras;
import Order.Order;
import Order.Status;

import java.util.ArrayList;

public class User extends Person
{
    //TODO: Complete It!!!
    private static ArrayList<User> users=new ArrayList<>();

//////////////////////////////////////////////////////////////////////
//
    private int cash;
    private ArrayList<Integer> commentIDs=new ArrayList<>();
    private ArrayList<Integer> finishedOrdersID=new ArrayList<>();
    private ArrayList<Integer> inProgressOrdersID=new ArrayList<>();
    private ras location;

//////////////////////////////////////////////////////////////////////
//constructors
    public User(String Name, String Password, ras Location)
    {
        name=Name;
        password=Password;
        location=Location;
        ID= GetRandomID.getID();
        role = Role.User;
        users.add(this);
        Person.people.add(this);
    }
//////////////////////////////////////////////////////////////////////
//functions

    public ras getLocation(){return location;}
    public int getCash(){return cash;}

    public void newOrder(int RestaurantID) //when you want to start a new order
    {
        Order newOrder=new Order(ID,RestaurantID);
        inProgressOrdersID.add(newOrder.getOrderID());
    }
    public void addFoodToOrder(int foodID,int orderID)  //add food to an in progress order
    {
        if(isItAInProgressOrder(orderID))
        {
            Order order=Order.getOrder(orderID);
            order.addFood(foodID);
        }
    }
    public void removeFoodFromOrder(int foodID,int orderID)  //remove food from an in progress order
    {
        if(isItAInProgressOrder(orderID))
        {
            Order order=Order.getOrder(orderID);
            order.removeFood(foodID);
        }
    }
    public void sendAnOrderToTheRestaurant(int orderID) //when you finish ordering
    {
        if(isItAInProgressOrder(orderID))
        {
            Order order=Order.getOrder(orderID);
            order.setStatus(Status.NeedRestaurantAccept);
            cash-=order.price();
        }
    }
    public void cancelAnOrder(int orderID)
    {
        if(isItAInProgressOrder(orderID))
        {
            Order order=Order.getOrder(orderID);
            cash+= order.price();
            order.cancelOrder();

        }
    }
    public void rateAnOrder(int orderID,int rate)// A user will rate an order in range (1,5)
    {
        if(isItAInProgressOrder(orderID))
        {
            Order order=Order.getOrder(orderID);
            if(order.getStatus().equals(Status.Delivered))
            {
                order.rate(ID,rate);
            }
        }
    }

    public void rateAndCommentAnOrder(int orderID,int rate,String comment)// A user will rate and comment an order in range (1,5)
    {
        if(isItAInProgressOrder(orderID))
        {
            Order order=Order.getOrder(orderID);
            if(order.getStatus().equals(Status.Delivered))
            {
                order.rateAndComment(ID,rate,comment);
            }
        }
    }

    public void chargeAccount(int charge)
    {
        cash+=charge;
    }

    boolean isItAInProgressOrder(int orderID)
    {
        for(int ID:inProgressOrdersID)
        {
            if(ID==orderID)
            {
                return true;
            }
        }
        return false;
    }



//////////////////////////////////////////////////////////////////////
//static functions
    public static User getUser(int UserID)
    {
        for (User user:users) {
            if (user.ID==UserID) {
                return user;
            }
        }
        return null;
    }
}
