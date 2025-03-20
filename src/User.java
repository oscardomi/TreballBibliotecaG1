import jdk.internal.org.jline.reader.SyntaxError;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String userID;
    private String userName;
    private String userType;
    private Scanner sc = new Scanner(System.in);

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

    public java.lang.String getUserID() {
        return userID;
    }

    public void setUserID(java.lang.String userID) {
        if (userType = "Customer") {
            System.err.println("You don't have permission to change the ID.");
        } else this.userID = userID;
    }

    public java.lang.String getUserName() {
        return userName;
    }

    public void setUserName(java.lang.String userName) {
        if (userType = "Customer") {
            System.err.println("You don't have permission to change the username.");
        } else this.userName = userName;
    }

    public java.lang.String getUserType() {
        return userType;
    }

    public void setUserType(java.lang.String userType) {
        if (userType = "Customer") {
            System.err.println("You don't have permission to change the user type.");
        } else this.userType = userType;
    }

    public static void addUser(ArrayList<User> userList) {
        System.out.println("What name do you want to give the user?");
        String name = sc.nextLine();

        userList.add(new User(userList.size() + 1, name))
    }

    @Override
    public String toString() {
        return  "UserID: " + userID +  +
                "\nUsername= " + userName +
                "\nUsertype= " + userType +
                '}';
    }

    public void updateUser(){
        if (userType = "Customer"){
            System.out.println("You don't have permission to update users.");
        } else {
            System.out.println("Write the ID of the user that you want to change: ");
            String oldID = sc.toString();




        }
    }
}
