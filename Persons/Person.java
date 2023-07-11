package Persons;

import LocationAndMap.ras;

import java.util.ArrayList;

public abstract class Person
{
    static ArrayList<Person> people=new ArrayList<>();
    protected int ID;
    protected String name;
    protected String password;
//////////////////////////////////////////////////////////////////////
// static functions
    public static Person getPerson(int personID)
    {
        for(Person person:people)
        {
            if(person.ID==personID)
            {
                return person;
            }
        }
        return null;
    }
    public static Person login(String name,String password)
    {
        for(Person person:people)
        {
            if(person.name.equals(name)&&person.password.equals(password))
            {
                return person;
            }
        }
        return null;
    }
    public static boolean isThereAPersonWithThisUserName(String name)
    {
        for(Person person:people)
        {
            if(person.name.equals(name))
            {
                return true;
            }
        }
        return false;
    }

}
