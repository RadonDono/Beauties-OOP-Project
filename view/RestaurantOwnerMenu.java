package view;

import Order.Food;
import Order.Restaurant;
import Persons.User;
import Persons.RestaurantOwner;
import controller.RestaurantOwnerController;
import controller.UserController;
import enums.Message;

import java.util.ArrayList;

public class RestaurantOwnerMenu extends Menu{
    static RestaurantOwner user=null;

    RestaurantOwnerController controller;

    // Singleton Pattern
    public RestaurantOwnerMenu(RestaurantOwner us) {
        user = us;
        this.controller = new RestaurantOwnerController(us);
    }

    @Override
    public void run() {
        if (user.ownedRestaurants.size() > 1) {
            System.out.println("please select one off the restaurants");
            showretaurants();
            String id = this.getInput("enter ID");
            Message message = this.controller.chrckid(id);
            System.out.println(message == Message.SUCCESS ? "entered successfully" : message);
        } else {
            this.controller.restaurant = user.ownedRestaurants.get(0);
        }
        showOptions();
        option();
    }
    void option(){
        String choice = this.getChoice();

        switch (choice) {
            case "1":
            case "menu":
                this.showmenu();
                break;

            case "2":
            case "orders":
                this.Showorders();
                break;

            case "3":
            case "location":
                this.lcation();
                break;
            case "4":
            case "foodtype":
                this.foodtype();
                break;
            case "5":
            case "exit":
                break;
            default:
                System.out.println(Message.INVALID_CHOICE);
                this.run();
        }
    }

    private void foodtype() {
        System.out.println(this.controller.showfoodtype());
        System.out.println("1. edit");
        System.out.println("2. exit");
        String choice = this.getChoice();

        switch (choice) {
            case "1":
            case "edit":
                String mokh = this.getInput("enter new location");
                this.controller.editlocation(Integer.parseInt(mokh));
                System.out.println("edited successfully");
                break;
            case "2":
            case "exit":
                break;
            default:
                System.out.println(Message.INVALID_CHOICE);

        }
        this.option();

    }

    private void lcation() {
        System.out.println(this.controller.showlocation());
        System.out.println("1. edit");
        System.out.println("2. exit");
        String choice = this.getChoice();

        switch (choice) {
            case "1":
            case "edit":
                String mokh = this.getInput("enter new location");
                this.controller.editlocation(Integer.parseInt(mokh));
                System.out.println("edited successfully");
                break;
            case "2":
            case "exit":
                break;
            default:
                System.out.println(Message.INVALID_CHOICE);

        }
        this.option();

    }

    private void Showorders() {
        ArrayList<String> orders=this.controller.showordr();
    }

    private void showmenu() {
        System.out.println("active foods:");
        for (Food food :this.controller.restaurant.activeFoods) {
            System.out.println(food);
        }
        System.out.println("deactive foods:");
        for (Food food :this.controller.restaurant.deActiveFoods) {
            System.out.println(food);
        }
        showOmenuptions();
        String choice = this.getChoice();

        switch (choice) {
            case "1":
            case "add":
                this.addfood();
                break;
            case "2":
            case "delete":
                this.deletefood();
                break;

            case "3":
            case "edit name":
                this.editname();
                break;
            case "4":
            case "edit price ":
                this.editprice();
                break;
            case "5":
            case "active":
                this.active();
            case "6":
            case "deactive":
                this.deactive();
                break;
            case "7":
            case "discount":
                this.discount();
                break;
            case "8":
            case "comment":
                this.comment();
                break;
                case "9":
            case "rate":
                this.showrate();
                break;
                case "10":
            case "exit":
                break;
            default:
                System.out.println(Message.INVALID_CHOICE);
                this.run();
        }
    }

    private void comment() {
        String Id = this.getInput("enter food Id");
        ArrayList<String> comments=controller.showcomment(Integer.parseInt(Id));
        for (String x: comments) {
            System.out.println(x);
        }
        showrespond();
        showmenu();
    }

    private void showrespond() {
        System.out.println("1. respond");
        System.out.println("2. edit");
        System.out.println("3. exit");

        String choice = this.getChoice();

        switch (choice) {
            case "1":
            case "register":
                this.register();
                break;

            case "2":
            case "login":
                this.login();
                break;

            case "3":
            case "exit":
                this.exit();
                break;
            default:
                System.out.println(Message.INVALID_CHOICE);

        }
    }

    private void showrate() {
        String Id = this.getInput("enter food Id");
        Double rate=controller.showrate(Integer.parseInt(Id));
        System.out.println("rate:"+rate);
        showmenu();
    }

    private void discount() {
        String Id = this.getInput("enter food Id");
        String percent = this.getInput("enter food percent");
        String time = this.getInput("enter food time");
        if (this.controller.restaurant.getRestaurant(Integer.parseInt(Id))!=null) {
            Message message = this.controller.setdiscount(Integer.parseInt(Id),Integer.parseInt(percent),Integer.parseInt(time));
            System.out.println(message == Message.SUCCESS ? "Activated" : message);
        }
        else{
            System.out.println("incorrect ID");
        }
        showmenu();
    }

    private void deactive() {
        String name = this.getInput("enter food Id");
        if(!this.controller.checkprogressfood(Integer.parseInt(name)).equals(Message.progressfood)) {
            String sure = this.getInput("Are you sure?");
            if (sure.equals("yes")) {
                Message message = this.controller.deactive(name);
                System.out.println(message == Message.SUCCESS ? "deactive successfully" : message);
            }
        }else {
            System.out.println("this food is in progress");
        }
        showmenu();
    }

    private void active() {
        String Id = this.getInput("enter food Id");
        if (this.controller.restaurant.getRestaurant(Integer.parseInt(Id))!=null) {
            Message message = this.controller.activefood(Integer.parseInt(Id));
            System.out.println(message == Message.SUCCESS ? "Activated" : message);
        }
        else{
            System.out.println("incorrect ID");
        }
        showmenu();
    }

    private void editprice() {
        String Id = this.getInput("enter food Id");
        String name = this.getInput("enter new price:");
        if (this.controller.restaurant.getRestaurant(Integer.parseInt(Id))!=null) {
            Message message = this.controller.editfoodprice(Integer.parseInt(name),Integer.parseInt(Id));
            System.out.println(message == Message.SUCCESS ? "price changed" : message);
        }
        else{
            System.out.println("incorrect ID");
        }
        showmenu();
    }

    private void editname() {
        String Id = this.getInput("enter food Id");
        String name = this.getInput("enter new name:");
        if (this.controller.restaurant.getRestaurant(Integer.parseInt(Id))!=null) {
            Message message = this.controller.editfoodname(name,Integer.parseInt(Id));
            System.out.println(message == Message.SUCCESS ? "name changed" : message);
        }
        else{
            System.out.println("incorrect ID");
        }
        showmenu();
    }

    private void deletefood() {
        String name = this.getInput("enter food Id");
        if(!this.controller.checkprogressfood(Integer.parseInt(name)).equals(Message.progressfood)) {
            String sure = this.getInput("Are you sure?");
            if (sure.equals("yes")) {
                Message message = this.controller.deletefood(name);
                System.out.println(message == Message.SUCCESS ? "deleted successfully" : message);
            }
        }else {
            System.out.println("this food is in progress");
        }
        showmenu();
    }

    private void addfood() {
        String name = this.getInput("enter food name");
        String price = this.getInput("enter food price");
        Message message = this.controller.addfood(name ,price);
        System.out.println(message == Message.SUCCESS ? "added successfully" : message);
        showmenu();
    }

    private void showOmenuptions() {
            System.out.println("enter one of the options");
            System.out.println("1. add");
            System.out.println("2. delete");
            System.out.println("3. edit name");
            System.out.println("4. edit price");
            System.out.println("5. active");
        System.out.println("6. deactive");
        System.out.println("7. dicount");
        System.out.println("8. comment");
        System.out.println("9. rate");
        System.out.println("10. exit");
    }

    private void showretaurants() {
        System.out.println("your restaurants:");
        for (Restaurant restaurant:user.ownedRestaurants) {
            System.out.println(restaurant);
        }
    }

    @Override
    protected void showOptions() {
        System.out.println("enter one of the options");
        System.out.println("1. menu");
        System.out.println("2. orders");
        System.out.println("3. location");
        System.out.println("4. foodtype");
        System.out.println("5. exit");
    }
}
