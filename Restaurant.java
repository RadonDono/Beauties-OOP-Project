import java.util.ArrayList;

public class Restaurant
{
    static ArrayList<Restaurant> restaurants=new ArrayList<>();
//////////////////////////////////////////////////////////////////////
//
    private int restaurantID;
    private int ownerID;
    private String name;
    private String foodType;
    private ArrayList<Food> foods=new ArrayList<>();
    private ArrayList<Comment> receivedComments =new ArrayList<>();
    private ArrayList<Order> receivedOrders=new ArrayList<>();
    private ArrayList<Order> currentOrders=new ArrayList<>();
    private ArrayList<Order> finishedOrders=new ArrayList<>();

//////////////////////////////////////////////////////////////////////
//constructors
    Restaurant(String Name,int OwnerID,String FoodType)
    {
        name=Name;
        ownerID=OwnerID;
        foodType=FoodType;
        restaurantID=restaurants.size();
        restaurants.add(this);
    }

//////////////////////////////////////////////////////////////////////
//functions
    static Restaurant getRestaurant(int restaurantID) //search restaurants using their IDs
    {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.restaurantID == restaurantID) {
                return restaurant;
            }
        }
        return null;
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
        foods.add(food);
    }


}
