import java.util.ArrayList;

public class Order
{
    static ArrayList<Order> orders=new ArrayList<>();
//////////////////////////////////////////////////////////////////////
//
    private int orderID;
    private ArrayList<Integer> foodIDs=new ArrayList<>();
    private int restaurantID;
    private int deliverID;
    private int userID;
    private Status status;
    private path Path;
//////////////////////////////////////////////////////////////////////
//constructors
    Order(int UserID,int RestaurantID)
    {
        orderID=GetRandomID.getID();
        restaurantID=RestaurantID;
        Restaurant.getRestaurant(RestaurantID).receiveAnOrder(orderID);
        userID=UserID;
        orders.add(this);
    }

//////////////////////////////////////////////////////////////////////
//functions
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

    void removeFood(int foodID)
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
            status=Status.NeedRestaurantAccept;
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
        }
    }

    void cancelOrder() //you know what it does!
    {
        status=Status.Canceled;
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
