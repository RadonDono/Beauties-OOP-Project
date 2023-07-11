package view;

import LocationAndMap.ras;
import controller.UserController;
import Persons.User;
import enums.Message;
import Order.Restaurant;
import LocationAndMap.map;

public class UserMenu extends Menu{
    static User user=null;

    private final UserController controller;

    // Singleton Pattern
    public UserMenu(User us) {
        user = us;
        this.controller = UserController.getInstance();
    }

    @Override
    public void run() {
        showOptions();
        String choice = this.getChoice();

        switch (choice) {
        case "1":
        case "restaurants":
        this.showRestaurant();
        break;

        case "2":
        case "orders":
        this.Showorders();
        break;

        case "3":
        case "charge account":
        this.Charge_Account();
        break;
        case "4":
        case "exit":
            this.exit();
            break;
        default:
        System.out.println(Message.INVALID_CHOICE);
        }
    }

    private void showRestaurant() {
        map m=new map();
        Restaurant restaurant=new Restaurant("ajdar",99,"hotdog",m.get_location(7));
        Restaurant restauran=new Restaurant("ajdar",99,"hotdog",m.get_location(7));
        Restaurant restaura=new Restaurant("ajdar",99,"hotdog",m.get_location(7));
        for (int i = 0; i < Restaurant.restaurants.size(); i++) {
            System.out.println(Restaurant.restaurants.get(i));
        }

        this.run();
    }

    private void Showorders() {
    }

    private void Charge_Account() {
    }

    private void exit() {
    }

    @Override
    protected void showOptions() {
            System.out.println("what do you want to do?");
            System.out.println("1. restaurants");
            System.out.println("2. orders");
            System.out.println("3. charge account");
            //todo: comment
        System.out.println("4. exit");
    }

}
