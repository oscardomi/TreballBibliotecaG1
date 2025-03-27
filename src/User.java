import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String userID;
    private String userName;
    private String userPassword;
    private String userType;
    public static ArrayList<User> userList = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    //Constructors
    public User() {
        this.userID = "";
        this.userName = "";
        this.userPassword = "";
        this.userType = "Customer";
    }

    public User(String userID, String userName, String userPassword) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = "Customer";
    }

    public User(String userID, String userName, String userPassword,String userType) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = userType;
    }

    //Getters and setters
    public java.lang.String getUserID() {
        return userID;
    }
    public void setUserID(java.lang.String userID) {
        if (userType.equalsIgnoreCase("Customer")) {
            System.err.println("You don't have permission to change the ID.");
        } else this.userID = userID;
    }
    public java.lang.String getUserName() {
        return userName;
    }
    public void setUserName(java.lang.String userName) {
        if (userType.equalsIgnoreCase("Customer")) {
            System.err.println("You don't have permission to change the username.");
        } else this.userName = userName;
    }
    public java.lang.String getUserType() {
        return userType;
    }
    public void setUserType(java.lang.String userType) {
        if (userType.equalsIgnoreCase("Customer")) {
            System.err.println("You don't have permission to change the user type.");
        } else this.userType = userType;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public static ArrayList<User> getUserList() {
        return userList;
    }
    public static void setUserList(ArrayList<User> userList) {
        User.userList = userList;
    }

    /**
     * Adds a new user with a predefined Customer user type.
     */
    public static void addUser() {
        System.out.println("What name do you want to give the user?");
        String name = sc.nextLine();
        System.out.println("What password do you want to give the user?");
        String password = sc.nextLine();
        userList.add(new User(String.valueOf((userList.size() + 1)), name, password));
    }

    /**
     * Override method that shows a user's information.
     *
     * @return User's information.
     */
    @Override
    public String toString() {
        return "UserID: " + userID +
                "\nUsername= " + userName +
                "\nUsertype= " + userType;
    }

    /**
     * Asks for a user ID to update the user's details.
     */
    public void updateUser() {
        System.out.println("Enter the new name: ");
        userName = sc.nextLine();
        System.out.println("Enter the new password: ");
        userPassword = sc.nextLine();
        boolean validUserType = false;

        //Ensures that the user type is amongst "Customer", "Administrator" or "Librarian".
        do {
            System.out.println("Enter the new user type: ");
            String newUserType = sc.nextLine();
            if (newUserType.equalsIgnoreCase("Customer") || newUserType.equalsIgnoreCase("Administrator") || newUserType.equalsIgnoreCase("Librarian")) {
                userType = newUserType;
                validUserType = true;
            } else {
                System.out.println("Invalid user type. Users can only be 'Customer', 'Administrator' or 'Librarian'.");
            }

        } while (!validUserType);

        System.out.println("User successfully updated.");

    }

    /**
     * Removes a user from the system.
     */
    public void removeUser() {
        userList.remove(this);
        System.out.println("User successfully removed.");
    }

    public void addRent() {
        System.out.println("""
                   
                """);
    }
}