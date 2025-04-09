package Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    protected String userID;
    protected String userName;
    protected String userPassword;
    //todo esborrar userType
    protected static final Scanner sc = new Scanner(System.in);

    //Constructors
    public User() {
        this.userID = "";
        this.userName = "";
        this.userPassword = "";
    }
    public User(String userID, String userName, String userPassword) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    //Getters and setters
    public java.lang.String getUserID() {
        return userID;
    }
    public void setUserID(java.lang.String userID) {
        this.userID = userID;
    }
    public java.lang.String getUserName() {
        return userName;
    }
    public void setUserName(java.lang.String userName) {
        this.userName = userName;
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
    public static void addCustomer(List<User> userList, String name, String password, String address, boolean membership) {
        userList.add(new Customer(String.valueOf((userList.size() + 1)), name, password, address, membership));
    }

    public static void addAdministrator(List<User> userList, String name, String password, int phoneNumber, String mail) {
        userList.add(new Administrator(String.valueOf((userList.size() + 1)), name, password, phoneNumber, mail));
    }

    public static void addLibrarian(List<User> userList, String name, String password, String schedule, double salary) {
        userList.add(new Librarian(String.valueOf((userList.size() + 1)), name, password, schedule, salary));
    }

    /**
     * Override method that shows a user's information.
     *
     * @return Users.User's information.
     */
    @Override
    public String toString() {
        return "UserID: " + userID +
                "\nUsername= " + userName;
    }

    public void actionMenu(){}

    public void updateUser(String newUserName, String newUserPassword){
        this.setUserName(newUserName);
        this.setUserPassword(newUserPassword);
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