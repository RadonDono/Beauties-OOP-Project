package Persons;

import LocationAndMap.ras;
import Order.Restaurant;

import java.util.ArrayList;

public class Deliver extends Person
{
    //TODO: Complete It!!!
    static ArrayList<Deliver> delivers=new ArrayList<>();
//////////////////////////////////////////////////////////////////////
//
    private ras location;



//////////////////////////////////////////////////////////////////////
//constructors


//////////////////////////////////////////////////////////////////////
//functions


//////////////////////////////////////////////////////////////////////
//static functions
    public static Deliver getDeliver(int deliverID)
    {
        for (Deliver deliver:delivers)
        {
            if(deliver.ID==deliverID)
            {
                return deliver;
            }
        }
        return null;
    }
}
