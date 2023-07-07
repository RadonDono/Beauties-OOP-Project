import java.awt.*;
import java.util.ArrayList;

public class Comment
{
    static ArrayList<Comment> comments=new ArrayList<>();
//////////////////////////////////////////////////////////////////////
//
    private String body;
    private int commentID;
    private int userID;
    private int foodID;
    private int restaurantID;
    private boolean respond=false;
    private String respondBody;
//////////////////////////////////////////////////////////////////////
//constructors
    Comment(int FoodID,int UserID,String Body)
    {
        foodID=FoodID;
        userID=UserID;
        restaurantID= Food.getFood(foodID) != null ? Food.getFood(foodID).getRestaurantID() : 0;
        commentID=GetRandomID.getID();
        body=Body;
        comments.add(this);
        Food.getFood(foodID).addComment(this);
        Restaurant.getRestaurant(restaurantID).receiveAnOrder(commentID);

    }
//////////////////////////////////////////////////////////////////////
//functions

    void setRespond(String RespondBody) //let's set respond!
    {
        respond=true;
        respondBody=RespondBody;
    }


//////////////////////////////////////////////////////////////////////
//static functions
    static Comment getComment(int commentID) //searching comments using their IDs
    {
        for (Comment comment : comments)
        {
            if (comment.commentID==commentID)
            {
                return comment;
            }
        }
        return null;
    }
}
