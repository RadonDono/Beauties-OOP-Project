import java.awt.*;
import java.util.ArrayList;

public class Comment
{
    static ArrayList<Comment> comments=new ArrayList<>();
//////////////////////////////////////////////////////////////////////
//
    String body;
    int commentID;
    int userID;
    int foodID;
    int restaurantID;
    boolean respond=false;
    String respondBody="";
//////////////////////////////////////////////////////////////////////
//constructors
    Comment(int FoodID,int UserID,String Body)
    {
        foodID=FoodID;
        userID=UserID;
        restaurantID= Food.getFood(foodID) != null ? Food.getFood(foodID).restaurantID : 0;
        commentID=comments.size();
        body=Body;
        comments.add(this);
        Food.getFood(foodID).comments.add(this);
        Restaurant.getRestaurant(restaurantID).receivedComments.add(this);

    }
//////////////////////////////////////////////////////////////////////
//functions

    void setRespond(String RespondBody)
    {
        respond=true;
        respondBody=RespondBody;
    }


//////////////////////////////////////////////////////////////////////
//static functions
    static Comment getComment(int commentID)
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
