package controller;

public class UserController {
    private static UserController instance = null;

    private UserController() {

    }

    private static void setInstance(UserController instance) {
        UserController.instance = instance;
    }

    public static UserController getInstance() {
        if (UserController.instance == null) {
            UserController.setInstance(new UserController());
        }

        return UserController.instance;
    }

}
