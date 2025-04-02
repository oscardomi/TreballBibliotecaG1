package Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private String userID;
    private String userName;
    private String userPassword;
    private String userType;
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

    /**
     * Adds a new user with a predefined Customer user type.
     */
    public static void addUser(List<User> userList, String name, String password) {
        userList.add(new User(String.valueOf((userList.size() + 1)), name, password));
    }

    public static void addUser(List<User> userList, String name, String password, String userType) {
        userList.add(new User(String.valueOf((userList.size() + 1)), name, password, userType));
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

    //todo probablement innecessari, es pot esborrar i corregir els altres mètodes
    public static boolean userExists(List<User> userList, String userName) {
        for (User currentUser : userList) {
            if (userName.equals(currentUser.getUserName())) {
                return true;
            }
        }
        return false;
    }

    public static int searchUserByName(List<User> userList, String userName) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserName().equals(userName)) {
                return i; // Retorna la posició de l'usuari dins la llista
            }
        }
        return -1;
    }

    /**
     * Asks for a user ID to update the user's details.
     */
    public void updateUser(ArrayList<User> userList, String newName, String newPassword, String newUserType) {
        if (User.userExists(userList, userName)) {
            userList.get(User.searchUserByName(userList, userName)).setUserName(newName);
            userList.get(User.searchUserByName(userList, userName)).setUserPassword(newPassword);
            userList.get(User.searchUserByName(userList, userName)).setUserType(newUserType);
        }
    }

    /**
     * Removes a user from the system.
     */
    public void removeUser(List<User> userList, String userToRemove) {
        userList.remove(User.searchUserByName(userList,userToRemove));
        System.out.println("Users.User successfully removed.");
    }

    public boolean isAdmin(){
        if (userType.equals("Administrator")){
            return true;
        } else return false;
    }

    public boolean isLibrarian(){
        if (userType.equals("Librarian")){
            return true;
        } else return false;
    }

    public boolean isCustomer(){
        if (userType.equals("Customer")){
            return true;
        } else return false;
    }

//    public void addRent(List<Rent> rentList) {
        //todo fer servir publicationExists() i searchPublicationBy()
        // demanar opcions i nom des d'aquí o des del main
        // data hauria de ser un String, buscar com es fa
//        Publication.Publication publication = Publication.Publication.searchPublication();
//        rentList.add(new Rent(rentList.size() + 1, this.Users.User, publication, Date.from(), Date.from() + 30));
//    }

}