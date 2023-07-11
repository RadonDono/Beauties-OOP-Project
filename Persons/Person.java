package Persons;

import LocationAndMap.ras;

import java.util.ArrayList;

public abstract class Person
{
    public static ArrayList<Person> people=new ArrayList<>();
    protected int ID;
    protected String name;
    protected String password;

    static Person getPerson(int personID)
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

}
