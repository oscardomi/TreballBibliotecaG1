import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String userID;
    private String userName;
    private String userType;
    private static final Scanner sc = new Scanner(System.in);

    //Constructors
    public User() {
        this.userID = "";
        this.userName = "";
        this.userType = "Customer";
    }
    public User(String userID, String userName) {
        this.userID = userID;
        this.userName = userName;
        this.userType = "Customer";
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

    /**
     * Adds a new user with a predefined Customer user type.
     * @param userList List of users
     */
    public static void addUser(ArrayList<User> userList) {
        System.out.println("What name do you want to give the user?");
        String name = sc.nextLine();
        userList.add(new User(String.valueOf((userList.size() + 1)), name));
    }

    /**
     * Override method that shows a user's information.
     * @return User's information.
     */
    @Override
    public String toString() {
        return "UserID: " + userID +
                "\nUsername= " + userName +
                "\nUsertype= " + userType +
                '}';
    }

    /**
     * Asks for a user ID to update the user's details.
     * @param userList List of users
     */
    public void updateUser(ArrayList<User> userList) {
        boolean userFound = false;

        //Checks if the user has permission to update information
        if (userType.equalsIgnoreCase("Customer")) {
            System.out.println("You don't have permission to update users.");
        } else {
            System.out.println("Write the ID of the user that you want to change: ");
            String oldID = sc.nextLine();

            //Searches for the user in the user arraylist
            for (User user : userList) {
                if (user.userID.equals(oldID)) {
                    userFound = true;

                    System.out.println("Enter the new name: ");
                    user.setUserName(sc.nextLine());

                    boolean validUserType = false;

                    //Ensures that the user type is amongst "Customer", "Administrator" or "Librarian".
                    do {
                        System.out.println("Enter the new user type: ");
                        String newUserType = sc.nextLine();
                        if (newUserType.equalsIgnoreCase("Customer") || newUserType.equalsIgnoreCase("Administrator") || newUserType.equalsIgnoreCase("Librarian")) {
                            user.setUserType(newUserType);
                            validUserType = true;
                        } else {
                            System.out.println("Invalid user type. Users can only be 'Customer', 'Administrator' or 'Librarian'.");
                        }

                    } while (!validUserType);

                    System.out.println("User successfully updated.");
                }
            }

            if (!userFound) {
                System.out.println("User not found.");
            }

        }

    }

    /**
     * Removes a user from the system.
     * @param userList List of users.
     */
    public void removeUser(ArrayList<User> userList){
        boolean userFound = false;

        //Checks if the user has permission to update information
        if (userType.equalsIgnoreCase("Customer")) {
            System.out.println("You don't have permission to update users.");
        } else {
            System.out.println("Write the ID of the user that you want to remove: ");
            String userID = sc.nextLine();

            //Searches for the user in the user arraylist
            for (User user : userList) {
                if (user.userID.equals(userID)) {
                    userFound = true;
                    user.removeUser(userList);
                    System.out.println("User successfully removed.");
                }
            }

            if (!userFound) {
                System.out.println("User not found.");
            }

        }
    }
}
