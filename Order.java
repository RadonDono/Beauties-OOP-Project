import java.util.ArrayList;

public class Order
{
    static ArrayList<Order> orders=new ArrayList<>();
//////////////////////////////////////////////////////////////////////
//
    int orderID;
    ArrayList<Integer> foodIDs=new ArrayList<>();
    int restaurantID;
    int deliverID;
    int userID;
    Status status;
    path Path;
//////////////////////////////////////////////////////////////////////
//constructors
    Order(int UserID,int RestaurantID)
    {
        orderID=orders.size();
        restaurantID=RestaurantID;
        userID=UserID;
        orders.add(this);
    }

//////////////////////////////////////////////////////////////////////
//functions
    int price()
    {
        int pr=0;
        for(int ID : foodIDs)
        {
            pr+=Food.getFood(ID).price;
        }
        return pr;
    }
    void addFood(int foodID)
    {
        foodIDs.add(foodID);
    }

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

    void statusRise()
    {
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
        }
        else if (status.equals(null))
        {
            status=Status.NeedRestaurantAccept;
        }
    }

    void cancelOrder()
    {
        status=Status.Canceled;
    }


//////////////////////////////////////////////////////////////////////
//static functions
    static Order getOrder(int orderID)
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
