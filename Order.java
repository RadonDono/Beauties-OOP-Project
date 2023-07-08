import java.util.ArrayList;

public class Order
{
    static ArrayList<Order> orders=new ArrayList<>();
//////////////////////////////////////////////////////////////////////
//
    private final int orderID;
    private ArrayList<Integer> foodIDs=new ArrayList<>();
    private final int restaurantID;
    private int deliverID;
    private final int userID;
    private Status status;
    private path masir;
    private Comment comment;
//////////////////////////////////////////////////////////////////////
//constructors
    Order(int UserID,int RestaurantID)
    {
        orderID=GetRandomID.getID();
        restaurantID=RestaurantID;
        Restaurant.getRestaurant(RestaurantID).receiveAnOrder(orderID);
        userID=UserID;
        orders.add(this);
//        masir=  todo: do something about path
    }

//////////////////////////////////////////////////////////////////////
//functions
    int getRestaurantID(){return restaurantID;}
    void deliverFond(int DeliverID)
    {
        deliverID=DeliverID;
        this.statusRise();
    }
    ArrayList<Integer> getFoodIDs(){return foodIDs;}
    int price() //calculate price of the order
    {
        int pr=0;
        for(int ID : foodIDs)
        {
            pr+=Food.getFood(ID).getPrice();
        }
        return pr;
    }
    void addFood(int foodID)
    {
        foodIDs.add(foodID);
    } //add food to order

    void removeFood(int foodID) //remove food from your order
    {
        for(int i=0;i<foodIDs.size();i++)
        {
            if(foodIDs.get(i)==foodID)
            {
                foodIDs.remove(i);
            }
        }
    }

    void statusRise() //leveling up the status!!
    {
        //todo: complete each case with what user ,deliver and restaurant needs to know
        if(status.equals(Status.NeedRestaurantAccept))
        {
            status=Status.NeedDeliverAccept;
            Restaurant.getRestaurant(restaurantID).acceptAnOrder(orderID);
        }
        else if (status.equals(Status.NeedDeliverAccept))
        {
            status=Status.InWay;
        }
        else if (status.equals(Status.InWay))
        {
            status=Status.Delivered;
        }
        else if (status.equals(Status.Delivered))
        {
            status=Status.Finished;
            Restaurant.getRestaurant(restaurantID).orderFinished(orderID);
        }
        else if (status.equals(null))
        {
            status=Status.NeedRestaurantAccept;
            Restaurant.getRestaurant(restaurantID).receiveAnOrder(orderID);
        }
    }

    void cancelOrder() //you know what it does!
    {
        status=Status.Canceled;
    }

    void userSetComment(int userID,String comment) //the user set a single comment for all off the foods in an order
    {
        if(userID==this.userID)
        {
            for(int i=0;i<foodIDs.size();i++)
            {
                this.comment=new Comment(foodIDs.get(i),userID,comment);
            }
        }
    }

    void userChangeTheComment(int UserID,String NewBody) //user can change the comment before receiving respond
    {
        if(UserID==this.userID&&!Comment.getComment(comment.getCommentID()).getRespond())
        {
            for(int i=0;i<foodIDs.size();i++)
            {
                this.comment=new Comment(foodIDs.get(i),userID,NewBody);
            }
        }
    }

    void restaurantSetRespond(int restaurantID,String respond) //a restaurant owner can set respond
    {
        if(this.restaurantID==restaurantID)
        {
            comment.setRespond(respond);
        }
    }


//////////////////////////////////////////////////////////////////////
//static functions
    static Order getOrder(int orderID) //searching order using their IDs
    {
        for (Order order: orders)
        {
            if (order.orderID==orderID)
            {
                return order;
            }
        }
        return null;
    }
}
