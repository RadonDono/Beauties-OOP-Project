package view;

import LocationAndMap.ras;
import controller.UserController;
import Persons.User;
import enums.Message;
import Order.Restaurant;
import LocationAndMap.map;

import java.util.ArrayList;

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
        case "Status":
                this.showstatus();
                break;
        case "5":
        case "exit":
            this.exit();
            break;
        default:
        System.out.println(Message.INVALID_CHOICE);
        this.run();
        }
    }

    private void showstatus() {
        System.out.println("what do you want to do?");
        System.out.println("1. confirm");
        System.out.println("2. exit");
        String choice = this.getChoice();

        switch (choice) {
            case "1":
            case "Confirm":
                this.controller.confirmorder();
                this.time();
                break;
            case "2":
            case "exit":
                this.run();
                break;
            default:
                System.out.println(Message.INVALID_CHOICE);
        }
        this.showstatus();
    }

    private void time() {
        System.out.println("what do you want to do?");
        System.out.println("1. time");
        System.out.println("3. exit");
        String choice = this.getChoice();

        switch (choice) {
            case "1":
            case "time":
                this.controller.showtime();

                break;
            case "2":
            case "exit":
                this.run();
                break;
            default:
                System.out.println(Message.INVALID_CHOICE);
        }
        this.time();
    }

    private void showRestaurant() {
        map m=new map();
        Restaurant restaurant=new Restaurant("ajdar",99,"hotdog",m.get_location(7));
        Restaurant restauran=new Restaurant("ajdar",99,"hotdog",m.get_location(7));
        Restaurant restaura=new Restaurant("ajdar",99,"hotdog",m.get_location(7));
        for (int i = 0; i < Restaurant.restaurants.size(); i++) {
            System.out.println(Restaurant.restaurants.get(i));
        }
        showRestaurantoption();
        String choice = this.getChoice();

        switch (choice) {
            case "1":
            case "select":
                this.showSelectRestaurant();
                break;

            case "2":
            case "search":
                this.searchrestaurant();
                break;
            case "3":
            case "exit":
                this.run();
                break;
            default:
                System.out.println(Message.INVALID_CHOICE);
        }
        this.searchrestaurant();
    }

    private void showSelectRestaurant() {
        showselectOptions();
        String choice = this.getChoice();

        switch (choice) {
            case "1":
            case "select":
                String username = this.getInput("enter ID");

                Message message = this.controller.selectrestaurant(username);
                System.out.println(message == Message.SUCCESS ? "customer registered successfully" : message);
                if (message == Message.SUCCESS){
                    showMenu();
                }
                break;
            case "2":
            case "exit":
                this.exit();
                break;
            default:
                System.out.println(Message.INVALID_CHOICE);
        }
    }

    private void showMenu() {
        ArrayList<String> menu=controller.restaurant_now.getFood();
        for (String ar:menu) {
            System.out.println(ar);
        }
        showMenuOptions();
        String choice = this.getChoice();

        switch (choice) {
            case "1":
            case "select":
                this.showSelectfood();
                break;

            case "2":
            case "search":
                this.searchmenu();
                break;
            case "3":
            case "exit":
                this.showRestaurant();
                break;
            default:
                System.out.println(Message.INVALID_CHOICE);
        }
        this.searchrestaurant();

    }

    private void searchmenu() {
        String username = this.getInput("enter Food name:");
        ArrayList<String> message = this.controller.searchfood(username);
        if (message.size()==0){
            System.out.println(Message.Nofood);
        }
        else {
            for (int i = 0; i < message.size(); i++) {
                System.out.println(message.get(i));
            }
        }
        showSelectfood();
    }

    private void showSelectfood() {
        showselectOptions();
        String choice = this.getChoice();

        switch (choice) {
            case "1":
            case "select":
                String username = this.getInput("enter ID");

                Message message = this.controller.selectfood(username);
                System.out.println(message == Message.SUCCESS ? "customer registered successfully" : message);
                if (message == Message.SUCCESS){
                    this.run();
                }
                else{
                    this.showSelectfood();
                }
                break;
            case "2":
            case "exit":
                this.exit();
                break;
            default:
                System.out.println(Message.INVALID_CHOICE);
        }
    }

    private void showMenuOptions() {
        System.out.println("what do you want to do?");
        System.out.println("1. select");
        System.out.println("1. search");
        System.out.println("3. exit");
    }

    private void showselectOptions() {
        System.out.println("what do you want to do?");
        System.out.println("1. select");
        System.out.println("3. exit");
    }

    private void showRestaurantoption() {
        System.out.println("what do you want to do?");
        System.out.println("1. select");
        System.out.println("2. search");
        System.out.println("3. exit");
    }

    private void searchrestaurant() {
        String username = this.getInput("enter Restaurant name:");
        ArrayList<String> message = this.controller.searchrestaurant(username);
        if (message.size()==0){
            System.out.println(Message.NoRestaurant);
        }
        else {
            for (int i = 0; i < message.size(); i++) {
                System.out.println(message.get(i));
                
            }
        }
        showSelectRestaurant();
    }

    private void Showorders() {
        
    }

    private void Charge_Account() {
        controller.user.showmoney();
        System.out.println("what do you want to do?");
        System.out.println("1. charge");
        System.out.println("2. exit");
        String choice = this.getChoice();

        switch (choice) {
            case "1":
            case "charge":
                this.charge();
                this.Charge_Account();
                break;
            case "2":
            case "exit":
                this.run();
                break;
            default:
                System.out.println(Message.INVALID_CHOICE);
        }
        this.Charge_Account();
    }

    private void charge() {
        String money = this.getInput("enter money:");

        Message message = this.controller.charge(Integer.parseInt(money));
        System.out.println(message == Message.SUCCESS ? "account charged succesfully" : message);
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
