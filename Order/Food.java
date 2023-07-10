package Order;

import GetID.GetRandomID;

import java.util.ArrayList;

public class Food
{
    static ArrayList<Food> foods=new ArrayList<>();
//////////////////////////////////////////////////////////////////////
//
    private final int foodID;
    private final int restaurantID;
    private String name;
    private int price;
    private int localDiscount=0; //it's in percent.
    private boolean active;
    private ArrayList<Integer> rating=new ArrayList<>();
    private ArrayList<Comment> comments=new ArrayList<>();
//////////////////////////////////////////////////////////////////////
//constructors
    public Food(String Name,int RestaurantID,int Price)
    {
        foodID= GetRandomID.getID();
        name=Name;
        restaurantID=RestaurantID;
        price=Price;
        active=true;
        foods.add(this);
    }
//////////////////////////////////////////////////////////////////////
//functions
    int getRestaurantID() {return restaurantID;} //Breaking news: It gives you restaurantID
    String getName(){return name;} // JOJO DI DI DIN DIN DIN DIN DIN DIN GOLDEN WIND
    int getFoodID(){return foodID;}
    int getPrice() //it gives you the price after calculating the discount
    {
        if(localDiscount==0)
        {
            return price;
        }
        return price*localDiscount/100;

    }
    public boolean isFoodActive(){return active;}
    public void activateFood(){active=true;}
    public void deactivateFood(){active=false;}
    void addComment(Comment comment)
    {
        comments.add(comment);
    }

    void rate(int Rating) //a user will use this to rate
    {
        rating.add(Rating);
    }

    void editFoodName(String name)
    {
        this.name=name;
    }

    void editFoodPrice(int price)
    {
        this.price=price;
    }

    public void setDiscount(int percent){localDiscount=percent;}


//////////////////////////////////////////////////////////////////////
//static functions
    static Food getFood(int foodID) //searching foods using their IDs
    {
        for(Food food : foods)
        {
            if(food.foodID==foodID)
            {
                return food;
            }
        }
        return null;
    }

    static void deleteFood(int foodID) //you know what it does...
    {
        for(Food food : foods)
        {
            if(food.foodID==foodID)
            {
                foods.remove(food);
            }
        }
    }

}
