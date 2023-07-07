import java.util.ArrayList;

public class Restaurant
{
    static ArrayList<Restaurant> restaurants=new ArrayList<>();
//////////////////////////////////////////////////////////////////////
//
    int restaurantID;
    int ownerID;
    String name;
    String foodType;
    ArrayList<Food> foods=new ArrayList<>();
    ArrayList<Comment> receivedComments =new ArrayList<>();
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
    static Restaurant getRestaurant(int restaurantID)
    {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.restaurantID == restaurantID) {
                return restaurant;
            }
        }
        return null;
    }


}
