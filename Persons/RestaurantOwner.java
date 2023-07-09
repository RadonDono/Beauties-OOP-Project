package Persons;

import Order.Restaurant;

import java.util.ArrayList;

public class RestaurantOwner extends Person
{
    //TODO: Complete It!!!
    static ArrayList<RestaurantOwner> restaurantOwners=new ArrayList<>();
//////////////////////////////////////////////////////////////////////
//
    ArrayList<Restaurant> restaurants=new ArrayList<>();



//////////////////////////////////////////////////////////////////////
//constructors


//////////////////////////////////////////////////////////////////////
//functions


//////////////////////////////////////////////////////////////////////
//static functions
    public static RestaurantOwner getRestaurantOwner(int ownerID)
    {
        for(RestaurantOwner restaurantOwner:restaurantOwners)
        {
            if(restaurantOwner.ID==ownerID)
            {
                return restaurantOwner;
            }
        }
        return null;
    }


}
