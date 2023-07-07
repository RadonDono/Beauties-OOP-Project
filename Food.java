import java.util.ArrayList;

public class Food
{
    static ArrayList<Food> foods=new ArrayList<>();
//////////////////////////////////////////////////////////////////////
//
    private int foodID;
    private int restaurantID;
    private String name;
    private int price;
    private ArrayList<Integer> rating=new ArrayList<>();
    private ArrayList<Comment> comments=new ArrayList<>();
//////////////////////////////////////////////////////////////////////
//constructors
    Food(String Name,int RestaurantID,int Price)
    {
        foodID=GetRandomID.getID();
        name=Name;
        restaurantID=RestaurantID;
        price=Price;
        foods.add(this);
    }
//////////////////////////////////////////////////////////////////////
//functions
    int getRestaurantID() {return restaurantID;} //Breaking news: It gives you restaurantID
    String getName(){return name;} // JOJO DI DI DIN DIN DIN DIN DIN DIN GOLDEN WIND
    int getPrice(){return price;} // miew
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
