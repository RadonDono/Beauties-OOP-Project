import java.util.ArrayList;

public class Food
{
    static ArrayList<Food> foods=new ArrayList<>();
//////////////////////////////////////////////////////////////////////
//
    int foodID;
    int restaurantID;
    String name;
    int price;
    ArrayList<Integer> rating=new ArrayList<>();
    ArrayList<Comment> comments=new ArrayList<>();
//////////////////////////////////////////////////////////////////////
//constructors
    Food(String Name,int RestaurantID,int Price)
    {
        foodID=foods.size();
        name=Name;
        restaurantID=RestaurantID;
        price=Price;
        foods.add(this);
    }
//////////////////////////////////////////////////////////////////////
//functions

    void rate(int Rating)
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
    static Food getFood(int foodID)
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

    static void deleteFood(int foodID)
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
