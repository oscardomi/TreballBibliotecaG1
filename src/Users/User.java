package Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    protected String userID;
    protected String userName;
    protected String userPassword;
    //todo esborrar userType
    protected String userType;
    protected static final Scanner sc = new Scanner(System.in);

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
    public User(String userID, String userName, String userPassword, String userType) {
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
        this.userType = userType;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * Adds a new user with a predefined Customer user type.
     */
    public static void addUser(List<User> userList, String name, String password) {
        userList.add(new User(String.valueOf((userList.size() + 1)), name, password));
    }


    /**
     * Override method that shows a user's information.
     *
     * @return Users.User's information.
     */
    @Override
    public String toString() {
        return "UserID: " + userID +
                "\nUsername= " + userName +
                "\nUsertype= " + userType;
    }

    public void actionMenu(){}

    public void updateUser(String newUserName, String newUserPassword){
        this.setUserName(newUserName);
        this.setUserPassword(newUserPassword);
    }

    public void updateUser(String newUserName, String newUserPassword, String newUserType){
        this.setUserName(newUserName);
        this.setUserPassword(newUserPassword);
        this.setUserType(newUserType);
    }

    //todo probablement innecessari, es pot esborrar i corregir els altres mètodes
    public static boolean userExists(List<User> userList, String userName) {
        for (User currentUser : userList) {
            if (userName.equals(currentUser.getUserName())) {
                return true;
            }
        }
        return false;
    }
    /**
     * Removes a user from the system.
     */
    public void removeUser(List<User> userList, String userToRemove) {
        userList.remove(User.searchUserByName(userList,userToRemove));
        System.out.println("User successfully removed.");
    }
    public static int searchUserByName(List<User> userList, String userName) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserName().equals(userName)) {
                return i; // Retorna la posició de l'usuari dins la llista
            }
        }
        return -1;
    }



}