package Persons;

import GetID.GetRandomID;

import java.util.ArrayList;

public class Deliver extends Person
{
    //TODO: Complete It!!!
    static ArrayList<Deliver> delivers=new ArrayList<>();
//////////////////////////////////////////////////////////////////////
//
    Deliver(String Name,String Password)
    {
        ID= GetRandomID.getID();
        name=Name;
        password=Password;
        role = Role.Deliver;
        delivers.add(this);
        Person.people.add(this);

    }



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
