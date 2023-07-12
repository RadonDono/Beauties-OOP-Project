package Order;

import GetID.GetRandomID;
import Persons.User;

import java.util.ArrayList;

public class Comment
{
    static ArrayList<Comment> comments=new ArrayList<>();
//////////////////////////////////////////////////////////////////////
//
    private String body;
    private final int commentID;
    private final int userID;
    private final int orderID;
    private final int restaurantID;
    private boolean respond=false;
    private String respondBody;
    private ArrayList<Integer> foodIDs=new ArrayList<>();
//////////////////////////////////////////////////////////////////////
//constructors
    Comment(int OrderID,int UserID,String Body)
    {
        userID=UserID;
        orderID=OrderID;
        restaurantID= Order.getOrder(OrderID).getRestaurantID();
        commentID= GetRandomID.getID();
        body=Body;
        comments.add(this);
        Order order=Order.getOrder(orderID);
        foodIDs=order.getFoodIDs();
        for(int i=0;i<order.getFoodIDs().size();i++)
        {
            Food.getFood(order.getFoodIDs().get(i)).addComment(this);
        }
        User.getUser(userID).getAComment(commentID);
        Restaurant.getRestaurant(restaurantID).receiveAComment(commentID);

    }
//////////////////////////////////////////////////////////////////////
//functions

    boolean getRespond(){return respond;}
    int getCommentID(){return commentID;}

    void setRespond(String RespondBody) //let's set respond!
    {
        if(!respond)
        {
            respond=true;
            respondBody=RespondBody;
        }
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
